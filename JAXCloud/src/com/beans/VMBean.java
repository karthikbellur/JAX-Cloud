package com.beans;

import com.sun.xml.ws.commons.virtualbox_3_2.IMachine;
import com.sun.xml.ws.commons.virtualbox_3_2.ISession;
import com.sun.xml.ws.commons.virtualbox_3_2.IVirtualBox;
import com.sun.xml.ws.commons.virtualbox_3_2.IWebsessionManager;

public class VMBean {
	
	private IWebsessionManager SessionManager;
    private IVirtualBox VBox;
    private ISession session;
    private IMachine machine;
    
	public ISession getSession() {
		return session;
	}
	public void setSession(ISession session) {
		this.session = session;
	}
	public IMachine getMachine() {
		return machine;
	}
	public void setMachine(IMachine machine) {
		this.machine = machine;
	}
	public IWebsessionManager getSessionManager() {
		return SessionManager;
	}
	public void setSessionManager(IWebsessionManager sessionManager) {
		SessionManager = sessionManager;
	}
	public IVirtualBox getVBox() {
		return VBox;
	}
	public void setVBox(IVirtualBox vBox) {
		VBox = vBox;
	}
}
