package de.ki.learn.trainer;

import com.google.inject.Inject;

import de.ki.PropertyAndConcept;
import de.ki.PropertyConverter;
import de.ki.learn.Learner;
import de.ki.learn.reader.PropertyReader;

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
	
	public Learner getLearner(){
		return trainer.getLearner();
	}
}
