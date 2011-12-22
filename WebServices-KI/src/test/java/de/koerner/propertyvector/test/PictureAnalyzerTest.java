package de.koerner.propertyvector.test;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.koerner.propertyvector.PictureConverter;
import de.koerner.propertyvector.PictureProperties;
import de.koerner.propertyvector.PixelAnalyzer;

public class PictureAnalyzerTest {

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
		PictureProperties pictureProperty = new PictureProperties();
		pictureAnalyzer = new PixelAnalyzer(pictureProperty);
		pictureConverter = new PictureConverter(pictureAnalyzer);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testAnalyzePictureYellow() {
		File file = new File("yellow.jpg");
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pictureAnalyzer = pictureConverter.convertAndAnalyzePixels(bufferedImage);
		PictureProperties pictureProperties = pictureAnalyzer.getPictureProperties();
		
		assertEquals(1, pictureProperties.getRedPixels());
		assertEquals(true, pictureProperties.getYellowPixels() > 0);
		assertEquals(1, pictureProperties.getGreenPixels());
		assertEquals(1, pictureProperties.getBluePixels());
		assertEquals(1, pictureProperties.getWhitePixels());
		assertEquals(1, pictureProperties.getBlackPixels());
	
	}
	

	@Test
	public final void testAnalyzePictureRed() {
		File file = new File("red.jpg");
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pictureAnalyzer = pictureConverter.convertAndAnalyzePixels(bufferedImage);
		PictureProperties pictureProperties = pictureAnalyzer.getPictureProperties();
		
		assertEquals(true, pictureProperties.getRedPixels() > 0);
		assertEquals(1, pictureProperties.getYellowPixels());
		assertEquals(1, pictureProperties.getGreenPixels());
		assertEquals(1, pictureProperties.getBluePixels());
		assertEquals(1, pictureProperties.getWhitePixels());
		assertEquals(1, pictureProperties.getBlackPixels());
	
	}
	
	@Test
	public final void testAnalyzePictureGreen() {
		File file = new File("green.jpg");
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pictureAnalyzer = pictureConverter.convertAndAnalyzePixels(bufferedImage);
		PictureProperties pictureProperties = pictureAnalyzer.getPictureProperties();
		
		assertEquals(1, pictureProperties.getRedPixels());
		assertEquals(1, pictureProperties.getYellowPixels());
		assertEquals(true, pictureProperties.getGreenPixels() > 0);
		assertEquals(1, pictureProperties.getBluePixels());
		assertEquals(1, pictureProperties.getWhitePixels());
		assertEquals(1, pictureProperties.getBlackPixels());
	
	}
	
	@Test
	public final void testAnalyzePictureBlue() {
		File file = new File("blue.jpg");
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pictureAnalyzer = pictureConverter.convertAndAnalyzePixels(bufferedImage);
		PictureProperties pictureProperties = pictureAnalyzer.getPictureProperties();
		
		assertEquals(1, pictureProperties.getRedPixels());
		assertEquals(1, pictureProperties.getYellowPixels());
		assertEquals(1, pictureProperties.getGreenPixels());
		assertEquals(true, pictureProperties.getBluePixels() > 0);
		assertEquals(1, pictureProperties.getWhitePixels());
		assertEquals(1, pictureProperties.getBlackPixels());	
	}
	
	@Test
	public final void testAnalyzePictureWhite() {
		File file = new File("white.jpg");
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pictureAnalyzer = pictureConverter.convertAndAnalyzePixels(bufferedImage);
		PictureProperties pictureProperties = pictureAnalyzer.getPictureProperties();
		
		assertEquals(1, pictureProperties.getRedPixels());
		assertEquals(1, pictureProperties.getYellowPixels());
		assertEquals(1, pictureProperties.getGreenPixels());
		assertEquals(1, pictureProperties.getBluePixels());
		assertEquals(true, pictureProperties.getWhitePixels() > 0);
		assertEquals(1, pictureProperties.getBlackPixels());	
	}
	
	@Test
	public final void testAnalyzePictureBlack() {
		File file = new File("black.jpg");
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pictureAnalyzer = pictureConverter.convertAndAnalyzePixels(bufferedImage);
		PictureProperties pictureProperties = pictureAnalyzer.getPictureProperties();
		
		assertEquals(1, pictureProperties.getRedPixels());
		assertEquals(1, pictureProperties.getYellowPixels());
		assertEquals(1, pictureProperties.getGreenPixels());
		assertEquals(1, pictureProperties.getBluePixels());
		assertEquals(1, pictureProperties.getWhitePixels());
		assertEquals(true, pictureProperties.getBlackPixels() > 0);	
	}

}
