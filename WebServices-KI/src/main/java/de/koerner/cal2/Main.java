package de.koerner.cal2;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

	private static Injector injector;
	private static TrainerUtil trainerUtil;
	private static EvaluaterUtil evaluaterUtil;
	
	public static void main(String[] args) {
		injector = Guice.createInjector(new KIModule());
		trainerUtil = injector.getInstance(TrainerUtil.class);		
		trainerUtil.train();		
		evaluaterUtil = injector.getInstance(EvaluaterUtil.class);
		Evaluater evaluater = evaluaterUtil.getEvaluater();
		evaluater.setLearner(trainerUtil.getLearner());
		evaluaterUtil.eval();
		System.out.println("Fehler: " + evaluater.getErrors());
		System.out.println("Richtige:" + evaluater.getCorrects());
		System.out.println("durchschnittliche Fehler:" + evaluater.getAverageError()*100 +"%");
		System.out.println("wahrer Fehler liegt mit achtzigprozentiger Wahrscheinlichkeit zwischen " + evaluater.getLowConfidenceInterval()*100 +" und " + evaluater.getHighConfidenceInterval()*100 +" %");
	}
	
}
