package com.exam.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.exam.dao.QuestionDAO;


public class DeleteQuestionAction  extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	int qid=Integer.parseInt(request.getParameter("qid"))  ;
    	QuestionDAO qdao = new QuestionDAO();
    	boolean isDeleted=qdao.deleteQuestion(qid);
    	if(isDeleted) {
			return mapping.findForward("success");
		}
    	return mapping.findForward("failure");
    	
    }
}