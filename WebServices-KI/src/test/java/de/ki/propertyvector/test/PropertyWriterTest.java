package de.ki.propertyvector.test;

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

import de.ki.propertyvector.pictureprocessing.PictureConverter;
import de.ki.propertyvector.pictureprocessing.PictureProperties;
import de.ki.propertyvector.pictureprocessing.PixelAnalyzer;
import de.ki.propertyvector.writer.PropertyWriter;

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
