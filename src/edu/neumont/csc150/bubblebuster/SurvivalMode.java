package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SurvivalMode extends BubbleBuster implements MouseListener {
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
//		System.out.println("painting SurvivalMode");
		super.paintComponent(g);
		for (Bubble bubble : getBubbles()) {
			bubble.paint(g);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("clicked");
		for (Bubble bubble : getBubbles()) {
			if (bubble.isInside(e.getLocationOnScreen())) {
//				this.setEnabled(false);
				System.out.println("pop");
			}
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

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}
