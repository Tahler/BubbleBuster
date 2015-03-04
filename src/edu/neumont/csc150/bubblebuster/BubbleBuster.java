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
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.apache.commons.lang3.time.StopWatch;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

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
		System.out.println(isFocusable());
		addMouseListener(this);
		addKeyListener(this);
		waitOrAddBubble();
		
		playMusic();
		
		watch = new StopWatch();
		watch.start();
		timer = new Timer(20, this);
		timer.start();
	}
	
	public void playMusic() {
		AudioStream backgroundMusic;
		AudioData musicData;
		AudioPlayer musicPlayer = AudioPlayer.player;
		ContinuousAudioDataStream loop = null;
		try {
		   backgroundMusic = new AudioStream(new FileInputStream("C:/Windows/Media/chord.wav"));
		   musicData = backgroundMusic.getData();
		   loop = new ContinuousAudioDataStream(musicData);
		   musicPlayer.start(loop);
		} catch (IOException error) {
		   System.out.println(error);
		}
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
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		requestFocusInWindow(); // TODO: BUG ARISES HERE, CANNOT PAUSE UNTIL CLICKING
		System.out.print("Click");
		for (Bubble bubble : bubbles) {
			if (bubble.isInside(e.getLocationOnScreen())) {
				System.out.print(" Pop");
				bubble.pop();
				addScore(Bubble.POINTS);
			}
		}
		System.out.println();
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
			bubbles.add(new Bubble());
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
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
