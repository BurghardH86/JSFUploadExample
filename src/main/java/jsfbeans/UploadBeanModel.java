package jsfbeans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import stloperation.*;

import javax.servlet.http.Part;

//Modell class
public class UploadBeanModel {
	private Part file;
	private InputStream inputStream;	
	private Charset charset = StandardCharsets.US_ASCII;
	private List<Object> facetsList = new ArrayList<Object>();
	
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
	
	public void readPart(Part part) throws IOException {
		String line = null;
		String[] subLine = null;
		
		int counter = 1;
		int vertexCounter = 0;
		
		FacetsStructure facet = new FacetsStructure();		
		
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset))) {	
			while ((line = bufferedReader.readLine()) != null) {
				if (line.startsWith("solid") != true) {
					if (line.startsWith("facet normal")) {
						//if line is facet normal then cut "facet normal" away 
						// and add the three coordinates to FacetsStructure
						facet = new FacetsStructure();
						facet.facetNumber = counter;
						subLine = line.split(" ");
						facet.facetNormalX = Double.parseDouble(subLine[2]);
						facet.facetNormalY = Double.parseDouble(subLine[3]);
						facet.facetNormalZ = Double.parseDouble(subLine[4]);						
					} else if (line.startsWith("vertex")) {
						//If line is one of the vertex then add the three coordinates to FacetsStructure
						vertexCounter++;
						subLine = line.split(" ");
						switch (vertexCounter) {
						case 1:
							facet.facetFirstPointX = Double.parseDouble(subLine[1]);
							facet.facetFirstPointY = Double.parseDouble(subLine[2]);
							facet.facetFirstPointZ = Double.parseDouble(subLine[3]);
							break;
						case 2:
							facet.facetSecondPointX = Double.parseDouble(subLine[1]);
							facet.facetSecondPointY = Double.parseDouble(subLine[2]);
							facet.facetSecondPointZ = Double.parseDouble(subLine[3]);
							break;
						case 3:
							facet.facetThirdPointX = Double.parseDouble(subLine[1]);
							facet.facetThirdPointY = Double.parseDouble(subLine[2]);
							facet.facetThirdPointZ = Double.parseDouble(subLine[3]);
							//If last coordinate was added then add struct to facetsList and start overs
							facetsList.add(facet);
							counter++;
							vertexCounter = 0;
							break;
						default:
							break;
						}
					}										
				}								
			}			
		}
		//printFacets();
	}
	
	public void printFacets() {
		FacetsStructure facet = new FacetsStructure();
		for (int i = 0; i < facetsList.size(); i++) {
			facet = (FacetsStructure) facetsList.get(i);
			System.out.println(facet.toString());
		}
	}
	
	public String printFacetsString() {
		String outputString = "";
		FacetsStructure facet = new FacetsStructure();
		for (int i = 0; i < facetsList.size(); i++) {
			facet = (FacetsStructure) facetsList.get(i);
			outputString += facet.toString();
		}
		return outputString;
	}
	
	@SuppressWarnings("null")
	public String[] printFacetsStringArr() {
		String[] outputString = null;
		FacetsStructure facet = new FacetsStructure();
		for (int i = 0; i < facetsList.size(); i++) {
			facet = (FacetsStructure) facetsList.get(i);
			outputString[i] = facet.toString();
		}
		return outputString;
	}
}
