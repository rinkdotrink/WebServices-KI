package de.ki;

import java.util.Vector;

public class PropertyAndConcept {

	private Vector<Integer> propertyVector;
	private String concept;

	public Vector<Integer> getProperty() {
		return propertyVector;
	}

	public void setPropertyVector(Vector<Integer> propertyVector) {
		this.propertyVector = propertyVector;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

}
