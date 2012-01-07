package de.ki.propertyvector.sorting;

import java.util.ArrayList;
import java.util.List;

import de.ki.PropertyAndConcept;
import de.ki.PropertyConverter;
import de.ki.propertyvector.writer.PropertyWriter;
import de.ki.propertyvector.writer.StringWriter;
import de.ki.server.learn.reader.PropertyReader;

public class PropertySort {

   PropertyReader propertyReader;
   StringWriter stringWriter;
   PropertyConverter propertyConverter;
   List<String> propStop = new ArrayList<String>();
   List<String> propVorfahrtVonRechts = new ArrayList<String>();
   List<String> propFahrtrichtungLinks = new ArrayList<String>();
   List<String> propFahrtrichtungRechts = new ArrayList<String>();
   List<String> propVorfahrtsstrasse = new ArrayList<String>();
   List<String> propVorfahrtGewaehren = new ArrayList<String>();

   public PropertySort() {
      propertyReader = new PropertyReader();
      stringWriter = new StringWriter();
      stringWriter.setFilename("PropertyVectorSorted.txt");
      propertyConverter = new PropertyConverter();
   }

   public void doPropertySort() {
      readAndSortProperties();
      writeProperties();
   }

   public void readAndSortProperties() {
      propertyReader.setFileName("PropertyVector.txt");
      String line = propertyReader.readProperties();
      while (line != null) {
         sortProperties(line);
         line = propertyReader.readProperties();
      }
   }

   public void sortProperties(String line) {
      PropertyAndConcept propAndCon = propertyConverter.getPropertyVector(line);
      if (propAndCon.getConcept().equalsIgnoreCase("Stop")) {
         propStop.add(line);
      } else if (propAndCon.getConcept().equalsIgnoreCase("Vorfahrt von Rechts")) {
         propVorfahrtVonRechts.add(line);
      } else if (propAndCon.getConcept().equalsIgnoreCase("Fahrtrichtung links")) {
         propFahrtrichtungLinks.add(line);
      } else if (propAndCon.getConcept().equalsIgnoreCase("Fahrtrichtung rechts")) {
         propFahrtrichtungRechts.add(line);
      } else if (propAndCon.getConcept().equalsIgnoreCase("Vorfahrtsstrasse")) {
         propVorfahrtsstrasse.add(line);
      } else if (propAndCon.getConcept().equalsIgnoreCase("Vorfahrt gewaehren")) {
         propVorfahrtGewaehren.add(line);
      }
   }

   public void writeProperties() {
      for (int i = 0; i < (propVorfahrtGewaehren.size()); i++) {
         propStop.get(i);
         stringWriter.writeLine(propVorfahrtVonRechts.get(i));
         stringWriter.writeLine(propFahrtrichtungLinks.get(i));
         stringWriter.writeLine(propFahrtrichtungRechts.get(i));
         stringWriter.writeLine(propVorfahrtsstrasse.get(i));
         stringWriter.writeLine(propVorfahrtGewaehren.get(i));
      }

   }

   //

}
