package de.ki.propertyvector.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import de.ki.propertyvector.pictureprocessing.PictureProperties;

public class PropertyWriter {
	FileWriter writer;
	File file;
	String filename = "PropertyVector.txt";
	
	
	public PropertyWriter(){
		
	}
	
	public void setFilename(String filename){
		this.filename = filename;
	}
	
	public void writePropertyVector(PictureProperties pictureProperties, String konzept) {
		file = new File(filename);
		
		try {
			writer = new FileWriter(file, true);	
			writer.write("((" + pictureProperties.getRedInPercentRasterized() + ","
					+ pictureProperties.getYellowInPercentRasterized() + ","
					+ pictureProperties.getGreenInPercentRasterized() + ","
					+ pictureProperties.getBlueInPercentRasterized() + ","
//					+ pictureProperties.getWhiteInPercent() + ","
					+ pictureProperties.getBlackInPercentRasterized() + "),"+ konzept +")"
			);

			writer.write(System.getProperty("line.separator"));
			writer.flush();
			writer.close();
			
			pictureProperties.clearPictureProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}