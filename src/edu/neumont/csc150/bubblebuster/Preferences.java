package edu.neumont.csc150.bubblebuster;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

public abstract class Preferences implements Serializable {
	private static final long serialVersionUID = -7086584903501314806L;
	
	private static final Properties properties = new Properties(); // TODO: consider setting up a default properties file
	public static boolean musicEnabled, soundFXEnabled;
	public static String skinFolderLocation, ambianceFolderLocation, cursorImageFile;
	
	public static void save() throws IOException {
		properties.setProperty("MusicEnabled", musicEnabled + "");
		properties.setProperty("SoundFXEnabled", soundFXEnabled + "");
		properties.setProperty("SkinFolderLocation", skinFolderLocation + "");
		properties.setProperty("AmbianceFolderLocation", ambianceFolderLocation + "");
		properties.setProperty("CursorImageLocation", cursorImageFile + "");
		properties.store(new FileWriter(new File("bubblebuster.properties")), "");
	}
	public static void load() throws FileNotFoundException, IOException {
		properties.load(new FileReader(new File("bubblebuster.properties")));
		musicEnabled = Boolean.parseBoolean(properties.getProperty("MusicEnabled"));
		soundFXEnabled = Boolean.parseBoolean(properties.getProperty("SoundFXEnabled"));
		skinFolderLocation = properties.getProperty("SkinFolderLocation");
		ambianceFolderLocation = properties.getProperty("AmbianceFolderLocation");
		cursorImageFile = properties.getProperty("CursorImageLocation");
	}
	
	public static void printAllFields() {
		System.out.println(soundFXEnabled);
		System.out.println(musicEnabled);
		System.out.println(skinFolderLocation);
		System.out.println(ambianceFolderLocation);
		System.out.println(cursorImageFile);
	}
}