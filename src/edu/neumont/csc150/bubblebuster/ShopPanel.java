package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ShopPanel extends JPanel {
	private GUI frame;
	private BubbleButton menu;
	private JLabel title, header1, header2;
	private ImageIcon background;
	
	
	public ShopPanel(GUI frame) {
		this.frame = frame;
		background = new ImageIcon("resources/blue.jpg");
		setOpaque(false);
		initializeComponents();
		addComponents();
	}
	private void initializeComponents() {
		title = new JLabel(new ImageIcon("resources/shop.png"), JLabel.CENTER);
		
		header1 = new JLabel("Backgrounds & Music Packs", JLabel.LEFT);
		header2 = new JLabel("Skins & Sound Effects Packs", JLabel.LEFT);
		
		
		menu = new BubbleButton("Back to Menu");
		menu.addActionListener(e -> {
			frame.switchTo(new MainMenuPanel(frame));
		});
		
		Font headerFont = new Font("Arial", Font.BOLD, 24);
		Font contentFont = new Font("Arial", Font.PLAIN, 18);
		
		title.setFont(new Font("Arial", Font.BOLD, 36));
		title.setForeground(Color.WHITE);
		header1.setFont(headerFont);
		header1.setForeground(Color.WHITE);
		header2.setFont(headerFont);
		header2.setForeground(Color.WHITE);
	}
	
	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.insets = new Insets(0, 0, 20, 0);
		add(title, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		c.insets = new Insets(20, 0, 20, 0);
		add(header1, c);
		
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 2;
		c.insets = new Insets(20, 0, 20, 0);
		add(header2, c);
		
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 13;
		c.gridwidth = 2;
		c.insets = new Insets(40, 0, 0, 0);
		add(menu, c);
	}
		
		
		
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}
}
