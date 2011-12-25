package de.ki.learn.trainer;

import com.google.inject.Inject;

import de.ki.PropertyAndConcept;
import de.ki.learn.Learner;

public class Trainer {

	private Learner learner;	

	@Inject
	public Trainer(Learner learner) {
		this.learner = learner;		
	}	
	
	public void train(PropertyAndConcept propAndCon){
		learner.learn(propAndCon);
	}
	
	public Learner getLearner(){
		return this.learner;
	}
}
