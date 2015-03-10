package edu.neumont.csc150.bubblebuster;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ShopItem extends JPanel {
	private JLabel title;
	private Image image;
	private BubbleButton purchaseButton;
	private int cost;
	private String folderPath;
	
	public ShopItem(String title, String folderPath, int cost) {
		this.title = new JLabel(title);
		this.folderPath = folderPath;
		this.image = Toolkit.getDefaultToolkit().getImage(folderPath + "/background.jpg");
		this.cost = cost;
		this.purchaseButton = new BubbleButton(cost + " Coins");
		
		addComponents();
	}
	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		
//		c.
	}
	
	public void purchase() {
		purchaseButton.setVisible(false);
	}
}
