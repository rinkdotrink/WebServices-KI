package de.koerner.propertyvector.test;

import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import de.koerner.cal2.DecisionTree;
import de.koerner.cal2.Evaluater;
import de.koerner.cal2.KIModule;
import de.koerner.cal2.PropertyAndConcept;
import de.koerner.cal2.PropertyConverter;
import static org.junit.Assert.*;
public class EvaluateTest {
	private Injector injector;
	Evaluater evaluater;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		injector = Guice.createInjector(new KIModule());
		evaluater = injector.getInstance(Evaluater.class);		
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public final void testEval() {
//		String properties = "((0,60,0,0,10),Vorfahrtsstraße)";
//		PropertyConverter propertyConverter = new PropertyConverter();
//		PropertyAndConcept propAndCon = propertyConverter.getPropertyVector(properties);		
//		evaluater.eval(propAndCon);
//		assertEquals(1, evaluater.getErrors());
//	}
//	
//	@Test
//	public final void testEval2() {
//		String properties = "((70,0,0,0,10),Vorfahrt von Rechts)";
//		PropertyConverter propertyConverter = new PropertyConverter();
//		PropertyAndConcept propAndCon = propertyConverter.getPropertyVector(properties);
//		evaluater.eval(propAndCon);
//		
//		String properties2 = "((80,0,0,0,10),Vorfahrt von Rechts)";
//		propertyConverter = new PropertyConverter();
//		propAndCon = propertyConverter.getPropertyVector(properties2);
//		evaluater.eval(propAndCon);
//		
//		String properties3 = "((80,0,0,0,0),Vorfahrt von Rechts)";
//		propertyConverter = new PropertyConverter();
//		propAndCon = propertyConverter.getPropertyVector(properties3);
//		evaluater.eval(propAndCon);
//		assertEquals(3, evaluater.getErrors());
//	}
	
	
	

}
