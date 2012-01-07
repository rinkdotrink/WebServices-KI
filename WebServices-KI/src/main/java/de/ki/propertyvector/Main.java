package de.ki.propertyvector;

import de.ki.propertyvector.pictureprocessing.PictureConverter;
import de.ki.propertyvector.pictureprocessing.PictureProperties;
import de.ki.propertyvector.pictureprocessing.PictureReader;
import de.ki.propertyvector.pictureprocessing.PixelAnalyzer;
import de.ki.propertyvector.reader.FolderReader;
import de.ki.propertyvector.writer.PropertyWriter;

public class Main {

   /**
    * @param args
    */
   public static void main(String[] args) {

      PropertyWriter propertyWriter = new PropertyWriter();
      PictureProperties pictureProperties = new PictureProperties();
      PixelAnalyzer pixelAnalyzer = new PixelAnalyzer(pictureProperties);
      PictureConverter pictureConverter = new PictureConverter(pixelAnalyzer);
      PictureReader pictureReader = new PictureReader();

      FolderReader folderReader =
         new FolderReader(propertyWriter, pictureProperties, pixelAnalyzer,
                          pictureConverter, pictureReader);
      folderReader.readFolder("C:/Verkehrszeichen/102 - Vorfahrt von Rechts/0/80x60/",
                              "Vorfahrt von Rechts");
      folderReader.readFolder("C:/Verkehrszeichen/205 - Vorfahrt gewähren/0/80x60",
                              "Vorfahrt gewähren");
      folderReader.readFolder("C:/Verkehrszeichen/206 - Stop/0/80x60", "Stop");
      folderReader.readFolder("C:/Verkehrszeichen/209 - Fahrtrichtung links/0/80x60",
                              "Fahrtrichtung links");
      folderReader.readFolder("C:/Verkehrszeichen/209 - Fahrtrichtung rechts/0/80x60",
                              "Fahrtrichtung rechts");
      folderReader.readFolder("C:/Verkehrszeichen/306 - Vorfahrtsstraße/0/80x60",
                              "Vorfahrtsstraße");

      // folderReader.readFolder("C:/Verkehrszeichen/102 - Vorfahrt von Rechts/");

   }

}
