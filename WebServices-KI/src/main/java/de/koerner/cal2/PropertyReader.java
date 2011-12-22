package de.koerner.cal2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PropertyReader {
	private BufferedReader in;

	public PropertyReader() {
		setFileName("PropertyVectorSorted.txt");
	}

	public void setFileName(String fileName) {
		try {
			File file = new File(fileName);
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
}
