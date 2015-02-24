package edu.neumont.csc150.bubblebuster;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class Bubble extends JComponent {
	public static final int MAXIMUM_DIAMETER = 100;
	public static final int MAXIMUM_SPEED = 10;
	private int x, y;
	private int diameter;
	private int speed;
	private int points;
	
	public Bubble() {
		Random rand = new Random();
//		setX(rand.nextInt(GUI.WIDTH));
		setX(300);
//		setY(GUI.HEIGHT);
		setY(1080);
		setDiameter(rand.nextInt(MAXIMUM_DIAMETER - MAXIMUM_DIAMETER / 2) + MAXIMUM_DIAMETER / 2);
		setSpeed(rand.nextInt(MAXIMUM_SPEED - MAXIMUM_SPEED / 2) + MAXIMUM_SPEED / 2);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		System.out.println("painting");
		super.paintComponent(g);
		g.drawOval(x, y, diameter, diameter);
		move();
	}
	
	public void pop() {
		
	}
	
	public void move() {
//		if (y < 0) // break shit.
		y -= speed;
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
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}	
}
