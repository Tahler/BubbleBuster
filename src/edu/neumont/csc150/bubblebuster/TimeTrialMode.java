package edu.neumont.csc150.bubblebuster;

import java.awt.Graphics;

@SuppressWarnings("serial")
public class TimeTrialMode extends BubbleBuster {
	public static final int STARTING_TIME = 100; // TODO: INCREASE TO FIVE, BUT MAKE THIS MODE GET HARDER AS TIME GOES ON
	private int count;
	private int time;
	
	public TimeTrialMode(GUI frame) {
		super(frame);
		
		setTime(STARTING_TIME);
	
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		String time = Time.format(9000 - watch.getTime());
		
		g.drawString(time, GUI.WIDTH - (int) g.getFontMetrics().getStringBounds(time, g).getWidth() - STRING_PADDING, STRING_PADDING * 2);
		timesUp();	
	}
	
	public void timesUp() {
		if (watch.getTime() >= 9000) {
			
			watch.stop();	
			frame.switchTo(new TimeTrialGameOverPanel(frame, background.getImage(), getScore(), getPopped()));
			frame.gamePanel = null;
			}
	}
	public int getTime() {
		return time;
	}
	public void setTime(int lives) {
		this.time = time;
	}
	
	
}
