package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class SurvivalMode extends BubbleBuster {
	public static int difficultyLevel;
	public static final int STARTING_LIVES = 1;
	private static final int DIFFICULTY_INCREASE_INTERVAL = 20;
	private int difficultyTimer;
	private int lives;
	
	public SurvivalMode(GUI frame) {
		super(frame);
		
		difficultyLevel = 1;
		difficultyTimer = DIFFICULTY_INCREASE_INTERVAL;
		
		setLives(STARTING_LIVES);
		setBackground(new Color(0, 195, 217));		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		increaseDifficulty();
		
		String time = watch.toString().substring(2, watch.toString().length() - 2);
		g.drawString(time, GUI.WIDTH - (int) g.getFontMetrics().getStringBounds(time, g).getWidth() - STRING_PADDING, STRING_PADDING * 2);
//		g.drawString(getLives() + "", GUI.WIDTH - (int) g.getFontMetrics().getStringBounds(getLives() + "", g).getWidth() - STRING_PADDING, STRING_PADDING * 3);
	}
	
	public void increaseDifficulty() {
		if (difficultyTimer <= 0) {
			difficultyLevel++;
			setMinBubbleInterval(getMinBubbleInterval() - 1);
			if (getMinBubbleInterval() == 0) {
				setMaxBubbleInterval(getMaxBubbleInterval() - 1);
			}
			difficultyTimer = DIFFICULTY_INCREASE_INTERVAL;
		}
		else difficultyTimer--;
	}
	
	public void loseLife() {
		this.lives--;
		if (lives <= 0) {
 			frame.switchTo(new SurvivalGameOverPanel(frame, getScore(), watch.getTime()));
			frame.gamePanel = null;
		}
	}
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
}
