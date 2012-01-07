package de.ki.propertyvector.pictureprocessing;

public class PixelAnalyzer {

   PictureProperties pictureProperties;
   int redPixels = 1;
   int yellowPixels = 1;
   int greenPixels = 1;
   int bluePixels = 1;
   int whitePixels = 1;
   int blackPixels = 1;

   public PixelAnalyzer(PictureProperties pictureProperties) {
      this.pictureProperties = pictureProperties;
   }

   public void clearPixelAnalyzer() {
      redPixels = 1;
      yellowPixels = 1;
      greenPixels = 1;
      bluePixels = 1;
      whitePixels = 1;
      blackPixels = 1;
   }

   public void analyzePixel(float[] hsvPixel) {
      countRedPixels(hsvPixel);
      countYellowPixels(hsvPixel);
      countGreenPixels(hsvPixel);
      countBluePixels(hsvPixel);
      countWhitePixels(hsvPixel);
      countBlackPixels(hsvPixel);
      setPixelNumberInPictureProperties();
   }

   private void setPixelNumberInPictureProperties() {
      pictureProperties.setRedPixels(redPixels);
      pictureProperties.setYellowPixels(yellowPixels);
      pictureProperties.setGreenPixels(greenPixels);
      pictureProperties.setBluePixels(bluePixels);
      pictureProperties.setWhitePixels(whitePixels);
      pictureProperties.setBlackPixels(blackPixels);
   }

   public void countRedPixels(float[] hsvPixel) {
      boolean notWhite = hsvPixel[1] > 0.1;
      if ((hsvPixel[0] >= 330 || hsvPixel[0] < 30) & notWhite) {
         redPixels++;
      }
   }

   public void countYellowPixels(float[] hsvPixel) {
      if (hsvPixel[0] >= 30 & hsvPixel[0] < 90) {
         yellowPixels++;
      }
   }

   public void countGreenPixels(float[] hsvPixel) {
      if (hsvPixel[0] >= 90 & hsvPixel[0] < 150) {
         greenPixels++;
      }
   }

   public void countBluePixels(float[] hsvPixel) {
      if (hsvPixel[0] >= 210 & hsvPixel[0] < 270) {
         bluePixels++;
      }
   }

   public void countWhitePixels(float[] hsvPixel) {
      boolean notBlack = (hsvPixel[2] >= 0.9 & hsvPixel[2] <= 1);
      if ((hsvPixel[1] >= 0 & hsvPixel[1] < 0.1) & notBlack) {
         whitePixels++;
      }
   }

   public void countBlackPixels(float[] hsvPixel) {
      if (hsvPixel[2] >= 0 & hsvPixel[2] < 0.7) {
         blackPixels++;
      }
   }

   public PictureProperties getPictureProperties() {
      clearPixelAnalyzer();
      return pictureProperties;
   }
}
