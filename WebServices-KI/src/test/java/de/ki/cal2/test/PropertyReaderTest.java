package de.ki.cal2.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.ki.learn.reader.PropertyReader;

public class PropertyReaderTest {

	PropertyReader propertyReader;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		propertyReader = new PropertyReader();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testReadProperty() {
		String propertyExpected = "((90,0,0,0,0),Vorfahrt gewaehren)";
//		String propertyExpected = "((80,0,0,0,10),Vorfahrt von Rechts)";
		String propertyActual = propertyReader.readProperties();
		propertyActual = propertyReader.readProperties();
		System.out.println(propertyActual);
		assertTrue(propertyActual.compareTo(propertyExpected) == 0);
	}

}
