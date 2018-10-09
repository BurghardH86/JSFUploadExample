package jsfbeans;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

@ManagedBean
@SessionScoped
public class UploadBean {
	
	private Part file;
	@SuppressWarnings("unused")
	private String fileContent;

	public String upload() throws IOException {
//		try {
//			fileContent = new Scanner(file.getInputStream()).useDelimiter("\\A").next();
//		} catch (IOException e) {
//			// Error handling
//		}
		file.write("C:\\TempFileDir\\" + getFilename(file));
		return "success";
	}	
	
	private static String getFilename(Part part) {
		String substringOfFilename = null;
		for (String elementOfHeader : part.getHeader("content-disposition").split(";")) {
			if (elementOfHeader.trim().startsWith("filename")) {
				int positionOfFilenameSubstring = elementOfHeader.indexOf('=') + 1;
				substringOfFilename = elementOfHeader.substring(positionOfFilenameSubstring);
				substringOfFilename = substringOfFilename.trim().replace("\"", "");
				substringOfFilename = substringOfFilename.substring(substringOfFilename.lastIndexOf('/') + 1);
				substringOfFilename = substringOfFilename.substring(substringOfFilename.lastIndexOf('\\') + 1);
				return substringOfFilename;
				
			}
		}
		return substringOfFilename;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}
	
	public void validateFile(FacesContext ctx, UIComponent comp, Object value) {
		List<FacesMessage> msgs = new ArrayList<FacesMessage>();
		Part file = (Part)value;
		if (file.getSize() > 1024) {
			msgs.add(new FacesMessage("file too big"));
		}
		if (!"text/plain".equals(file.getContentType())) {
			msgs.add(new FacesMessage("not a text file"));
		}
		if (!msgs.isEmpty()) {
			throw new ValidatorException(msgs);
		}
	}
}
