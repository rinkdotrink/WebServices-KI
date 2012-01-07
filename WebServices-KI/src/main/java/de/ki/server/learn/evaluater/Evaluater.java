package de.ki.server.learn.evaluater;

import de.ki.PropertyAndConcept;
import de.ki.server.learn.Learner;

public class Evaluater {

   private Learner learner;
   private int errors = 0;
   private int corrects = 0;

   public void eval(final PropertyAndConcept aPropAndCon) {
      String computedConcept = learner.classify(aPropAndCon);
      countErrors(computedConcept, aPropAndCon.getConcept());
   }

   public void setLearner(final Learner aLearner) {
      this.learner = aLearner;
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
      float total = errors + corrects;
      float radiant = avg * (1 - avg) / (total);
      double sqrt = Math.sqrt(radiant);
      double eightyPercent = 1.28 * sqrt;
      double conInterval = getAverageError() - eightyPercent;
      return conInterval;
   }

   public double getHighConfidenceInterval() {
      float avg = getAverageError();
      float total = errors + corrects;
      float radiant = avg * (1 - avg) / (total);
      double sqrt = Math.sqrt(radiant);
      double eightyPercent = 1.28 * sqrt;
      double conInterval = getAverageError() + eightyPercent;
      return conInterval;
   }

   private void countErrors(final String aConceptComputet, final String aConcept) {
      if (!aConceptComputet.equalsIgnoreCase(aConcept)) {
         errors++;
         System.out.println("Fehler! Actual: " + aConceptComputet + "Expected"
            + aConcept);
      } else {
         System.out.println("Richtig! " + aConceptComputet);
         corrects++;
      }
   }
}
