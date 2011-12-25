package de.ki.propertyvector.pictureprocessing;

public class PictureProperties {

	private int redPixels = 1;
	private int yellowPixels = 1;
	private int greenPixels = 1;
	private int bluePixels = 1;
	private int whitePixels = 1;
	private int blackPixels = 1;
	
	public int getAllPixelWithoutWhite(){
		int allPixel = redPixels + yellowPixels + greenPixels + bluePixels + blackPixels;
		return allPixel;
	}
	
	public void clearPictureProperties(){
		redPixels = 1;
		yellowPixels = 1;
		greenPixels = 1;
		bluePixels = 1;
		whitePixels = 1;
		blackPixels = 1;
	}
	

	private int getRasterizedValue(double value){
		int rasterizedValue = 0;
		if (value >= 0 & value < 10){
			rasterizedValue = 0;
		} else if (value >= 10 & value < 20){
			rasterizedValue = 10;
		} else if (value >= 20 & value < 30){
			rasterizedValue = 20;
		} else if (value >= 30 & value < 40){
			rasterizedValue = 30;
		} else if (value >= 40 & value < 50){
			rasterizedValue = 40;
		} else if (value >= 50 & value < 60){
			rasterizedValue = 50;
		} else if (value >= 60 & value < 70){
			rasterizedValue = 60;
		} else if (value >= 70 & value < 80){
			rasterizedValue = 70;
		} else if (value >= 80 & value < 90){
			rasterizedValue = 80;
		} else if (value >= 90 & value <= 100){
			rasterizedValue = 90;
		}
		
		return rasterizedValue;
	}
	
	public int getRedInPercentRasterized(){
		double redInPercent = 100 * redPixels / getAllPixelWithoutWhite();
		return getRasterizedValue(redInPercent);				
	}	
	
	public int getYellowInPercentRasterized(){
		double yellowInPercent = 100 * yellowPixels / getAllPixelWithoutWhite();
		return getRasterizedValue(yellowInPercent);				
	}
	
	public int getGreenInPercentRasterized(){
		double greenInPercent = 100 * greenPixels / getAllPixelWithoutWhite();
		return getRasterizedValue(greenInPercent);				
	}
	
	public int getBlueInPercentRasterized(){
		double blueInPercent = 100 * bluePixels / getAllPixelWithoutWhite();
		return getRasterizedValue(blueInPercent);				
	}
	
	public int getWhiteInPercentRasterized(){
		double whiteInPercent = 100 * whitePixels / getAllPixelWithoutWhite();
		return getRasterizedValue(whiteInPercent);				
	}
	
	public int getBlackInPercentRasterized(){
		double blackInPercent = 100 * blackPixels / getAllPixelWithoutWhite();
		return getRasterizedValue(blackInPercent);				
	}
	
	public int getRedPixels() {
		return redPixels;
	}
	public void setRedPixels(int redPixels) {
		this.redPixels = redPixels;
	}
	public int getYellowPixels() {
		return yellowPixels;
	}
	public void setYellowPixels(int yellowPixels) {
		this.yellowPixels = yellowPixels;
	}
	public int getGreenPixels() {
		return greenPixels;
	}
	public void setGreenPixels(int greenPixels) {
		this.greenPixels = greenPixels;
	}
	public int getBluePixels() {
		return bluePixels;
	}
	public void setBluePixels(int bluePixels) {
		this.bluePixels = bluePixels;
	}
	public int getWhitePixels() {
		return whitePixels;
	}
	public void setWhitePixels(int whitePixels) {
		this.whitePixels = whitePixels;
	}
	public int getBlackPixels() {
		return blackPixels;
	}
	public void setBlackPixels(int blackPixels) {
		this.blackPixels = blackPixels;
	}	
}
