package de.koerner.propertyvector.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.koerner.propertyvector.PictureConverter;
import de.koerner.propertyvector.PictureProperties;
import de.koerner.propertyvector.PixelAnalyzer;
import de.koerner.propertyvector.PropertyWriter;

public class PropertyWriterTest {

	PropertyWriter propertyWriter;
	PixelAnalyzer pictureAnalyzer;
	PictureConverter pictureConverter;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		propertyWriter = new PropertyWriter();
		
		PictureProperties pictureProperty = new PictureProperties();
		pictureAnalyzer = new PixelAnalyzer(pictureProperty);
		pictureConverter = new PictureConverter(pictureAnalyzer);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test() {
		File file = new File("X-10Y-10.jpg");
//		File file = new File("rb.jpg");
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pictureAnalyzer = pictureConverter.convertAndAnalyzePixels(bufferedImage);
		PictureProperties pictureProperties = pictureAnalyzer.getPictureProperties();
		propertyWriter.writePropertyVector(pictureProperties, "Konzept xy");
		
	}

}
