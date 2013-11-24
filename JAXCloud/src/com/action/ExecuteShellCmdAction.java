package com.action;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

import com.beans.ShellCmdBean;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.ws.commons.virtualbox_3_2.IMachine;
import com.sun.xml.ws.commons.virtualbox_3_2.IProgress;
import com.sun.xml.ws.commons.virtualbox_3_2.ISession;
import com.sun.xml.ws.commons.virtualbox_3_2.IVirtualBox;
import com.sun.xml.ws.commons.virtualbox_3_2.IWebsessionManager;

@SuppressWarnings("serial")
public class ExecuteShellCmdAction extends ActionSupport{
	private ShellCmdBean command = new ShellCmdBean();
	private String output="";

	public ShellCmdBean getCommand()
	{
		return command;
	}

	public String getOutput()
	{
		return output;
	}
	
	public void convertOutputToString() 
	{
		String path = "C:\\Eclipse\\JAXCloud\\WebContent\\shared\\output.txt";
		String s="";
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(path));	
			while((s = br.readLine())!=null)
				output = output + s + "\n";
		}
		catch(IOException e)
		{
			System.out.println("This error while populating output : "+e);
		}
	}
	
	public String executeCommand()
	{
		IWebsessionManager sessionManager = null;
		IVirtualBox vbox = null;
		ISession session = null;
		IMachine machine = null;
		String strVM = "ubuntu";
		System.out.println(command.getCommandName());
		try{        	
			sessionManager = new IWebsessionManager("http://localhost:18083/");		
			vbox = sessionManager.logon("test", "test");		
			System.out.println("Initialized connection to VirtualBox version " + vbox.getVersion());
			session = sessionManager.getSessionObject(vbox);    
			machine = vbox.findMachine(strVM);
			String uuid = machine.getId();

			Holder<Long> pid = new Holder<Long>();             
			vbox.openExistingSession(session,uuid);
			System.out.println("Session for VM " + uuid + " is opening...");  

			List<String> args = new ArrayList<String>();
			args.add(command.getCommandName());		
			System.out.println(session.getConsole().getGuest());
			IProgress oProgress = session.getConsole().getGuest().executeProcess("/JAXCloud/commands/ExecuteShellCmd", 
					(long)0, args, new ArrayList<String>(), "karthik", 
					"alliswell", (long)0, pid);
			oProgress.waitForCompletion(-1); 
			long rc = oProgress.getResultCode();
			if (rc != 0)		
				System.out.println("Command Execution failed : "+oProgress.getErrorInfo().getText());
			else
			{
				System.out.println("Command execution successful!!");
				convertOutputToString();
				System.out.println("Output : "+output);
				command.setOutput(output);
			}
			return SUCCESS;
		}
		catch (Exception e)
		{
			System.out.println(e);
			return ERROR;
		}
		finally
		{
			if (session != null && session.getState().equals("OPEN"))		
			{
				session.close();
			}
		}        	
	}
}
