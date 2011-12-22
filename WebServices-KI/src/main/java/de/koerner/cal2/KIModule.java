package de.koerner.cal2;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import de.koerner.knn.KNN;

public class KIModule extends AbstractModule{

    @Override
    protected void configure() {
		bind(PropertyReader.class).in(Singleton.class);
		bind(PropertyConverter.class).in(Singleton.class);
		bind(Trainer.class).in(Singleton.class);
		bind(TrainerUtil.class).in(Singleton.class);
		bind(EvaluaterUtil.class).in(Singleton.class);
//		bind(LearnerImpl.class).to(DecisionTree.class).in(Singleton.class);
		bind(Learner.class).to(KNN.class).in(Singleton.class);
    }
}
