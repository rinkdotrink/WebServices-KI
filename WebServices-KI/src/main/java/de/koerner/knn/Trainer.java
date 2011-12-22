package de.koerner.knn;

import com.google.inject.Inject;

import de.koerner.cal2.DecisionTree;
import de.koerner.cal2.LearnerImpl;
import de.koerner.cal2.Learner;
import de.koerner.cal2.PropertyAndConcept;
import de.koerner.cal2.PropertyConverter;
import de.koerner.cal2.PropertyReader;

public class Trainer implements Learner {

	LearnerImpl learner;
	PropertyReader propertyReader;
	PropertyConverter propertyConverter;
	PropertyAndConcept propAndCon;

	@Inject
	public Trainer(KNN knn, PropertyReader propertyReader,
			PropertyConverter propertyConverter) {
		this.learner = knn;
		this.propertyReader = propertyReader;
		this.propertyReader.setFileName("PropertyVectorSorted.txt");
		this.propertyConverter = propertyConverter;
	}

	private void readNextPropertyVector() {
		
		String properties = propertyReader.readProperties();
		if (properties != null) {
			propAndCon = propertyConverter.getPropertyVector(properties);
		} else {
			propAndCon = null;
		}
	}

	public void doTrainer() {
		readNextPropertyVector();
		while (propAndCon != null) {
			learn(propAndCon);
			readNextPropertyVector();
		}
	}
	
	
	
	public LearnerImpl getLearner(){
		return this.learner;
	}
	
	public void setLearner(LearnerImpl learner){
		this.learner = learner;
	}

	public String classify(PropertyAndConcept propAndCon) {
		// TODO Auto-generated method stub
		return learner.classify(propAndCon);
	}

	public void learn(PropertyAndConcept propAndCon) {
		// TODO Auto-generated method stub
		learner.learn(propAndCon);
	}

}
