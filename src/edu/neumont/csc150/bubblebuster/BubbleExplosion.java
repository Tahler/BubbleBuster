package edu.neumont.csc150.bubblebuster;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class BubbleExplosion extends JComponent {
	private Bubble caller;
	private SmallBubble[] bubbles;
	
	public BubbleExplosion(int x, int y, int diameter, Bubble caller) {
		this.caller = caller;
		
		bubbles = new SmallBubble[5];
		int slice = 360 / bubbles.length;
		for (int i = 0; i < bubbles.length; i++) {
			bubbles[i] = new SmallBubble(x, y, diameter / 10, slice * i);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < bubbles.length; i++) {
			bubbles[i].paintComponent(g);
		}
	}
	
	private class SmallBubble extends JComponent {
		private int x, y;
		private int diameter;
		private int direction;
		private float alpha;
		
		public SmallBubble(int x, int y, int diameter, int direction) {
//			super();
			alpha = 1.0f;
			this.x = x;
			this.y = y;
			this.diameter = diameter;
			this.direction = direction;
		}
		
		public void move() {
			x += Math.cos(Math.toRadians(direction)) * diameter;
			y += Math.sin(Math.toRadians(direction)) * diameter;
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			move();
			if (alpha > 0.1f) alpha -= 0.1f; 
			else caller.doneAnimating();
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
			
//			g.setColor(new Color(255, 255, 255, alpha));
//			g.setColor(Color.WHITE);
			g2d.drawImage(caller.img.getImage(), x, y, null);
//			g.fillOval(x, y, diameter, diameter);
		}
	}
}
