package jsfbeans;


import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.Part;

//Controller class

@ManagedBean
@SessionScoped
public class UploadBean {
	
	private Part file;
	private UploadBeanModel uploadBeanModel;
	private String facets;
	
	private List<Object> facetsList;
	
	private DataModel<Object> facetsDataModel;
        
	public DataModel<Object> getFacetsDataModel() {
		facetsList = getFacetsList();
		if (facetsDataModel == null)
	 		  facetsDataModel = new ListDataModel<Object>(facetsList);

	 	   return facetsDataModel;
	}

	public List<Object> getFacetsList() {
		facetsList = uploadBeanModel.getFacetsList();
		return facetsList;
	}	

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
	
	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}
}
