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

	public static boolean defaultSkin, robot, pig, alien;
	public static boolean defaultAmbiance, wubble, farm, space;
	
	public static boolean isPurchased(String item) {
		switch (item) {
			case "Default Skin":
				return defaultAmbiance;
			case "Alien Skin":
				return alien;
			case "Pig Skin":
				return pig;
			case "Robot Skin":
				return robot;
			case "Default Pack":
				return defaultAmbiance;
			case "Wubble Pack":
				return wubble;
			case "Farm Pack":
				return farm;
			case "Space Pack":
				return space;
			default:
				return false;
		}
	}
	public static void purchase(String item) {
		switch (item) {
			case "Default Skin":
				defaultAmbiance = true;
				break;
			case "Alien Skin":
				alien = true;
				break;
			case "Pig Skin":
				pig = true;
				break;
			case "Robot Skin":
				robot = true;
				break;
			case "Default Pack":
				defaultAmbiance = true;
				break;
			case "Wubble Pack":
				wubble = true;
				break;
			case "Farm Pack":
				farm = true;
				break;
			case "Space Pack":
				space = true;
				break;
		}
		Preferences.save();
		Purchases.save();
	}
	
	public static void save() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("purchases")));
			
			out.writeBoolean(defaultSkin);
			out.writeBoolean(alien);
			out.writeBoolean(pig);
			out.writeBoolean(robot);
			
			out.writeBoolean(defaultAmbiance);
			out.writeBoolean(wubble);
			out.writeBoolean(farm);
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
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("purchases")));
			
			defaultSkin = in.readBoolean();
			alien = in.readBoolean();
			pig = in.readBoolean();
			robot = in.readBoolean();
			
			defaultAmbiance = in.readBoolean();
			wubble = in.readBoolean();
			farm = in.readBoolean();
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
			farm = false;
			space = false;
			
			Purchases.save();
		}
	}
}
