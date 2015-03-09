package edu.neumont.csc150.bubblebuster;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class BubbleExplosion extends JComponent {
	private Bubble caller;
	private SmallBubble[] bubbles;
	
	public BubbleExplosion(int x, int y, int diameter, Bubble caller) {
		this.caller = caller;
		
		// TODO: automate this in a for loop
		Random rand = new Random();
		bubbles = new SmallBubble[rand.nextInt(3) + 3]; // Between 3 and 5 bubbles
		for (int i = 0; i < bubbles.length; i++) {
			bubbles[i] = new SmallBubble(x, y, diameter / 5, rand.nextInt(120) + 210);
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
		private Image img;
		private int x, y;
		private int diameter;
		private int direction;
		private float alpha;
		
		public SmallBubble(int x, int y, int diameter, int direction) {
//			super();
			this.img = Toolkit.getDefaultToolkit().getImage(Preferences.skinFolderLocation + "/bubble.png").getScaledInstance(diameter, diameter, Image.SCALE_DEFAULT);
			
			alpha = 1.0f;
			this.x = x;
			this.y = y;
			this.diameter = diameter;
			this.direction = direction;
		}
		
		public void move() {
			x += Math.cos(Math.toRadians(direction)) * diameter / 3;
			y += Math.sin(Math.toRadians(direction)) * diameter / 3;
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			move();
			if (alpha > 0.1f) alpha -= 0.1f; 
			else caller.doneAnimating();
			
			((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
			g.drawImage(img, x, y, null);
			
			((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f)); // reset for other things
		}
	}
}
