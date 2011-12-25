package de.ki.propertyvector.reader;

import java.awt.image.BufferedImage;
import java.io.File;

import de.ki.propertyvector.pictureprocessing.PictureConverter;
import de.ki.propertyvector.pictureprocessing.PictureProperties;
import de.ki.propertyvector.pictureprocessing.PictureReader;
import de.ki.propertyvector.pictureprocessing.PixelAnalyzer;
import de.ki.propertyvector.writer.PropertyWriter;

public class FolderReader {

	PropertyWriter propertyWriter;
	PictureProperties pictureProperty;
	PixelAnalyzer pixelAnalyzer;
	PictureConverter pictureConverter;
	PictureReader pictureReader;
	String konzept;

	public FolderReader(PropertyWriter propertyWriter,
			PictureProperties pictureProperty, PixelAnalyzer pixelAnalyzer,
			PictureConverter pictureConverter, PictureReader pictureReader) {
		this.propertyWriter = propertyWriter;
		this.pictureProperty = pictureProperty;
		this.pixelAnalyzer = pixelAnalyzer;
		this.pictureConverter = pictureConverter;
		this.pictureReader = pictureReader;
		
	}

	public void readFolder(String path, String konzept) {
		this.konzept = konzept;
		File dir = new File(path);		
		travereDir(dir);
	}

	public void travereDir(File dir) {
		File[] files = dir.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					travereDir(files[i]);
				} else {
					processPicture(files, i);
				}
			}
		}
	}

	public void processPicture(File[] files, int i) {
		System.out.println(files[i].getAbsolutePath());
		BufferedImage bufferedImage = pictureReader.readPicture(files[i]
				.getAbsolutePath());
		pixelAnalyzer = pictureConverter.convertAndAnalyzePixels(bufferedImage);
		PictureProperties pictureProperties = pixelAnalyzer
				.getPictureProperties();
		propertyWriter.writePropertyVector(pictureProperties, konzept);
	}
}
