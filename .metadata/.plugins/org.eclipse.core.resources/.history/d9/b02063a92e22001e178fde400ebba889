package com.exam.action;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.exam.dao.UserDAO;
import com.exam.form.FileUploadForm;
import com.exam.form.UserForm;
import com.exam.service.ReadCSV;

public class UploadCsvAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
				System.out.println(form);
				FileUploadForm fileUploadForm = (FileUploadForm)form;
			    FormFile file = fileUploadForm.getFile();	
			    System.out.println(file.getFileName());
			    String fileContent = readFileContent(file);

		        // Print the file content
		        System.out.println("File Content:\n" + fileContent);
		        
		        ReadCSV rcsv=new ReadCSV(fileContent);
		        ArrayList<UserForm> data = rcsv.getData();
		        UserDAO udao = new UserDAO();
		        for( UserForm uf: data) {
		        	System.out.println(uf.toString());
		        	if(uf.getName()!=null && uf.getEmail()!=null && uf.getRoll()!=null) {
		        		boolean isUpdated=udao.addUser(uf.getName(),uf.getEmail(),uf.getRoll(),"Student");
		        	}
		        }
			    
			    
				return mapping.findForward("success");
		
	}
	
	private String readFileContent(FormFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder fileContent = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            fileContent.append(line).append("\n");
        }

        reader.close();
        inputStream.close();

        return fileContent.toString();
    }
}