package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.apache.commons.lang3.time.StopWatch;

@SuppressWarnings("serial")
public abstract class BubbleBuster extends JPanel implements ActionListener, MouseListener, KeyListener {
	public static final int MINIMUM_BUBBLE_INTERVAL = 50;
	public static final int MAXIMUM_BUBBLE_INTERVAL = 100;
	protected static final int STRING_PADDING = 30;
	protected GUI frame;
	private int bubbleInterval;
	private int score;
	private Timer timer;
	private int coinsEarned; // TODO: MAY BE USED LATER IF 10 POINTS != 1 COIN
	private boolean paused;
	private ArrayList<Bubble> bubbles;
	protected StopWatch watch;
	
	public BubbleBuster(GUI frame) {
		this.frame = frame;
		score = 0;
		coinsEarned = 0;
		paused = false;
		bubbles = new ArrayList<Bubble>();
		
		addKeyListener(this);
		
		waitOrAddBubble();
		
		watch = new StopWatch();
		watch.start();
		timer = new Timer(20, this);
		timer.start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.WHITE);
		g.setFont(new Font("SansSerif", Font.BOLD, 24));
		g.drawString(getScore() + "", GUI.WIDTH - (int) g.getFontMetrics().getStringBounds(getScore() + "", g).getWidth() - STRING_PADDING, STRING_PADDING);
		
		int tempSize = bubbles.size();
		for (int i = 0; i < tempSize; i++) {
			if (bubbles.get(i).isPopped()) {
				addScore(Bubble.POINTS);
				bubbles.remove(i);
				tempSize--;
			}
			else if (bubbles.get(i).isOffScreen()) {
				if (this instanceof SurvivalMode) {
					((SurvivalMode) this).loseLife();
				}
				bubbles.remove(i);
				tempSize--;
			}
			else bubbles.get(i).paintComponent(g);
			
			requestFocusInWindow(); // Kinda sucks
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		waitOrAddBubble();
		repaint();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			togglePause();
			frame.switchTo(new PausePanel(frame));
		}
	}
	
	private void waitOrAddBubble() {
		if (bubbleInterval == 0) {
			bubbleInterval = new Random().nextInt(MAXIMUM_BUBBLE_INTERVAL - MINIMUM_BUBBLE_INTERVAL) + MINIMUM_BUBBLE_INTERVAL;
			Bubble bubble = new Bubble();
			bubbles.add(bubble);
			addMouseListener(bubble);
		}
		else bubbleInterval--;	
	}

	public void togglePause() {
		paused = !paused;
		if (paused) {
			watch.suspend();
			timer.stop();
		}
		else {
			watch.resume();
			timer.start();
		}
	}
	
	public void addScore(int score) {
		this.score += score;
	}
	
	public int getScore() {
		return score;
	}

	public void keyPressed(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
}
