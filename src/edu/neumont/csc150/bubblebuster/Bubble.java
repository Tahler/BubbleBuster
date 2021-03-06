package edu.neumont.csc150.bubblebuster;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Bubble extends JComponent implements MouseListener {
	public static final int POINTS = 10;
	public static int minDiameter;
	public static int maxDiameter;
	public static int minSpeed;
	public static int maxSpeed;
	
	private Image img = Toolkit.getDefaultToolkit().getImage(Preferences.skinFolderLocation + "/bubble.png");
	private int x, y;
	private int diameter;
	private int speed;
//	private int points; // maybe needed later if points are worth more as the bubble gets smaller and faster
	private boolean popped;
	protected boolean pointsAdded;
	private boolean doneAnimating;
	private BubbleExplosion explosion;
	
	public Bubble() {
		explosion = null;		
		popped = false;
		pointsAdded = false;
		doneAnimating = false;
		setFocusable(false);

		Random rand = new Random();
		setDiameter(rand.nextInt(maxDiameter - minDiameter) + minDiameter); // Multiplied by 2 because the bubble part of the skin is 400x400, though the image is 800x800
		setSpeed(rand.nextInt(maxSpeed - minSpeed) + minSpeed);
		setX(rand.nextInt(GUI.WIDTH - diameter));
		setY(GUI.HEIGHT);
		
		img = img.getScaledInstance(diameter, diameter, Image.SCALE_SMOOTH);
		
		GUI.getInstance().addMouseListener(this); // Adding the MouseListener to this JComponent would overwrite the GUI's MouseListener (which manages the cursor)
	}
	
	public static void resetDifficulty() {
		minDiameter = 200;
		maxDiameter = 800;
		minSpeed = 3;
		maxSpeed = 8;
	}
	public static void increaseDifficulty() {
		if (minSpeed < maxSpeed - 1) minSpeed++;
		else maxSpeed++;
		
		if (maxDiameter > minDiameter) maxDiameter--;
		else minDiameter--;
	}
	public static void setMaxSpeed(int speed) {
		maxSpeed = speed;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if (!popped) {
			g.drawImage(img, x, y, null);
			move();
		}
		if (explosion != null) {
			explosion.paintComponent(g);
		}
	}
	
	protected boolean isInside(Point point) {
		return new Ellipse2D.Double(x + diameter / 4, y + diameter / 4, diameter / 2, diameter / 2).contains(point);
	}
	
	public void move() {
		y -= speed;
	}
	
	public boolean isOffScreen() {
		return (y + diameter * 3/4 < 0);
	}
	
	@Override
	public String toString() {
		return "x:" + getX() + " y:" + getY() + " r:" + (getDiameter() / 2) + " spd:" + getSpeed();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if (isInside(e.getLocationOnScreen()) && !isPopped()) {
			pop();
			explosion = new BubbleExplosion((int) e.getLocationOnScreen().getX(), (int) e.getLocationOnScreen().getY(), getDiameter(), this);
		}
	}
	
	public void pop() {
		if (Preferences.soundFXEnabled) Sound.getInstance().playPop();
		popped = true;
	}
	public boolean isPopped() {
		return popped;
	}
	public boolean isDoneAnimating() {
		return doneAnimating;
	}
	public void doneAnimating() {
		doneAnimating = true;
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

	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent e) {}
}
