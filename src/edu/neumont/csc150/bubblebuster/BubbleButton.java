package edu.neumont.csc150.bubblebuster;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class BubbleButton extends JComponent implements MouseListener, ActionListener {
	public static final ImageIcon IMG = new ImageIcon("images\\button.png");
	public static final ImageIcon HOVER = new ImageIcon("images\\buttonGlow.png");
	private Image currentImage;
	private ActionListener actionListener = null;
	private String text;
	
	public BubbleButton() {
		this("");
	}
	public BubbleButton(String text) {
		setText(text);
		setImage(IMG.getImage());
		addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(this.getImage(), 0, 0, null);
		g.setFont(new Font("SansSerif", Font.BOLD, 36));
		
		Rectangle2D metrics = g.getFontMetrics().getStringBounds(getText(), g);
		g.drawString(getText(), (int) (IMG.getIconWidth() / 2 - metrics.getWidth() / 2), (int) (IMG.getIconHeight() / 2 + metrics.getHeight() / 2));
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Image getImage() {
		return currentImage;
	}
	public void setImage(Image currentImage) {
		this.currentImage = currentImage;
	}
	
	public void addActionListener(ActionListener a) {
		this.actionListener = a;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (actionListener != null) {
			actionListener.actionPerformed(e);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		actionPerformed(new ActionEvent(e, 123, "BubbleButton Click"));
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setImage(HOVER.getImage());
		repaint();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		setImage(IMG.getImage());
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
