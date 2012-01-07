package de.ki.server.learn.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PropertyReader {

   private BufferedReader in;

   public PropertyReader() {
      setFileName("inputMixed.txt");
   }

   public void setFileName(final String aFileName) {
      try {
         File file = new File(aFileName);
         in = new BufferedReader(new FileReader(file));
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }

   public String readProperties() {
      
      String line = null;
      try {
         line = in.readLine();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return line;
   }

   public void closeFile() {
      try {
         in.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
