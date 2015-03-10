package edu.neumont.csc150.bubblebuster;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ShopItem extends JPanel {
	private String title;
	private ImageIcon image;
	private BubbleButton purchaseButton;
	private int cost;
	
	public ShopItem(String title, String folderPath, int cost) {
		this.title = title;
		// Scaled to 480x300
		this.image = new ImageIcon(Toolkit.getDefaultToolkit().getImage(folderPath + "/preview.png").getScaledInstance(480, 300, Image.SCALE_DEFAULT));
		this.cost = cost;
		this.purchaseButton = new BubbleButton(cost + " Coins");
		setOpaque(false);
		addComponents();
	}
	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 0;
		add(new JLabel(title), c);
		
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 1;
		add(new JLabel(image), c);
		
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		if (!Purchases.isPurchased(title)) add(purchaseButton, c);
	}
	
	public void purchase() {
		if (Statistics.walletCoins >= cost) {
			Purchases.purchaseAndUse(title);
			
			Statistics.walletCoins -= cost;
			purchaseButton.setVisible(false);
		}
	}
}
