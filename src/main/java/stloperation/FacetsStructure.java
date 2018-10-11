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

	public int getFacetNumber() {
		return facetNumber;
	}

	public void setFacetNumber(int facetNumber) {
		this.facetNumber = facetNumber;
	}

	public double getFacetNormalX() {
		return facetNormalX;
	}

	public void setFacetNormalX(double facetNormalX) {
		this.facetNormalX = facetNormalX;
	}

	public double getFacetNormalY() {
		return facetNormalY;
	}

	public void setFacetNormalY(double facetNormalY) {
		this.facetNormalY = facetNormalY;
	}

	public double getFacetNormalZ() {
		return facetNormalZ;
	}

	public void setFacetNormalZ(double facetNormalZ) {
		this.facetNormalZ = facetNormalZ;
	}

	public double getFacetFirstPointX() {
		return facetFirstPointX;
	}

	public void setFacetFirstPointX(double facetFirstPointX) {
		this.facetFirstPointX = facetFirstPointX;
	}

	public double getFacetFirstPointY() {
		return facetFirstPointY;
	}

	public void setFacetFirstPointY(double facetFirstPointY) {
		this.facetFirstPointY = facetFirstPointY;
	}

	public double getFacetFirstPointZ() {
		return facetFirstPointZ;
	}

	public void setFacetFirstPointZ(double facetFirstPointZ) {
		this.facetFirstPointZ = facetFirstPointZ;
	}

	public double getFacetSecondPointX() {
		return facetSecondPointX;
	}

	public void setFacetSecondPointX(double facetSecondPointX) {
		this.facetSecondPointX = facetSecondPointX;
	}

	public double getFacetSecondPointY() {
		return facetSecondPointY;
	}

	public void setFacetSecondPointY(double facetSecondPointY) {
		this.facetSecondPointY = facetSecondPointY;
	}

	public double getFacetSecondPointZ() {
		return facetSecondPointZ;
	}

	public void setFacetSecondPointZ(double facetSecondPointZ) {
		this.facetSecondPointZ = facetSecondPointZ;
	}

	public double getFacetThirdPointX() {
		return facetThirdPointX;
	}

	public void setFacetThirdPointX(double facetThirdPointX) {
		this.facetThirdPointX = facetThirdPointX;
	}

	public double getFacetThirdPointY() {
		return facetThirdPointY;
	}

	public void setFacetThirdPointY(double facetThirdPointY) {
		this.facetThirdPointY = facetThirdPointY;
	}

	public double getFacetThirdPointZ() {
		return facetThirdPointZ;
	}

	public void setFacetThirdPointZ(double facetThirdPointZ) {
		this.facetThirdPointZ = facetThirdPointZ;
	}
	
	
}
