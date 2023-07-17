package com.exam.form;

import org.apache.struts.action.ActionForm;

public class SignupForm extends ActionForm{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uid;
    private String uname;
    private String uroll;
    private String urole;
    private String email;

    
	 public String toString() {
	        return "User [ Name = "+this.uname+" , Roll = "+this.uroll+" , Email = "+this.email+" ]";
	  }
	
    
    // Getters and setters
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUroll() {
		return uroll;
	}
	public void setUroll(String uroll) {
		this.uroll = uroll;
	}
	public String getUrole() {
		return urole;
	}
	public void setUrole(String urole) {
		this.urole = urole;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
