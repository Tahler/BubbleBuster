package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Graphics;

public class SurvivalMode extends BubbleBuster {
	private int lives;
	private GUI frame;
	private long startTime;
	private long currentTime;
	
	public SurvivalMode(GUI frame) {
		super();
		this.frame = frame;
		this.startTime = System.currentTimeMillis();
		setBackground(new Color(0, 195, 217));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println(getTimeRunning());
	}

	public String getTimeRunning() {
		currentTime = System.currentTimeMillis() - startTime;
		
		return (currentTime / 60000) % 60 + ":" + (currentTime / 1000) % 60 + "." + currentTime % 10;
	}
	
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
}
