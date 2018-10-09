package jsfbeans;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

//Controller class

@ManagedBean
@SessionScoped
public class UploadBean {
	
	private Part file;
	@SuppressWarnings("unused")
	private String fileContent;

	public String upload() throws IOException {
		UploadBeanModel uploadBeanModel = new UploadBeanModel(file);		
		uploadBeanModel.writeFile();		
		return "success";
	}		

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}
}
