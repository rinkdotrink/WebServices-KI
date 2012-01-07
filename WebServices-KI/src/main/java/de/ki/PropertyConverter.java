package de.ki;

import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Pattern;

public class PropertyConverter {

   public PropertyAndConcept getPropertyVector(final String property) {
      Vector<Integer> propertyVector = new Vector<Integer>();
      String concept = "";
      StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
      while (stringTokenizer.hasMoreTokens()) {
         String propertyValue = stringTokenizer.nextToken();
         String propertyValueWithoutOpenBrackets =
            propertyValue.replace("(", "");
         String propertyValueWithoutBrackets =
            propertyValueWithoutOpenBrackets.replace(")", "");
         String propertyValueWithoutSpace = propertyValueWithoutBrackets.trim();

         if (Pattern.matches("\\d*", propertyValueWithoutSpace)) {
            propertyVector.add(new Integer(propertyValueWithoutSpace));
         } else {
            concept = propertyValueWithoutSpace;
         }
      }
      PropertyAndConcept propertyVectorAndConcept =
         getPropertyAndConcept(propertyVector, concept);
      return propertyVectorAndConcept;
   }

   private PropertyAndConcept getPropertyAndConcept(Vector<Integer> aPropertyVector,
                                                    String aConcept) {
      PropertyAndConcept propertyVectorAndConcept = new PropertyAndConcept();

      propertyVectorAndConcept.setPropertyVector(aPropertyVector);
      propertyVectorAndConcept.setConcept(aConcept);

      return propertyVectorAndConcept;
   }

}
