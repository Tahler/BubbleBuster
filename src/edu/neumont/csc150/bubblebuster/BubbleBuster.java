package edu.neumont.csc150.bubblebuster;

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
	}
	
	public void checkBubbles() {
		
	}

	public void togglePause() {
		paused = !paused;
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
