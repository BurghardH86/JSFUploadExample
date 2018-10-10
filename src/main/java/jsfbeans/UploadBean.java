package jsfbeans;


import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
		//uploadBeanModel.writeFile();
		uploadBeanModel.readPart(file);
		return "success";
	}		

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}
}
