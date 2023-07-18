package com.exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.exam.dao.ExamDAO;
import com.exam.form.ExamForm;

public class EditExamAction  extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	ExamForm eform = (ExamForm)form;
    	System.out.println(eform);
	    ExamDAO edao = new ExamDAO();
	    edao.editExam(eform);	   
	    return mapping.findForward("success");
    }
}