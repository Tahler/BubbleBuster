package edu.neumont.csc150.bubblebuster;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

import javax.swing.JComponent;

public class Bubble extends JComponent {
	public static final int MINIMUM_DIAMETER = 50;
	public static final int MAXIMUM_DIAMETER = 400;
	public static final int MINIMUM_SPEED = 3;
	public static final int MAXIMUM_SPEED = 8;
	public static final int POINTS = 10;
	private int x, y;
	private int diameter;
	private int speed;
//	private int points; // maybe needed later if points are worth more as the bubble gets smaller and faster
	private boolean popped;
	
	public Bubble() {
		popped = false;
		Random rand = new Random();
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
		if (point.x > x && point.x < x + diameter) {
			if (point.y > y && point.y < y + diameter) {
				return true;
			}
		}
		return false;
	}
	
	public void pop() {
		popped = true;
	}
	
	public void move() {
		if (y + diameter < 0) {
			popped = true;
//			remove a life;
		}
		y -= speed;
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
}
