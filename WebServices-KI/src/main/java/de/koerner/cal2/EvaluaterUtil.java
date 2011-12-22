package de.koerner.cal2;

import com.google.inject.Inject;

public class EvaluaterUtil {

	private PropertyAndConcept propAndCon;
	private PropertyReader propertyReader;
	private PropertyConverter propertyConverter;
	private Evaluater evaluater;

	@Inject
	public EvaluaterUtil(PropertyReader propertyReader,
			PropertyConverter propertyConverter, Evaluater evaluater) {
		this.propertyReader = propertyReader;
		this.propertyReader.setFileName("unbekanntes.txt");
		this.propertyConverter = propertyConverter;
		this.evaluater = evaluater;
	}

	public void eval() {
		readNextPropertyVector();
		while (propAndCon != null) {
			evaluater.eval(propAndCon);
			readNextPropertyVector();
		}
	}
	
	public Evaluater getEvaluater(){
		return evaluater;
	}
	
	private void readNextPropertyVector() {
		String properties = propertyReader.readProperties();
		if (properties != null) {
			propAndCon = propertyConverter.getPropertyVector(properties);
		} else {
			propAndCon = null;
		}
	}
}
