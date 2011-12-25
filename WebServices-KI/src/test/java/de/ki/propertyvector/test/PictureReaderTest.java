package de.ki.propertyvector.test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.ki.propertyvector.pictureprocessing.PictureReader;

public class PictureReaderTest {
	PictureReader pictureReader;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		pictureReader = new PictureReader();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testReadPicture() {		
		assertNotNull(pictureReader.readPicture("X-10Y-10.jpg"));
	}

}
