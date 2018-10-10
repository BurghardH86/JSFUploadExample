package jsfbeans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.Part;

public class UploadBeanModel {
	private Part file;
	private InputStream inputStream;
	
	private Charset charset = StandardCharsets.US_ASCII;
	
	public UploadBeanModel(Part file) throws IOException {
		this.file = file;
		this.inputStream = this.file.getInputStream();
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
	
	public void readPart(Part part) {
		//BufferedReader inputPart = new BufferedReader(new FileReader(part));
//		try {
//			InputStreamReader inputStream = new InputStreamReader(part.getInputStream());
//			inputStream.
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			String line = convert(inputStream, charset);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
	}
	
	public String convert(InputStream inputStream, Charset charset) throws IOException {
		 
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset))) {	
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
				System.out.println(line);
				//Store the facets now?
			}
		}
	 
		return stringBuilder.toString();
	}
	

}
