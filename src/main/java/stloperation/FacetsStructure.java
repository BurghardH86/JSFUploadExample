package stloperation;

public class FacetsStructure {
	
	public int facetNumber;
	
	public double facetNormalX;
	public double facetNormalY;
	public double facetNormalZ;
	
	public double facetFirstPointX;
	public double facetFirstPointY;
	public double facetFirstPointZ;
	
	public double facetSecondPointX;
	public double facetSecondPointY;
	public double facetSecondPointZ;
	
	public double facetThirdPointX;
	public double facetThirdPointY;
	public double facetThirdPointZ;
	
	public FacetsStructure() {
		
		facetNumber = 0;
		facetNormalX = 0.0;
		facetNormalY = 0.0;
		facetNormalZ = 0.0;
		
		facetFirstPointX = 0.0;
		facetFirstPointY = 0.0;
		facetFirstPointZ = 0.0;
		
		facetSecondPointX = 0.0;
		facetSecondPointY = 0.0;
		facetSecondPointZ = 0.0;
		
		facetThirdPointX = 0.0;
		facetThirdPointY = 0.0;
		facetThirdPointZ = 0.0;		
	}
	
	public String toString() {
		String returnString = "";
		returnString += "[";
		returnString += "Facet : " + String.valueOf(facetNumber) + "/ ";
		returnString += "(" + String.valueOf(facetNormalX) + ", "+ String.valueOf(facetNormalY) + ", "+ String.valueOf(facetNormalZ) + ") ";
		returnString += "(" + String.valueOf(facetFirstPointX) + ", "+ String.valueOf(facetFirstPointY) + ", "+ String.valueOf(facetFirstPointZ) + ") ";
		returnString += "(" + String.valueOf(facetSecondPointX) + ", "+ String.valueOf(facetSecondPointY) + ", "+ String.valueOf(facetSecondPointZ) + ") ";
		returnString += "(" + String.valueOf(facetThirdPointX) + ", "+ String.valueOf(facetThirdPointY) + ", "+ String.valueOf(facetThirdPointZ) + ") ";
		returnString += "]\n";
		return returnString;		
	}
}
