package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
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
	private ArrayList<Bubble> bubbles;
	
	public Bubble(ArrayList<Bubble> bubbles) {
		this.bubbles = bubbles;
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
	
//	@Override
//	public void paint(Graphics g) {
////		System.out.println("painting Bubble");
////		super.paint(g);
////		g.setColor(Color.BLACK);
//		g.fillOval(x, y, diameter, diameter);
//		move();
//	}
	
	protected boolean isInside(Point point) {
		if (point.x > x && point.x < x + diameter) {
			if (point.y > y && point.y < y + diameter) {
				return true;
			}
		}
		return false;
	}
	
	public void pop() {
		// add points
		// remove the bubble
		System.out.println("popped bubble");
	}
	
	public void move() {
		if (y + diameter < 0) bubbles.remove(this);
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
