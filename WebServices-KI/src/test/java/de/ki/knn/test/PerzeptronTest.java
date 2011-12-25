package de.ki.knn.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.ki.PropertyAndConcept;
import de.ki.PropertyConverter;
import de.ki.learn.knn.Perzeptron;

public class PerzeptronTest {
	Perzeptron perzeptron;
	PropertyConverter propertyConverter;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		perzeptron = new Perzeptron("Stop");
		propertyConverter = new PropertyConverter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testIsPositive() {
		assertTrue(perzeptron.isPositive("Stop"));
	}
	
	@Test
	public final void testComputePropertyVector(){
		List<Integer> wights = new ArrayList<Integer>();
		wights.add(-5);
		wights.add(-4);
		wights.add(-3);
		wights.add(-2);
		wights.add(2);
		wights.add(3);
		
		perzeptron.initializeWights(wights);
		String properties = "((70,0,0,0,10),irgendein falsches Concept)";
		PropertyAndConcept propAndCon = propertyConverter.getPropertyVector(properties);
		perzeptron.computePropertyVector(propAndCon);
		
		assertEquals(-5, perzeptron.getWight(0));
	}
	
	@Test
	public final void testComputePropertyVectorRightConcept(){
		List<Integer> wights = new ArrayList<Integer>();
		wights.add(-5);
		wights.add(-4);
		wights.add(-3);
		wights.add(-2);
		wights.add(2);
		wights.add(3);
		wights.add(4);
		wights.add(5);	
		
		perzeptron.initializeWights(wights);
		String properties = "((70,0,0,0,10),Stop)";
		PropertyAndConcept propAndCon = propertyConverter.getPropertyVector(properties);
		perzeptron.computePropertyVector(propAndCon);
		
		assertEquals(65, perzeptron.getWight(0));
	}
	
	@Test
	public final void testClassify(){
		List<Integer> wights = new ArrayList<Integer>();
		wights.add(-5);
		wights.add(-4);
		wights.add(-3);
		wights.add(-2);
		wights.add(2);
		wights.add(3);
		wights.add(4);
		wights.add(5);	
		
		perzeptron.initializeWights(wights);
		String properties = "((70,0,0,0,10),Stop)";
		PropertyAndConcept propAndCon = propertyConverter.getPropertyVector(properties);
		perzeptron.computePropertyVector(propAndCon);
		perzeptron.computePropertyVector(propAndCon);
		perzeptron.computePropertyVector(propAndCon);
		perzeptron.computePropertyVector(propAndCon);
		assertEquals(true, perzeptron.classify(propAndCon));
		
	}

}
