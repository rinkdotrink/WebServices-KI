package de.koerner.propertyvector.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
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

public class PictureConverterTest {

	PictureConverter pictureConverter;
	PixelAnalyzer pictureAnalyzer;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Before
	public void setUp() throws Exception {
		PictureProperties pictureProperty = new PictureProperties();
		pictureAnalyzer = new PixelAnalyzer(pictureProperty);
		pictureConverter = new PictureConverter(pictureAnalyzer);
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testConvertPixel() {
		File file = new File("yellow.jpg");
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		float[] pix = pictureConverter.convertPixel(bufferedImage, 0, 0);
		assertEquals(60, pix[0],60);		 
	}
	
	@Test
	public final void testConvertPicture(){
		File file = new File("yellow.jpg");
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PixelAnalyzer pictureAnalyzer = pictureConverter.convertAndAnalyzePixels(bufferedImage);
		assertNotNull(pictureAnalyzer);
	}

}
