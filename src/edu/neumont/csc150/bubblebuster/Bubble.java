package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class Bubble extends JComponent {
	public static final int MINIMUM_DIAMETER = 50;
	public static final int MAXIMUM_DIAMETER = 400;
	public static final int MINIMUM_SPEED = 3;
	public static final int MAXIMUM_SPEED = 10;
	private int x, y;
	private int diameter;
	private int speed;
	private int points;
	
	public Bubble() {
		Random rand = new Random();
		setDiameter(rand.nextInt(MAXIMUM_DIAMETER - MINIMUM_DIAMETER) + MINIMUM_DIAMETER);
		setSpeed(rand.nextInt(MAXIMUM_SPEED - MINIMUM_SPEED) + MINIMUM_SPEED);
		setX(rand.nextInt(GUI.WIDTH - diameter));
		setY(GUI.HEIGHT);
	}
	
//	@Override
//	protected void paintComponent(Graphics g) {
//		System.out.println("painting");
////		super.paintComponent(g);
//		g.drawOval(x, y, diameter, diameter);
//		move();
//	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println("painting Bubble");
		move();
//		super.paint(g);
		g.setColor(Color.BLACK);
		g.drawOval(x, y, diameter, diameter);
		move();
	}
	
	public void pop() {
		
	}
	
	public void move() {
//		if (y < 0) // bubble flew off the screen.
		y -= speed;
	}
	
	@Override
	public String toString() {
		return "x:" + getX() + " y:" + getY() + " r:" + (getDiameter() / 2) + " spd:" + getSpeed();
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
