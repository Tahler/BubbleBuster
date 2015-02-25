package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class SurvivalMode extends BubbleBuster {
	private static final int PADDING = 30;
	private GUI frame;
	private int lives;
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
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("SansSerif", Font.BOLD, 24));
		g.drawString(getScore() + "", GUI.WIDTH - (int) g.getFontMetrics().getStringBounds(getScore() + "", g).getWidth() - PADDING, PADDING);
		g.drawString(getTimeRunning(), GUI.WIDTH - (int) g.getFontMetrics().getStringBounds(getTimeRunning(), g).getWidth() - PADDING, PADDING * 2);
	}

	public String getTimeRunning() {
		currentTime = System.currentTimeMillis() - startTime;
		
		return (((currentTime / 60000) % 60 < 10) ? "0" + ((currentTime / 60000) % 60) : "" + (currentTime / 60000) % 60)
				+ ":" + (((currentTime / 1000) % 60 < 10) ? "0" + ((currentTime / 1000) % 60) : "" + ((currentTime / 1000) % 60))
				+ "." + currentTime % 10;
	}
	
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
}
