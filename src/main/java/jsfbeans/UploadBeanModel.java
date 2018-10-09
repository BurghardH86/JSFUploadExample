package jsfbeans;

import java.io.IOException;

import javax.servlet.http.Part;

public class UploadBeanModel {
	private Part file;
	
	public UploadBeanModel(Part file) {
		this.file = file;
	}
	
	public void writeFile() throws IOException {
		file.write("C:\\TempFileDir\\" + getFilename(file));
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

}
