package de.koerner.cal2;

import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Pattern;

public class PropertyConverter {

	public PropertyAndConcept getPropertyVector(String property) {
		Vector<Integer> propertyVector = new Vector<Integer>();
		String concept ="";
		StringTokenizer stringTokenizer = new StringTokenizer(property, ",");
		while (stringTokenizer.hasMoreTokens()) {
			String propertyValue = stringTokenizer.nextToken();
			String propertyValueWithoutOpenBrackets = propertyValue.replace(
					"(", "");
			String propertyValueWithoutBrackets = propertyValueWithoutOpenBrackets
					.replace(")", "");
			String propertyValueWithoutSpace = propertyValueWithoutBrackets.trim();
			
					
			if (Pattern.matches("\\d*", propertyValueWithoutSpace)) {
				propertyVector.add(new Integer(propertyValueWithoutSpace));
			} else {
				concept = propertyValueWithoutSpace;
			}
		}
		PropertyAndConcept propertyVectorAndConcept = new PropertyAndConcept();

		propertyVectorAndConcept.setPropertyVector(propertyVector);
		propertyVectorAndConcept.setConcept(concept);
		return propertyVectorAndConcept;
	}

}
