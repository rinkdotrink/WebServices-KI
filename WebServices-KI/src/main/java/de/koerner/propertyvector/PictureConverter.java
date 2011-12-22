package de.koerner.propertyvector;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class PictureConverter {
	PixelAnalyzer pixelAnalyzer;
	
	public PictureConverter(PixelAnalyzer pixelAnalyzer){
		this.pixelAnalyzer = pixelAnalyzer;
	}
	
	public PixelAnalyzer convertAndAnalyzePixels(BufferedImage bufferedImage){
		int heigth = bufferedImage.getHeight();
		int width = bufferedImage.getWidth();
		for(int row=0; row < heigth; row = row + 1){
			for(int column=0; column < width; column = column + 1){
				float[] value = convertPixel(bufferedImage, row, column);
//				float[] value = {(float)1,(float)1,(float)1,(float)1};
				pixelAnalyzer.analyzePixel(value);
			}
		}		
		return pixelAnalyzer;
	}
	
	public float[] convertPixel(BufferedImage bufferedImage, int row, int column){
//		Color color = new Color(bufferedImage.getRGB(column,row));
		int argb = bufferedImage.getRGB(column,row);
	
		int red   = (argb >> 16) & 0xff; 
		int green = (argb >> 8)  & 0xff; 
		int blue  = (argb)       & 0xff;
		
//		int hsv = bufferedImage.getRGB(column, row);
		
//		float[] hsbValue = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);		
		float[] hsbValue = Color.RGBtoHSB(red, green, blue, null);
		hsbValue[0] = hsbValue[0] * 360;
		return hsbValue;
	}
}