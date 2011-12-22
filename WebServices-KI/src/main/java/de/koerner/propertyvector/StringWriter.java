package de.koerner.propertyvector;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StringWriter {
	FileWriter writer;
	File file;
	String filename = "PropertyVectorSorted.txt";
	
	
	public StringWriter(){
		
	}
	
	public void setFilename(String filename){
		this.filename = filename;
	}
	
	public void writeLine(String line) {
		file = new File(filename);
		
		try {
			writer = new FileWriter(file, true);	
			writer.write(line);

			writer.write(System.getProperty("line.separator"));
			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}