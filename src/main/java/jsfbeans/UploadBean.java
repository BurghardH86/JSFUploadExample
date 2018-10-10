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
	private UploadBeanModel uploadBeanModel;
	private String facets;

	public String getFacets() {
		facets = uploadBeanModel.printFacetsString();
		return facets;
	}

	public String upload() throws IOException {
		uploadBeanModel = new UploadBeanModel(file);
		//uploadBeanModel.writeFile();
		uploadBeanModel.readPart(file);
		return "success";
	}
	
	public String printFacets() {
		
		return uploadBeanModel.printFacetsString(); 
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}
}
