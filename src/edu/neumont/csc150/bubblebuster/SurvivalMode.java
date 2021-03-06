package edu.neumont.csc150.bubblebuster;

import java.awt.Graphics;

@SuppressWarnings("serial")
public class SurvivalMode extends BubbleBuster {
	private static final int STARTING_LIVES = 1;
	private static final int DIFFICULTY_INCREASE_INTERVAL = 100;
	private int difficultyTimer;
	private int lives;
	
	public SurvivalMode() {
		super();
		difficultyTimer = DIFFICULTY_INCREASE_INTERVAL;
		setLives(STARTING_LIVES);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		waitOrIncreaseDifficulty();
		
		// Alternative fix to the possible glitching of the timer's display
//		long milliseconds = watch.getTime();
//		long minutes = (milliseconds / 60000) % 60;
//		long seconds = (milliseconds / 1000) % 60;
//		long tenths = milliseconds % 10;
//		
//		String time = ((minutes < 10) ? "0" : "") + minutes
//				+ ":" + ((seconds < 10) ? "0" : "") + seconds
//				+ "." + tenths;
		String time = Time.format(watch.getTime());
		g.drawString(time, GUI.WIDTH - (int) g.getFontMetrics().getStringBounds(time, g).getWidth() - STRING_PADDING, STRING_PADDING * 2);
		// If lives is ever greater than 1, uncomment this
//		g.drawString(getLives() + "", GUI.WIDTH - (int) g.getFontMetrics().getStringBounds(getLives() + "", g).getWidth() - STRING_PADDING, STRING_PADDING * 3);
	}
	
	public void waitOrIncreaseDifficulty() {
		// Wait
		if (difficultyTimer <= 0) {
//			System.out.println("Increasing difficulty");
			Bubble.increaseDifficulty();
			setMinBubbleInterval(getMinBubbleInterval() - 5);
			if (getMinBubbleInterval() == 0) {
				setMaxBubbleInterval(getMaxBubbleInterval() - 5);
			}
			difficultyTimer = DIFFICULTY_INCREASE_INTERVAL;
		}
		// Increase difficulty
		else difficultyTimer--;
	}
	
	public void loseLife() {
		this.lives--;
		if (lives <= 0) {
			GUI.getInstance().switchTo(new SurvivalGameOverPanel(background.getImage(), getScore(), watch.getTime()));
			GUI.getInstance().gamePanel = null;
		}
	}
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
}
