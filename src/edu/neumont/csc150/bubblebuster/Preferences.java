package edu.neumont.csc150.bubblebuster;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

public abstract class Preferences implements Serializable {
	private static final long serialVersionUID = -7086584903501314806L;
	
	private static final Properties properties = new Properties();
	public static boolean musicEnabled, soundFXEnabled;
	public static String skinFolderLocation, ambianceFolderLocation;
	
	public static void save() {
		properties.setProperty("MusicEnabled", musicEnabled + "");
		properties.setProperty("SoundFXEnabled", soundFXEnabled + "");
		properties.setProperty("SkinFolderLocation", skinFolderLocation + "");
		properties.setProperty("AmbianceFolderLocation", ambianceFolderLocation + "");
		
		try {
			properties.store(new FileWriter(new File("bubblebuster.properties")), "");
		} 
		catch (IOException e) {
			e.printStackTrace(); // Should never really happen
		}
	}
	/**
	 * Tries to load a currently existing preferences file.  If no such file exists, the file will be created with defaults.
	 */
	public static void load() {
		try {
			properties.load(new FileReader(new File("bubblebuster.properties")));
			musicEnabled = Boolean.parseBoolean(properties.getProperty("MusicEnabled"));
			soundFXEnabled = Boolean.parseBoolean(properties.getProperty("SoundFXEnabled"));
			skinFolderLocation = properties.getProperty("SkinFolderLocation");
			ambianceFolderLocation = properties.getProperty("AmbianceFolderLocation");
		}
		catch (IOException e) {
			Preferences.musicEnabled = true;
			Preferences.soundFXEnabled = true;
			Preferences.skinFolderLocation = "resources/skins/default";
			Preferences.ambianceFolderLocation = "resources/ambiance/default";
			Preferences.save();
		}
	}
	
	public static void printAllFields() {
		System.out.println(soundFXEnabled);
		System.out.println(musicEnabled);
		System.out.println(skinFolderLocation);
		System.out.println(ambianceFolderLocation);
	}
}