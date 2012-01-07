package de.ki.server.learn.trainer;

import com.google.inject.Inject;

import de.ki.PropertyAndConcept;
import de.ki.PropertyConverter;
import de.ki.server.learn.Learner;
import de.ki.server.learn.reader.PropertyReader;

public class TrainerUtil {

   private PropertyReader propertyReader;
   private PropertyConverter propertyConverter;
   private PropertyAndConcept propAndCon;
   private Trainer trainer;

   @Inject
   public TrainerUtil(final PropertyReader aPropertyReader,
                      final PropertyConverter aPropertyConverter, final Trainer aTrainer) {
      this.propertyReader = aPropertyReader;
      this.propertyConverter = aPropertyConverter;
      this.trainer = aTrainer;
   }

   public void train() {
      propertyReader.setFileName("inputMixed.txt");
      readNextPropertyVector();
      while (propAndCon != null) {
         trainer.train(propAndCon);
         readNextPropertyVector();
      }
      propertyReader.closeFile();
   }

   private void readNextPropertyVector() {
      String properties = propertyReader.readProperties();
      if (properties != null) {
         propAndCon = propertyConverter.getPropertyVector(properties);
      } else {
         propAndCon = null;
      }
   }

   public Learner getLearner() {
      return trainer.getLearner();
   }
}
