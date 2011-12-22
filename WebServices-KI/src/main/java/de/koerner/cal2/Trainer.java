package de.koerner.cal2;

import com.google.inject.Inject;

public class Trainer {

	private LearnerImpl learner;	

	@Inject
	public Trainer(DecisionTree decisionTree) {
		this.learner = decisionTree;		
	}	
	
	public void train(PropertyAndConcept propAndCon){
		learner.learn(propAndCon);
	}
	
	public LearnerImpl getLearner(){
		return this.learner;
	}
}
