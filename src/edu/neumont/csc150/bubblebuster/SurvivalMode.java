package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Graphics;

public class SurvivalMode extends BubbleBuster {
	public static final int STARTING_LIVES = 1;
	
	private int lives;
	private long startTime;
	private Time currentTime;
	
	public SurvivalMode(GUI frame) {
		super(frame);
		
		setLives(STARTING_LIVES);
		startTime = System.currentTimeMillis();
		setBackground(new Color(0, 195, 217));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawString(getTimeRunning(), GUI.WIDTH - (int) g.getFontMetrics().getStringBounds(getTimeRunning(), g).getWidth() - STRING_PADDING, STRING_PADDING * 2);
		g.drawString(getLives() + "", GUI.WIDTH - (int) g.getFontMetrics().getStringBounds(getLives() + "", g).getWidth() - STRING_PADDING, STRING_PADDING * 3);
	}

	public String getTimeRunning() {
		return new Time(System.currentTimeMillis() - startTime).toString();
	}
	
	public void loseLife() {
		this.lives--;
		if (lives <= 0) {
 			frame.switchTo(new SurvivalGameOverPanel(frame, getScore(), getTimeRunning()));
			frame.survivalPanel = null;
		}
	}
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
}
