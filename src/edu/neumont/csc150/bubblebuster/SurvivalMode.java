package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Graphics;

public class SurvivalMode extends BubbleBuster {
	public static final int STARTING_LIVES = 5;
	
	private int lives;
	private long startTime;
	private long currentTime;
	
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
		currentTime = System.currentTimeMillis() - startTime;
		
		return (((currentTime / 60000) % 60 < 10) ? "0" + ((currentTime / 60000) % 60) : "" + (currentTime / 60000) % 60)
				+ ":" + (((currentTime / 1000) % 60 < 10) ? "0" + ((currentTime / 1000) % 60) : "" + ((currentTime / 1000) % 60))
				+ "." + currentTime % 10;
	}
	
	public void loseLife() {
		this.lives--;
		if (lives <= 0) {
// 			frame.switchTo(new GameOverPanel(getScore(), getTimeRunning()));
			frame.survivalPanel = null;
			System.out.println("Game over");
		}
	}
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
}
