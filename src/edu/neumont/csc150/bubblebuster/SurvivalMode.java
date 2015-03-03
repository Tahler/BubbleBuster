package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.time.StopWatch;

@SuppressWarnings("serial")
public class SurvivalMode extends BubbleBuster {
	public static final int STARTING_LIVES = 1;
	
	private int lives;
	
	public SurvivalMode(GUI frame) {
		super(frame);
		
		setLives(STARTING_LIVES);
		setBackground(new Color(0, 195, 217));		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawString(watch.toString(), GUI.WIDTH - (int) g.getFontMetrics().getStringBounds(watch.toString(), g).getWidth() - STRING_PADDING, STRING_PADDING * 2);
		g.drawString(getLives() + "", GUI.WIDTH - (int) g.getFontMetrics().getStringBounds(getLives() + "", g).getWidth() - STRING_PADDING, STRING_PADDING * 3);
	}
	
	public void loseLife() {
		this.lives--;
		if (lives <= 0) {
 			frame.switchTo(new SurvivalGameOverPanel(frame, getScore(), watch.getTime()));
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
