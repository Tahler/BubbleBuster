package edu.neumont.csc150.bubblebuster;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public abstract class BubbleBuster extends JPanel implements ActionListener, MouseListener {
	public static final int MINIMUM_BUBBLE_INTERVAL = 50;
	public static final int MAXIMUM_BUBBLE_INTERVAL = 500;
	private int bubbleInterval;
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
		
		waitOrAddBubble();
		
		timer = new Timer(1, this);
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int tempSize = bubbles.size();
		for (int i = 0; i < tempSize; i++) {
			if (bubbles.get(i).isPopped()) {
				bubbles.remove(i);
				tempSize--;
			}
			else bubbles.get(i).paintComponent(g);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		for (Bubble bubble : getBubbles()) {
			if (bubble.isInside(e.getLocationOnScreen())) {
				bubble.pop();
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		waitOrAddBubble();
		repaint();
	}
	
	private void waitOrAddBubble() {
		if (bubbleInterval == 0) {
			bubbleInterval = new Random().nextInt(MAXIMUM_BUBBLE_INTERVAL - MINIMUM_BUBBLE_INTERVAL) + MINIMUM_BUBBLE_INTERVAL;
			bubbles.add(new Bubble());
			add(bubbles.get(bubbles.size() - 1));
		}
		else bubbleInterval--;	
	}

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
