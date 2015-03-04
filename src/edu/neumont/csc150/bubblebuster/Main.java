package edu.neumont.csc150.bubblebuster;

public class Main {

	public static void main(String[] args) {
		// Load or make statistics
		Statistics.load();
		
		// Load or make preferences
		Preferences.load();
		
		// Initialize the Sounds according to the preferences
		Sound.getInstance();
		
		// Run the program
		@SuppressWarnings("unused")
		GUI gui = new GUI();
	}
	
}
