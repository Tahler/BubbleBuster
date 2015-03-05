package edu.neumont.csc150.bubblebuster;

import java.awt.Graphics;

@SuppressWarnings("serial")
public class TimeTrialMode extends BubbleBuster {
	public static final int STARTING_LIVES = 1; // TODO: INCREASE TO FIVE, BUT MAKE THIS MODE GET HARDER AS TIME GOES ON
	
	private int lives;
	
	public TimeTrialMode(GUI frame) {
		super(frame);
		
		setLives(STARTING_LIVES);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		String time = watch.toString().substring(2, watch.toString().length() - 2);
		
		g.drawString(time, GUI.WIDTH - (int) g.getFontMetrics().getStringBounds(time, g).getWidth() - STRING_PADDING, STRING_PADDING * 2);
		g.drawString(getLives() + "", GUI.WIDTH - (int) g.getFontMetrics().getStringBounds(getLives() + "", g).getWidth() - STRING_PADDING, STRING_PADDING * 3);
	}
	
//	public void loseLife() {
//		this.lives--;
//		if (lives <= 0) {
// 			frame.switchTo(new SurvivalGameOverPanel(frame, getScore(), watch.getTime()));
//			frame.survivalPanel = null;
//		}
//	}
	public void timesUp() {
		if (watch.getNanoTime() >= 90000) {
			watch.stop();		
			}
	}
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
}
