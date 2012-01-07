package de.ki;

import com.google.inject.AbstractModule;

import de.ki.server.learn.Learner;
import de.ki.server.learn.cal2.DecisionTree;
import de.ki.server.learn.evaluater.EvaluaterUtil;
import de.ki.server.learn.reader.PropertyReader;
import de.ki.server.learn.trainer.Trainer;
import de.ki.server.learn.trainer.TrainerUtil;

public class KIModule
   extends AbstractModule {

   @Override
   protected void configure() {
      bind(PropertyReader.class);
      bind(PropertyConverter.class);
      bind(Trainer.class);
      bind(TrainerUtil.class);
      bind(EvaluaterUtil.class);
      bind(Learner.class).to(DecisionTree.class);
      bind(KI.class);
//    bind(Learner.class).to(KNN.class);
   }
}
