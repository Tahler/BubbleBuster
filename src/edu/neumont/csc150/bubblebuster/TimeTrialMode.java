package edu.neumont.csc150.bubblebuster;

import java.awt.Graphics;

@SuppressWarnings("serial")
public class TimeTrialMode extends BubbleBuster {
	private static final int TIME = 90000;
	
	public TimeTrialMode(GUI frame) {
		super(frame);
		setMinBubbleInterval(10);
		setMaxBubbleInterval(20);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		String time = Time.format(TIME - watch.getTime());
		
		g.drawString(time, GUI.WIDTH - (int) g.getFontMetrics().getStringBounds(time, g).getWidth() - STRING_PADDING, STRING_PADDING * 2);
		timesUp();
	}
	
	public void timesUp() {
		if (watch.getTime() >= TIME) {
			
			watch.stop();	
			frame.switchTo(new TimeTrialGameOverPanel(frame, background.getImage(), getScore(), getPopped()));
			frame.gamePanel = null;
		}
	}
}
