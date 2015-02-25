package edu.neumont.csc150.bubblebuster;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public abstract class BubbleBuster extends JPanel implements ActionListener {
	private int score;
	private Timer timer;
	private int coinsEarned;
	private boolean paused;
	private ArrayList<Bubble> bubbles;
	
	public BubbleBuster() {
		score = 0;
		coinsEarned = 0;
		paused = false;
		bubbles = new ArrayList<Bubble>();
		
		bubbles.add(new Bubble());
//		bubbles.add(new Bubble());
		
		add(bubbles.get(0));
		
		timer = new Timer(1000, this);
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// next bubble appears counter randomized then counted down
		// checkBubbles() // remove if they go off screen
		for (Bubble bubble : bubbles) {
			System.out.println(bubble);
//			bubble.repaint();
//			repaint();
		}
		repaint();
	}
	
//	@Override
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		System.out.println("painting BubbleBuster");
//	}
	
	public void checkBubbles() {
		
	}

	public void togglePause() {
		paused = !paused;
		if (paused) timer.stop();
		else timer.start();
	}
	
	public void addScore(int score) {
		this.score += score;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Timer getTimer() {
		return timer;
	}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	public int getCoinsEarned() {
		return coinsEarned;
	}
	public void setCoinsEarned(int coinsEarned) {
		this.coinsEarned = coinsEarned;
	}
	public boolean isPaused() {
		return paused;
	}
	public void setPaused(boolean paused) {
		this.paused = paused;
	}
	public ArrayList<Bubble> getBubbles() {
		return bubbles;
	}
	public void setBubbles(ArrayList<Bubble> bubbles) {
		this.bubbles = bubbles;
	}
}
