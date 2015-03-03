package edu.neumont.csc150.bubblebuster;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Preferences implements Serializable {
	private static final long serialVersionUID = -7086584903501314806L;
	
	public static boolean soundEffectsEnabled, musicEnabled;
	public static String skinFolderLocation, ambianceFolderLocation, cursorImageFile;
	
	public static void save() throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("preferences")));
		out.writeObject(soundEffectsEnabled);
		out.writeObject(musicEnabled);
		out.writeObject(skinFolderLocation);
		out.writeObject(ambianceFolderLocation);
		out.writeObject(cursorImageFile);
		out.close();
	}
	public static void load() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("statistics")));
		soundEffectsEnabled = (boolean) in.readObject();
		musicEnabled = (boolean) in.readObject();
		skinFolderLocation = (String) in.readObject();
		ambianceFolderLocation = (String) in.readObject();
		cursorImageFile = (String) in.readObject();
		in.close();
	}
	
	public static String staticToString() {
		return  soundEffectsEnabled + "\n" + musicEnabled + "\n" + 
				skinFolderLocation + "\n" + ambianceFolderLocation + "\n" + cursorImageFile;
	}
	
	public static void printAllFields() {
		System.out.println(soundEffectsEnabled);
		System.out.println(musicEnabled);
		System.out.println(skinFolderLocation);
		System.out.println(ambianceFolderLocation);
		System.out.println(cursorImageFile);
	}
}