package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ShopPanel extends JPanel {
	private BubbleButton menu;
	private JLabel title, header1, header2, wallet;
	private ImageIcon background;
	private ShopItem defaultSkin, pig, robot, alien,
			defaultAmbiance, wubble, farm, space;
	
	public ShopPanel() {
		background = new ImageIcon("resources/blue.jpg");
		setOpaque(false);
		initializeComponents();
		addComponents();
	}
	private void initializeComponents() {
		wallet = new JLabel(Statistics.walletCoins + "");
		wallet.setIcon(new ImageIcon("resources/coin.png"));
		title = new JLabel(new ImageIcon(Toolkit.getDefaultToolkit().getImage("resources/shop.png")
				.getScaledInstance((int) (GUI.WIDTH / 4.3), (int) (GUI.HEIGHT / 4.9), Image.SCALE_DEFAULT)), JLabel.CENTER);
		header2 = new JLabel("Backgrounds & Music Packs", JLabel.LEFT);
		header1 = new JLabel("Skins & Sound Effects Packs", JLabel.LEFT);
		
		menu = new BubbleButton("Back to Menu");
		menu.addActionListener(e -> {
			GUI.getInstance().switchTo(new MainMenuPanel());
		});
		
		Font headerFont = new Font("Arial", Font.BOLD, 36);
		
		header1.setFont(headerFont);
		header1.setForeground(Color.WHITE);
		header2.setFont(headerFont);
		header2.setForeground(Color.WHITE);
		wallet.setFont(headerFont);
		wallet.setForeground(Color.YELLOW);
		
		defaultSkin = new SkinItem("Default Skin", "resources/skins/default", 0);
		robot = new SkinItem("Robot Skin", "resources/skins/robot", 200);
		pig  = new SkinItem("Pig Skin", "resources/skins/pig", 400);
		alien = new SkinItem("Alien Skin", "resources/skins/alien", 800);
		
		defaultAmbiance = new AmbianceItem("Default Pack", "resources/ambiance/default", 0);
		wubble  = new AmbianceItem("Wubble Pack", "resources/ambiance/wubble", 300);
		farm = new AmbianceItem("Farm Pack", "resources/ambiance/farm", 500);
		space = new AmbianceItem("Space Pack", "resources/ambiance/space", 600);
	}
	
	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 10, 10, 10);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		add(title, c);
		
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 4;
		add(wallet, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 4;
		add(header1, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		add(defaultSkin, c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		add(robot, c);
		
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		add(pig, c);
		
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 1;
		add(alien, c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 5;
		add(header2, c);
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		add(defaultAmbiance, c);
		
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		add(wubble, c);
		
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 1;
		add(farm, c);
		
		c.gridx = 3;
		c.gridy = 4;
		c.gridwidth = 1;
		add(space, c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 5;
		add(menu, c);
	}
		
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}
}
