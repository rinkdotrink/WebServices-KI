package de.ki.knn.test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.ki.PropertyAndConcept;
import de.ki.PropertyConverter;
import de.ki.server.learn.knn.KNN;

public class KNNTest {

   KNN knn;
   PropertyConverter propertyConverter;

   @BeforeClass
   public static void setUpBeforeClass()
      throws Exception {
   }

   @AfterClass
   public static void tearDownAfterClass()
      throws Exception {
   }

   @Before
   public void setUp()
      throws Exception {
      knn = new KNN();
      propertyConverter = new PropertyConverter();
   }

   @After
   public void tearDown()
      throws Exception {
   }

   @Test
   public final void testVorfahrtVonRechts() {
      String properties = "((70,0,0,0,10),Vorfahrt von Rechts)";
      PropertyAndConcept propAndCon =
         propertyConverter.getPropertyVector(properties);
      knn.doKNNLearnAlgorithmen(propAndCon);
      assertEquals("Vorfahrt von Rechts", knn.classify(propAndCon));
   }

   @Test
   public final void testVorfahrtGewaehren() {
      String properties = "((90,0,0,0,0),Vorfahrt gewaehren)";
      PropertyAndConcept propAndCon =
         propertyConverter.getPropertyVector(properties);
      knn.doKNNLearnAlgorithmen(propAndCon);
      assertEquals("Vorfahrt gewaehren", knn.classify(propAndCon));
   }

   @Test
   public final void testStop() {
      String properties = "((90,0,0,0,0),Stop)";
      PropertyAndConcept propAndCon =
         propertyConverter.getPropertyVector(properties);
      knn.doKNNLearnAlgorithmen(propAndCon);
      assertEquals("Stop", knn.classify(propAndCon));
   }

   @Test
   public final void testFahrtrichtungLinks() {
      String properties = "((0,10,0,30,40),Fahrtrichtung links)";
      PropertyAndConcept propAndCon =
         propertyConverter.getPropertyVector(properties);
      knn.doKNNLearnAlgorithmen(propAndCon);
      assertEquals("Fahrtrichtung links", knn.classify(propAndCon));
   }

   @Test
   public final void testFahrtrichtungRechts() {
      String properties = "((0,10,0,30,50),Fahrtrichtung rechts)";
      PropertyAndConcept propAndCon =
         propertyConverter.getPropertyVector(properties);
      knn.doKNNLearnAlgorithmen(propAndCon);
      assertEquals("Fahrtrichtung rechts", knn.classify(propAndCon));
   }

   @Test
   public final void testVorfahrtsstrasse() {
      String properties = "((0,60,0,0,10),Vorfahrtsstrasse)";
      PropertyAndConcept propAndCon =
         propertyConverter.getPropertyVector(properties);
      knn.doKNNLearnAlgorithmen(propAndCon);
      assertEquals("Vorfahrtsstrasse", knn.classify(propAndCon));
   }

}
