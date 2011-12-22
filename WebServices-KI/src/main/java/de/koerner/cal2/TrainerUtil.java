package de.koerner.cal2;

import com.google.inject.Inject;

public class TrainerUtil {

	private PropertyReader propertyReader;
	private PropertyConverter propertyConverter;
	private PropertyAndConcept propAndCon;
	private Trainer trainer;

	@Inject
	public TrainerUtil(PropertyReader propertyReader,
			PropertyConverter propertyConverter, Trainer trainer) {
		this.propertyReader = propertyReader;
		this.propertyConverter = propertyConverter;
		this.trainer = trainer;
	}

	public void train() {
		readNextPropertyVector();
		while (propAndCon != null) {
			trainer.train(propAndCon);
			readNextPropertyVector();
		}
	}

	private void readNextPropertyVector() {
		String properties = propertyReader.readProperties();
		if (properties != null) {
			propAndCon = propertyConverter.getPropertyVector(properties);
		} else {
			propAndCon = null;
		}
	}
	
	public LearnerImpl getLearner(){
		return trainer.getLearner();
	}
}
