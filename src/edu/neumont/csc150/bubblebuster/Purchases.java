package edu.neumont.csc150.bubblebuster;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Purchases implements Serializable {
	private static final long serialVersionUID = 2059369102932063253L;

	public static boolean defaultSkin, alien, pig, robot;
	public static boolean defaultAmbiance, wubble, atlantis, space;
	
	public static boolean isPurchased(String item) {
		switch (item) {
			case "Default Skin":
				return defaultAmbiance;
			case "Alien":
				return alien;
			case "Pig":
				return pig;
			case "Robot":
				return robot;
			case "Default Ambiance":
				return defaultAmbiance;
			case "Wubble":
				return wubble;
			case "Atlantis":
				return atlantis;
			case "Space":
				return space;
			default:
				return false;
		}
	}
	public static void purchaseAndUse(String item) {
		switch (item) {
			case "Default Skin":
				Preferences.skinFolderLocation = "resources/skins/default";
				defaultAmbiance = true;
				break;
			case "Alien":
				Preferences.skinFolderLocation = "resources/skins/alien";
				alien = true;
				break;
			case "Pig":
				Preferences.skinFolderLocation = "resources/skins/pig";
				pig = true;
				break;
			case "Robot":
				Preferences.skinFolderLocation = "resources/skins/robot";
				robot = true;
				break;
			case "Default Ambiance":
				Preferences.ambianceFolderLocation = "resources/ambiance/default";
				defaultAmbiance = true;
				break;
			case "Wubble":
				Preferences.ambianceFolderLocation = "resources/ambiance/wubble";
				wubble = true;
				break;
			case "Atlantis":
				Preferences.ambianceFolderLocation = "resources/ambiance/atlantis";
				atlantis = true;
				break;
			case "Space":
				Preferences.ambianceFolderLocation = "resources/ambiance/space";
				space = true;
				break;
		}
		Preferences.save();
		Purchases.save();
	}
	
	public static void save() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("statistics")));
			
			out.writeBoolean(defaultSkin);
			out.writeBoolean(alien);
			out.writeBoolean(pig);
			out.writeBoolean(robot);
			
			out.writeBoolean(defaultAmbiance);
			out.writeBoolean(wubble);
			out.writeBoolean(atlantis);
			out.writeBoolean(space);
			
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Tries to load a currently existing Purchases file.  If no such file exists, the file will be created with defaults.
	 */
	public static void load() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("statistics")));
			
			defaultSkin = in.readBoolean();
			alien = in.readBoolean();
			pig = in.readBoolean();
			robot = in.readBoolean();
			
			defaultAmbiance = in.readBoolean();
			wubble = in.readBoolean();
			atlantis = in.readBoolean();
			space = in.readBoolean();
			
			in.close();
		}
		catch (IOException e) {
			defaultSkin = true;
			alien = false;
			pig = false;
			robot = false;
			
			defaultAmbiance = true;
			wubble = false;
			atlantis = false;
			space = false;
			
			Purchases.save();
		}
	}
}
