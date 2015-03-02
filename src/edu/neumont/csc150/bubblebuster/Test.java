package edu.neumont.csc150.bubblebuster;

import java.io.IOException;

public class Test {

	public static void main(String[] args) {
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
		GUI gui = new GUI("Bubble Buster");
	}

}
