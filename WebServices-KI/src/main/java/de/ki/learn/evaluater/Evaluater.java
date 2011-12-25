package de.ki.learn.evaluater;

import de.ki.PropertyAndConcept;
import de.ki.learn.Learner;

public class Evaluater {

	private Learner learner;
	private int errors = 0;
	private int corrects = 0;

	public void eval(PropertyAndConcept propAndCon) {
		String computedConcept = learner.classify(propAndCon);
		countErrors(computedConcept, propAndCon.getConcept());
	}

	public void setLearner(Learner learner) {
		this.learner = learner;
	}

	public int getErrors() {
		return errors;
	}

	public int getCorrects() {
		return corrects;
	}

	public float getAverageError() {
		float avg = (float) errors / (float) (errors + corrects);
		return avg;
	}

	public double getLowConfidenceInterval() {
		float avg = getAverageError();
		// mit einer Wahrscheinlichkeit von 80% liegt der wahre Fehler
		// zwischen..
		float total = errors + corrects;
		float radiant = avg * (1 - avg) / (total);
		double sqrt = Math.sqrt(radiant);
		double eightyPercent = 1.28 * sqrt;
		double conInterval = getAverageError() - eightyPercent;
		return conInterval;
	}

	public double getHighConfidenceInterval() {
		float avg = getAverageError();
		// mit einer Wahrscheinlichkeit von 80% liegt der wahre Fehler
		// zwischen..
		float total = errors + corrects;
		float radiant = avg * (1 - avg) / (total);
		double sqrt = Math.sqrt(radiant);
		double eightyPercent = 1.28 * sqrt;
		double conInterval = getAverageError() + eightyPercent;
		return conInterval;
	}

	private void countErrors(String conceptComputet, String concept) {
		if (!conceptComputet.equalsIgnoreCase(concept)) {
			errors++;
			System.out.println("Fehler! Actual: " + conceptComputet +"Expected" + concept);
		} else {
			System.out.println("Richtig! " + conceptComputet);
			corrects++;
		}
	}
}
