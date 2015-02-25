package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

public class SurvivalMode extends BubbleBuster {
	private int lives;
	private GUI frame;
	
	public SurvivalMode(GUI frame) {
		super();
		this.frame = frame;
		
		setBackground(new Color(0, 195, 217));
		
//		for (Bubble bubble : getBubbles()) {
//			add(bubble);
//		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		System.out.println("painting SurvivalMode");
		super.paintComponent(g);
		for (Bubble bubble : getBubbles()) {
			bubble.paint(g);
		}
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
