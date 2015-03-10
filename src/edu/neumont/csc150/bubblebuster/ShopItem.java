package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ShopItem extends JPanel implements MouseListener {
	private String title;
	private ImageIcon image;
	private int cost;
	
	public ShopItem(String title, String folderPath, int cost) {
		this.title = title;
		this.image = new ImageIcon(folderPath + "/preview.png"); // Scaled to 480x300 //.getScaledInstance(480, 300, Image.SCALE_DEFAULT)
		this.cost = cost;
		
		setOpaque(false);
		addComponents();
		if (!Purchases.isPurchased(title)) drawGray();
	}
	private void addComponents() {
		Font contentFont = new Font("Arial", Font.PLAIN, 24);
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		
		JLabel x = new JLabel(title);
		x.setFont(contentFont);
		x.setForeground(Color.WHITE);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 0;
		add(x, c);
		
		x = new JLabel(image);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		add(x, c);
		
//		c.insets = new Insets(0, 0, 0, 0);
//		c.gridx = 0;
//		c.gridy = 2;
	}
	private void drawGray() {
		// Create a grayscale image of the preview
		BufferedImage bImage = new BufferedImage(image.getIconWidth(), image.getIconHeight(), BufferedImage.TYPE_BYTE_GRAY);
		Graphics g = bImage.getGraphics();
		g.drawImage(image.getImage(), 0, 0, null);
		g.dispose();
		
//		// Write text in yellow over the grayscale image
		BufferedImage bImageColor = new BufferedImage(image.getIconWidth(), image.getIconHeight(), BufferedImage.TYPE_BYTE_INDEXED);
		g = bImageColor.getGraphics();
		g.drawImage(bImage, 0, 0, null);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Arial", Font.BOLD, 48));
		String cost = this.cost + " Coins";
		g.drawString(cost, bImageColor.getWidth() / 2 - (int) g.getFontMetrics().getStringBounds(cost, g).getWidth() / 2, bImageColor.getHeight() / 2);
		g.dispose();
		
		// Set that as the new image.
		image.setImage(bImageColor);
	}
	
	public void purchase() {
		if (Statistics.walletCoins >= cost) {
			Purchases.purchaseAndUse(title);
			
			Statistics.walletCoins -= cost;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
