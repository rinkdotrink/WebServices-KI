package de.ki.server.learn.trainer;

import com.google.inject.Inject;

import de.ki.PropertyAndConcept;
import de.ki.server.learn.Learner;

public class Trainer {

   private Learner learner;

   @Inject
   public Trainer(final Learner aLearner) {
      this.learner = aLearner;
   }

   public void train(final PropertyAndConcept aPropAndCon) {
      learner.learn(aPropAndCon);
   }

   public Learner getLearner() {
      return this.learner;
   }
}
