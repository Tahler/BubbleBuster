package edu.neumont.csc150.bubblebuster;

public class Main {

	public static void main(String[] args) {
		// Load or make user statistics
		Statistics.load();
		
		// Load or make user preferences
		Preferences.load();
		
		// Load or make user purchases
		Purchases.load();
		
		// Initialize the Sounds according to the preferences
		Sound.getInstance();
		
		// Run the program
		GUI.getInstance();
	}
	
}
