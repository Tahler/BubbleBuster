package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ShopPanel extends JPanel implements Observer {
	private BubbleButton menu;
	private JLabel title, header1, header2;
	private ImageIcon background;
	private ShopItem defaultSkin, alien, pig, robot,
			defaultAmbiance, wubble, atlantis, space;
	
	public ShopPanel() {
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
			GUI.getInstance().switchTo(new MainMenuPanel());
		});
		
		Font headerFont = new Font("Arial", Font.BOLD, 36);
		
		header1.setFont(headerFont);
		header1.setForeground(Color.WHITE);
		header2.setFont(headerFont);
		header2.setForeground(Color.WHITE);
		
//		defaultSkin = new ShopItem("Default Skin", "resources/skins/default", 0);
//		pig  = new ShopItem("Pig Skin", "resources/skins/pig", 10);
//		alien = new ShopItem("Alien Skin", "resources/skins/alien", 0);
		
		defaultAmbiance = new AmbianceItem("Default Pack", "resources/ambiance/default", 0);
		wubble  = new AmbianceItem("Wubble Pack", "resources/ambiance/wubble", 10);
		atlantis = new AmbianceItem("Atlantis Pack", "resources/ambiance/atlantis", 10);
//		space = new AmbianceItem("Space Pack", "resources/ambiance/space", 0);
	}
	
	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		c.insets = new Insets(10, 10, 10, 10);
		add(title, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 4;
//		c.insets = new Insets(20, 0, 20, 0);
		add(header1, c);
		
//		c.gridx = 0;
//		c.gridy = 2;
//		c.gridwidth = 1;
////		c.insets = new Insets(20, 0, 20, 0);
//		add(defaultSkin, c);
//		
//		c.gridx = 1;
//		c.gridy = 2;
//		c.gridwidth = 1;
////		c.insets = new Insets(20, 0, 20, 0);
//		add(pig, c);
//		
//		c.gridx = 2;
//		c.gridy = 2;
//		c.gridwidth = 1;
////		c.insets = new Insets(20, 0, 20, 0);
//		add(alien, c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 4;
//		c.insets = new Insets(20, 0, 20, 0);
		add(header2, c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
//		c.insets = new Insets(20, 0, 20, 0);
		add(defaultAmbiance, c);
		
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
//		c.insets = new Insets(20, 0, 20, 0);
		add(wubble, c);
		
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 1;
//		c.insets = new Insets(20, 0, 20, 0);
		add(atlantis, c);
		
//		c.gridx = 3;
//		c.gridy = 4;
//		c.gridwidth = 1;
//		c.insets = new Insets(20, 0, 20, 0);
//		add(space, c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 4;
		add(menu, c);
	}
		
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}
}
