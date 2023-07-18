package com.exam.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.exam.dao.UserDAO;
import com.exam.form.SignupForm;

public class StudentPageAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	try {
    		HttpSession session = request.getSession(false);
    		String role= (String) session.getAttribute("userrole");
    		if(role=="admin") {
    			UserDAO udao= new UserDAO();
    			List<SignupForm> studentlist = udao.getAllStudents();
    			for(SignupForm s: studentlist) {
    				System.out.println(s);
    			}
    			System.out.println(studentlist);
    			request.setAttribute("studentlist", studentlist);
    			request.setAttribute("studentlist", studentlist);
    			return mapping.findForward("success");
    		}else {
    			return mapping.findForward("failure");
    		}
    	}catch(Exception e) {
    		return mapping.findForward("failure");
    	}
    }
}