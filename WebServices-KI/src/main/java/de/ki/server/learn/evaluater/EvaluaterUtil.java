package de.ki.server.learn.evaluater;

import com.google.inject.Inject;

import de.ki.PropertyAndConcept;
import de.ki.PropertyConverter;
import de.ki.server.learn.Learner;
import de.ki.server.learn.reader.PropertyReader;

public class EvaluaterUtil {

   private PropertyAndConcept propAndCon;
   private PropertyReader propertyReader;
   private PropertyConverter propertyConverter;
   private Evaluater evaluater;

   @Inject
   public EvaluaterUtil(final PropertyReader aPropertyReader,
                        final PropertyConverter aPropertyConverter, final Evaluater aEvaluater) {
      this.propertyReader = aPropertyReader;
      this.propertyConverter = aPropertyConverter;
      this.evaluater = aEvaluater;
   }

   public void eval(final Learner aLearner) {
      propertyReader.setFileName("unbekanntes.txt");
      evaluater.setLearner(aLearner);
      readNextPropertyVector();
      while (propAndCon != null) {
         evaluater.eval(propAndCon);
         readNextPropertyVector();
      }
      propertyReader.closeFile();

   }

   public Evaluater getEvaluater() {
      return evaluater;
   }

   private void readNextPropertyVector() {
      String properties = propertyReader.readProperties();
      if (properties != null) {
         propAndCon = propertyConverter.getPropertyVector(properties);
      } else {
         propAndCon = null;
      }
   }
}
