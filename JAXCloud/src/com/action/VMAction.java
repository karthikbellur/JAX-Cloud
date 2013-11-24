package com.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Holder;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.beans.InputBean;
import com.beans.OutputBean;
import com.beans.VMBean;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.ws.commons.virtualbox_3_2.IGuest;
import com.sun.xml.ws.commons.virtualbox_3_2.IMachine;
import com.sun.xml.ws.commons.virtualbox_3_2.IProgress;
import com.sun.xml.ws.commons.virtualbox_3_2.ISession;
import com.sun.xml.ws.commons.virtualbox_3_2.IVirtualBox;
import com.sun.xml.ws.commons.virtualbox_3_2.IWebsessionManager;

@SuppressWarnings("serial")
public class VMAction extends ActionSupport implements ServletRequestAware{
	private VMBean vmBean = new VMBean();
	private InputBean input = new InputBean();
	private OutputBean output = new OutputBean();
	private String sharedFolder = "C:\\Eclipse\\JAXCloud\\WebContent\\shared\\";
	private HttpServletRequest req;
	
	public InputBean getInput()
	{
		return input;
	}
	
	public OutputBean getOutput()
	{
		return output;
	}

	public String uploadFile()
	{
		try
		{		
			/*sharedFolder = req.getRealPath("/shared");
			System.out.println(sharedFolder);*/
			String fullFileName = sharedFolder + input.getUploadFileName();
			System.out.println(fullFileName);
			File theFile = new File(fullFileName);		
			theFile.createNewFile();	
			//the uploaded file by the client is then copied to the file created above on the server side
			FileUtils.copyFile(input.getUpload(), theFile);
			return Action.SUCCESS;
		}
		catch(IOException e)
		{
			addActionError("Error while uploading file...Retry/Contact Admin");
			System.out.println("This Error while uploading file "+e);
			return Action.ERROR;
		}
	}

	public String execute()
	{
		IWebsessionManager sessionManager = null;
		IVirtualBox vbox = null;
		ISession session = null;
		IMachine machine = null;
		IGuest guest = null;
		String strVM = null;
		String filename = input.getUploadFileName().split("\\.")[0];
		String outputFilename = "shared/" + filename + ".txt";
		
		String res = uploadFile();
		if(res.equals(Action.ERROR))
			return Action.ERROR;

		//os->vmname mapping
		if(input.getOs().equals("Microsoft Windows XP"))
		{
			addActionError("Microsoft Windows XP is not being supported currently");
			return Action.INPUT;
		}
		else if(input.getOs().equals("Ubuntu"))
		{
			strVM = "ubuntu";
		}
		else if(input.getOs().equals("Open Solaris"))
		{
			strVM = "osol";
		}

		sessionManager = new IWebsessionManager("http://localhost:18083/");		
		vbox = sessionManager.logon("test", "test");		
		System.out.println("Initialized connection to VirtualBox version " + vbox.getVersion());

		try
		{
			session = sessionManager.getSessionObject(vbox);         
			try
			{
				machine = vbox.findMachine(strVM);	
			}
			catch (Exception e)
			{
				addActionError("Error while loading VM...Contact Admin");
				System.out.println("Error with findMachine() : "+e);
			}

			if (machine == null)
			{
				System.out.println("Error: can't find VM \"" + strVM + "\"");
				addActionError("Error booting VM..Please Retry/Comtact Admin");
				return Action.INPUT;
			}
			
			String uuid = machine.getId();
			String sessionType = "gui";
			String env = "DISPLAY=:0.0";     
			Holder<Long> pid = new Holder<Long>();             
			IProgress progress = null;
			List<String> args = new ArrayList<String>();
			int rc = -1;

			progress = vbox.openRemoteSession( session, uuid, sessionType, env);                
			System.out.println("Session for VM " + uuid + " is opening...");  
			progress.waitForCompletion(10000);                
			rc = progress.getResultCode();
			if (rc != 0)
				System.out.println("Session failed!");
			else
			{
				session.getMachine().setMemorySize((long)500);
				session.getMachine().saveSettings();
				guest = session.getConsole().getGuest();
				guest.setCredentials("karthik", "alliswell", "", true);
			}

			args.add(filename);		
			long startTime = System.nanoTime();
			progress = guest.executeProcess("/JAXCloud/commands/ExecuteCProg", 
					(long)0, args, new ArrayList<String>(), "karthik", 
					"alliswell", (long)0, pid);
			progress.waitForCompletion(-1); 
			rc = progress.getResultCode();
			if (rc != 0)	
			{
				System.out.println("Command Execution failed : "+progress.getErrorInfo().getText());
				addActionError("Command Execution on selected platform failed..Retry/Contact Admin");
				return Action.INPUT;
			}
			double estimatedTime = ( System.nanoTime() - startTime )/Math.pow(10, 9);
			System.out.println("Command executed successfully!");
			output.setOs(input.getOs());
			output.setInputFile(input.getUploadFileName());
			output.setEstimatedTime(estimatedTime);
			output.setMachineId(uuid);
			output.setMemoryAllocated(machine.getMemorySize());
			output.setOutputFilename(outputFilename);
			return Action.SUCCESS;
		}
		catch (Exception e)
		{
			addActionError("Error while executing command...Retry/Contact Admin");
			System.out.println(e);
			return Action.INPUT;
		}
		finally
		{
			vmBean.setSessionManager(sessionManager);
			vmBean.setVBox(vbox);
			vmBean.setMachine(machine);
			vmBean.setSession(session);        	
			if (session != null && session.getState().equals("OPEN"))		
			{
				session.close();
			}
		}        
	}

	@Override
	public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}
}
