package de.ki.server.learn;

import de.ki.PropertyAndConcept;

public interface Learner {

   public String classify(PropertyAndConcept propAndCon);

   public void learn(PropertyAndConcept propAndCon);
}
