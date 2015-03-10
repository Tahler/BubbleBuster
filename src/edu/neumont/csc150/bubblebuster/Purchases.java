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
	
	public static void save() throws IOException {
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
		catch (Exception e) {
			try {
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
			catch (IOException e1) {
				// Should never really be reached.
				e1.printStackTrace();
			}
		}
	}
}
