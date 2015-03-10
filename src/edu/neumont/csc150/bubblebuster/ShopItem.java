package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ShopItem extends JPanel implements MouseListener {
	private String title;
	protected String folderPath;
	private JLabel imageLabel;
	private ImageIcon image;
	private int cost;
	
	public ShopItem(String title, String folderPath, int cost) {
		this.title = title;
		this.folderPath = folderPath;
		this.image = new ImageIcon(folderPath + "/preview.png"); // Scaled to 480x300 //.getScaledInstance(480, 300, Image.SCALE_DEFAULT)
		this.cost = cost;
		
		setOpaque(false);
		addComponents();
		addMouseListener(this);
		if (!Purchases.isPurchased(title)) {
			drawGray();
			imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5, true));
		}
	}
	private void addComponents() {
		Font contentFont = new Font("Arial", Font.PLAIN, 24);
		
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		
		JLabel title = new JLabel(this.title);
		title.setFont(contentFont);
		title.setForeground(Color.WHITE);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 0;
		add(title, c);
		
		imageLabel = new JLabel(image);
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		add(imageLabel, c);
		
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
		if (!Purchases.isPurchased(title)) {
			if (Statistics.walletCoins >= cost) {
				Purchases.purchase(title);
				Statistics.walletCoins -= cost;
				equip();
			}
		}
		else equip();
	}
	
	public void equip() {
		image.setImage(Toolkit.getDefaultToolkit().getImage(folderPath + "/preview.png"));
		imageLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 5, true));
		repaint();
	}
	public void unequip() {
		if (Purchases.isPurchased(title)) imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
		repaint();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		purchase();
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
