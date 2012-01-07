package de.ki.cal2.test;

import static org.junit.Assert.assertEquals;

import java.util.Vector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.ki.PropertyAndConcept;
import de.ki.PropertyConverter;

public class PropertyConverterTest {

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
      propertyConverter = new PropertyConverter();
   }

   @After
   public void tearDown()
      throws Exception {
   }

   @Test
   public final void getPropertyVectorTest() {
      String property = "((70,1,2,3,10),Vorfahrt von Rechts)";
      PropertyAndConcept propertyVectorAndConcept =
         propertyConverter.getPropertyVector(property);
      Vector<Integer> propertyVector = propertyVectorAndConcept.getProperty();
      assertEquals(new Integer(70), propertyVector.get(0));
      assertEquals(new Integer(1), propertyVector.get(1));
      assertEquals(new Integer(2), propertyVector.get(2));
      assertEquals(new Integer(3), propertyVector.get(3));
      assertEquals(new Integer(10), propertyVector.get(4));
   }

}
