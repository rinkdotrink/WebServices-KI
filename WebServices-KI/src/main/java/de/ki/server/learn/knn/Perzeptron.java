package de.ki.server.learn.knn;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import de.ki.PropertyAndConcept;

public class Perzeptron {

   List<Integer> wights;
   String concept;

   public Perzeptron(String concept) {
      wights = new ArrayList<Integer>();
      wights.add(-5);
      wights.add(-4);
      wights.add(-3);
      wights.add(-2);
      wights.add(2);
      wights.add(3);
      this.concept = concept;
   }

   public void initializeWights(List<Integer> wights) {
      this.wights = wights;
   }

   public void computePropertyVector(PropertyAndConcept propAndCon) {
      Vector<Integer> property;
      property = propAndCon.getProperty();
      if (isPositive(propAndCon.getConcept())) {
         for (int index = 0; index < 6; index++) {
            if (index == 5) {
               computeWightMulXPositive(index, 1);
            } else {
               computeWightMulXPositive(index, property.get(index));
            }
         }
      } else {
         for (int index = 0; index < 6; index++) {
            if (index == 5) {
               computeWightMulXNegative(index, 1);
            } else {
               computeWightMulXNegative(index, property.get(index));
            }
         }
      }
   }

   public boolean isPositive(String concept) {
      return this.concept.equalsIgnoreCase(concept);
   }

   public void computeWightMulXPositive(int index, int x) {
      int product = wights.get(index) * x;
      if (product < 0) {
         int wight = wights.get(index) + x;
         wights.set(index, wight);
      }
   }

   public void computeWightMulXNegative(int index, int x) {
      int product = wights.get(index) * x;
      if (product > 0) {
         int wight = wights.get(index) - x;
         wights.set(index, wight);
      }
   }

   public int getWight(int index) {
      return wights.get(index);
   }

   public boolean classify(PropertyAndConcept propAndCon) {
      Vector<Integer> property;
      property = propAndCon.getProperty();
      int sum = 0;
      for (int index = 0; index < 6; index++) {
         if (index == 5) {
            // sum += getProduct(index, wights.get(index));
            sum += getProduct(index, 1);
         } else {
            sum += getProduct(index, property.get(index));
         }
      }
      return sum > 0;
   }

   public int getProduct(int index, int value) {
      return wights.get(index) * value;
   }
}
