package de.ki;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import de.ki.learn.Learner;
import de.ki.learn.evaluater.EvaluaterUtil;
import de.ki.learn.knn.KNN;
import de.ki.learn.reader.PropertyReader;
import de.ki.learn.trainer.Trainer;
import de.ki.learn.trainer.TrainerUtil;

public class KIModule extends AbstractModule{

    @Override
    protected void configure() {
		bind(PropertyReader.class).in(Singleton.class);
		bind(PropertyConverter.class).in(Singleton.class);
		bind(Trainer.class).in(Singleton.class);
		bind(TrainerUtil.class).in(Singleton.class);
		bind(EvaluaterUtil.class).in(Singleton.class);
//		bind(Learner.class).to(DecisionTree.class).in(Singleton.class);
		bind(Learner.class).to(KNN.class).in(Singleton.class);
    }
}
