package edu.neumont.csc150.bubblebuster;

public class Main {

	public static void main(String[] args) {
		// Load or make statistics
		Statistics.load();
		
		// Load or make preferences
		Preferences.load();
		
		// Run the program
		@SuppressWarnings("unused")
		GUI gui = new GUI();
	}
	
}
