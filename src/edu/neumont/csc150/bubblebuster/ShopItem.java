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
	private JLabel title;
	private ImageIcon image;
	private BubbleButton purchaseButton;
	private int cost;
	
	public ShopItem(String title, String folderPath, int cost) {
		this.title = new JLabel(title);
		// Scaled to 480x300
		this.image = new ImageIcon(Toolkit.getDefaultToolkit().getImage(folderPath + "/background.jpg").getScaledInstance(480, 300, Image.SCALE_DEFAULT));
		this.cost = cost;
		this.purchaseButton = new BubbleButton(cost + " Coins");
		
		addComponents();
	}
	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 0;
		add(title, c);
		
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 1;
		c.gridy = 0;
		add(new JLabel(image), c);
		
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 2;
		c.gridy = 0;
		add(purchaseButton, c);
	}
	
	public void purchase() {
		if (Statistics.walletCoins >= cost) {
			Purchases.purchaseAndUse(title.getText());
			
			Statistics.walletCoins -= cost;
			purchaseButton.setVisible(false);
		}
	}
}
