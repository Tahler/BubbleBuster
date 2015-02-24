package edu.neumont.csc150.bubblebuster;

import java.awt.event.ActionEvent;

import javax.swing.Timer;

public class SurvivalMode extends BubbleBuster {
	private int lives;
	
	public SurvivalMode() {
		super();
	}

	public String getTimeRunning() {
		return null;
	}
	
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
}
