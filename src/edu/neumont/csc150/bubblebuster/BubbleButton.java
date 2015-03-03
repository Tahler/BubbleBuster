package edu.neumont.csc150.bubblebuster;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class BubbleButton extends JButton {
	public static final ImageIcon IMG = new ImageIcon("images\\button2.png");
	
	public BubbleButton() {
		this("");
	}
	public BubbleButton(String text) {
		super(text);
//		setBorder(new EmptyBorder(0, 0, 0, 0));
//		setMaximumSize(new Dimension(IMG.getIconWidth(), IMG.getIconHeight()));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(IMG.getImage(), 0, 0, null);
		g.setFont(new Font("SansSerif", Font.BOLD, 36));
		
		Rectangle2D metrics = g.getFontMetrics().getStringBounds(super.getText(), g);
		g.drawString(super.getText(), (int) (IMG.getIconWidth() / 2 - metrics.getWidth() / 2), (int) (IMG.getIconHeight() / 2 + metrics.getHeight() / 2));
	}
}
