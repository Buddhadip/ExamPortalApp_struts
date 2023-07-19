package com.exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.exam.dao.*;
import com.exam.form.*;

public class LoginAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginForm loginForm = (LoginForm) form;
        String username = loginForm.getEmail();
        String password = loginForm.getUroll();

        LoginDAO loginDAO = new LoginDAO();
        String userRole = loginDAO.isValidCredentials(username, password);
        String userId=loginDAO.getIdByEmail(username);   
        String uname=loginDAO.getNameByEmail(username);
        if (userRole != null) {
            // Valid role returned
        	HttpSession session = request.getSession();
        	session.setAttribute("username",username);
        	session.setAttribute("uid",userId);
        	session.setAttribute("uname",uname);
        	
            if (userRole.equalsIgnoreCase("admin")) {
                // Perform actions for admin role
            	session.setAttribute("userrole", "admin");
                System.out.println("User is an admin");
                return mapping.findForward("adminHome");
            } else if (userRole.equalsIgnoreCase("student")) {
                // Perform actions for student role
            	session.setAttribute("userrole", "student");
                System.out.println("User is a student");
                return mapping.findForward("studHome");
            }
        } else {
            // Invalid username, password, or role
            System.out.println("Invalid credentials or role");
        }
        
     // Login failed, redirect back to login page
        System.out.println("LOGIN FAILED");
        return mapping.findForward("loginPage");
    }
}