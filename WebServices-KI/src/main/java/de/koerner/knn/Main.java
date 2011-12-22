package de.koerner.knn;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.koerner.cal2.Evaluater;
import de.koerner.cal2.EvaluaterUtil;
import de.koerner.cal2.KIModule;
import de.koerner.cal2.LearnerImpl;

public class Main {

	private static Injector injector;
	static Trainer trainer;
	static EvaluaterUtil evaluaterUtil;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		injector = Guice.createInjector(new KIModule());
		LearnerImpl learner;
		trainer = injector.getInstance(Trainer.class);
		trainer.doTrainer();
		learner = trainer.getLearner();
		
		for(int i = 0; i< 100; i++){
			trainer = injector.getInstance(Trainer.class);
			trainer.setLearner(learner);
			trainer.doTrainer();
			learner = trainer.getLearner();
		}
		
		evaluaterUtil = injector.getInstance(EvaluaterUtil.class);
		Evaluater evaluater = evaluaterUtil.getEvaluater();
		evaluater.setLearner(trainer.getLearner());
		evaluaterUtil.eval();
		System.out.println("Fehler: " + evaluater.getErrors());
		System.out.println("Richtige:" + evaluater.getCorrects());
		System.out.println("durchschnittliche Fehler:" + evaluater.getAverageError()*100 +"%");
		
		System.out.println("wahrer Fehler liegt mit achtzigprozentiger Wahrscheinlichkeit zwischen " + evaluater.getLowConfidenceInterval()*100 +" und " + evaluater.getHighConfidenceInterval()*100 +" %");
	}

}
