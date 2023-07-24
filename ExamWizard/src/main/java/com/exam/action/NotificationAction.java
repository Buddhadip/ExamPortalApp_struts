package com.exam.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.exam.dao.NotificationDAO;
import com.exam.dao.ResultDAO;
import com.exam.dto.NotificationDTO;
import com.exam.dto.ResultDTO;
import com.exam.form.NotificationForm;
import com.exam.form.ResultForm;

public class NotificationAction  extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    		HttpSession session = request.getSession(false);
    		String role= (String) session.getAttribute("userrole");
    		if(role=="admin") {
    			NotificationDAO ndao = new NotificationDAO();
    			List<NotificationForm> nlist =  ndao.retrieveNotificationForms();
    			List<NotificationDTO> ntfcs = new ArrayList<>();
    			
    			ResultDAO rdao = new ResultDAO();
    			for(NotificationForm n : nlist) {
    				ResultDTO rdto =  rdao.getResultByRid(n.getRid());
    				NotificationDTO ndto = new NotificationDTO(n.getNid(),rdto);
    				ntfcs.add(ndto);
    			}
    			
    			System.out.println(nlist);
    			request.setAttribute("notifications",ntfcs);
    			return mapping.findForward("success");
    		}else {
    			return mapping.findForward("failure");
    		}
    	
    }
}