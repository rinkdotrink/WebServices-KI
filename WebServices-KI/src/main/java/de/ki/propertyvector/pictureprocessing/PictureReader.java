package de.ki.propertyvector.pictureprocessing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PictureReader {

   public BufferedImage readPicture(String path) {
      File file = new File(path);
      BufferedImage bufferedImage = null;
      try {
         bufferedImage = ImageIO.read(file);
      } catch (IOException e) {
         e.printStackTrace();
      }
      return bufferedImage;
   }
}