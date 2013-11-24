package com.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import com.beans.LoginBean;
import com.opensymphony.xwork2.ActionSupport;
import com.service.LoginService;

/* This class is responsible for all system functionalities involving login */

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements SessionAware,ServletRequestAware {
	
	private LoginBean loginBean = new LoginBean();
	private LoginService loginService = new LoginService();
	private HttpServletRequest req;
	@SuppressWarnings("rawtypes")
	private Map session;
	private String res;
	
	//setters and getters
	public void setSession(@SuppressWarnings("rawtypes") Map session) {
		this.session = session;
	}
	
	public void setServletRequest(HttpServletRequest r) {
		req = r;
	}
	
	public LoginBean getUser() {
		return loginBean;
	}

	@SuppressWarnings("unchecked")
	public String doLogin() {   //adds the new logged in user to session	
		session.put("user", loginBean);
		return res;
	}

	public void validate() {	//validating the entered user name and password
		try {			
			if (hasErrors())
				return;
			loginBean.setPwd(CryptoUtils.encrypt(loginBean.getPwd()));
			res = loginService.verify(loginBean);
			if (res.equals(INPUT))
				addActionError("Entered Username or Password is incorrect");			
		} catch (Exception e) {
			addActionError("There was a problem while trying to login.Please Contact Admin");			
		}
	}
	
	public String doLogout() {			//logout the user - invalidate the session
		HttpSession session = req.getSession(false);
		System.out.println("invalidating session " + session);		
		if (session != null)
			session.invalidate();
		return SUCCESS;
	}
}
