package de.koerner.cal2;

public interface Learner {

	public String classify(PropertyAndConcept propAndCon);
	
	public void learn(PropertyAndConcept propAndCon);
}
