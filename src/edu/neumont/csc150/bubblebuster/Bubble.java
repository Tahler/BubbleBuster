package edu.neumont.csc150.bubblebuster;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Bubble extends JComponent implements MouseListener {
	public static final int MINIMUM_DIAMETER = 50;
	public static final int MAXIMUM_DIAMETER = 400;
	public static final int MINIMUM_SPEED = 3;
	public static final int MAXIMUM_SPEED = 8;
	public static final int POINTS = 10;
	private ImageIcon img = new ImageIcon(Preferences.skinFolderLocation + "/bubble.png");
	private int x, y;
	private int diameter;
	private int speed;
//	private int points; // maybe needed later if points are worth more as the bubble gets smaller and faster
	private boolean popped;
	
	public Bubble() {
		popped = false;
		Random rand = new Random();
		setFocusable(false);
		setDiameter(rand.nextInt(MAXIMUM_DIAMETER - MINIMUM_DIAMETER) + MINIMUM_DIAMETER);
		setSpeed(rand.nextInt(MAXIMUM_SPEED - MINIMUM_SPEED) + MINIMUM_SPEED);
		setX(rand.nextInt(GUI.WIDTH - diameter));
		setY(GUI.HEIGHT);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.fillOval(x, y, diameter, diameter);
		move();
	}
	
	protected boolean isInside(Point point) {
		return ((point.x > x && point.x < x + diameter) && (point.y > y && point.y < y + diameter));
	}
	
	public void pop() {
		if (Preferences.soundFXEnabled) Sound.getInstance().playPop();
		popped = true;
	}
	
	public void move() {
		y -= speed;
	}
	
	public boolean isOffScreen() {
		return (y + diameter < 0);
	}
	
	@Override
	public String toString() {
		return "x:" + getX() + " y:" + getY() + " r:" + (getDiameter() / 2) + " spd:" + getSpeed();
	}
	
	public boolean isPopped() {
		return popped;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDiameter() {
		return diameter;
	}
	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (isInside(e.getLocationOnScreen())) {
			pop();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}
