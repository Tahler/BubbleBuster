package edu.neumont.csc150.bubblebuster;

import java.io.IOException;

public class Test { // TODO: remove sysout and rename to Program or Main or Driver, etc.
	
	public static void main(String[] args) {
		// Load or make statistics
		try {
			Statistics.load();
		}
		catch (Exception e) {
			try {
				Statistics.save();
			}
			catch (IOException e1) {
				System.out.println("Super broken af");
			}
		}
		
		// Load or make preferences
		try {
			Preferences.load();
		}
		catch (Exception e) {
			try {
				Preferences.musicEnabled = true;
				Preferences.soundEffectsEnabled = true;
				Preferences.skinFolderLocation = "";
				Preferences.ambianceFolderLocation = "";
				Preferences.cursorImageFile = "";
				Preferences.save();
			}
			catch (IOException e1) {
				System.out.println("Super broken af");
			}
		}
		
		// Run the program
		@SuppressWarnings("unused")
		GUI gui = new GUI("Bubble Buster");
	}
}
