package edu.neumont.csc150.bubblebuster;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainMenuPanel extends JPanel {
	private GUI frame;
	private final JLabel title = new JLabel("Bubble Buster!", JLabel.CENTER);
	private JPanel buttonPanel, soundPanel;
	
	private BubbleButton survivalButton, timeTrialButton, shopButton, statisticsButton, tutorialButton, quitButton;
	private JButton	musicButton, effectsButton;
	
	private final ImageIcon musicButtonImage = new ImageIcon("images/music.png");
	private final ImageIcon musicButtonImageX = new ImageIcon("images/musicx.png");
	private final ImageIcon effectsButtonImage = new ImageIcon("images/soundFX.png");
	private final ImageIcon effectsButtonImageX = new ImageIcon("images/soundFXx.png");
	
	public MainMenuPanel(GUI frame) {
		this.frame = frame;
		title.setForeground(Color.WHITE);
		initializeButtons();
		addComponents();
		addListeners();
	}
	private void initializeButtons() {
		survivalButton = new BubbleButton("Survival Mode");
		timeTrialButton = new BubbleButton("Time Trial Mode");
		shopButton = new BubbleButton("Shop");
		statisticsButton = new BubbleButton("Statistics");
		tutorialButton = new BubbleButton("Tutorial");
		quitButton = new BubbleButton("Quit");
		
		musicButton = new JButton(musicButtonImage);
		effectsButton = new JButton(effectsButtonImage);
	}
	private void addComponents() {
		setLayout(new BorderLayout());
		
		buttonPanel = new JPanel(new GridBagLayout());
		buttonPanel.setOpaque(false);
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.CENTER;
		
		title.setFont(new Font("SansSerif", Font.BOLD, 30));
		title.setAlignmentX(CENTER_ALIGNMENT);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 0;
		buttonPanel.add(title, c);
		
		System.out.println(BubbleButton.IMG.getIconWidth());
		c.ipadx = BubbleButton.IMG.getIconWidth();
		System.out.println(c.ipadx);
		
		c.ipady = BubbleButton.IMG.getIconHeight();
		c.insets = new Insets(40, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		buttonPanel.add(survivalButton, c);
		
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		buttonPanel.add(timeTrialButton, c);
		
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 4;
		buttonPanel.add(shopButton, c);

		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 5;
		buttonPanel.add(statisticsButton, c);
		
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 6;
		buttonPanel.add(tutorialButton, c);
		
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 7;
		buttonPanel.add(quitButton, c);
		
		System.out.println(c.ipadx);
		
		soundPanel = new JPanel();
		soundPanel.setOpaque(false);
		soundPanel.add(musicButton);
		soundPanel.add(effectsButton);
		
		add(buttonPanel, BorderLayout.CENTER);
		add(soundPanel, BorderLayout.SOUTH);
	}
	private void addListeners() {
		survivalButton.addActionListener(e -> {
			frame.gamePanel = new SurvivalMode(frame);
			frame.switchTo(frame.gamePanel);
		});
		timeTrialButton.addActionListener(e -> {
			frame.gamePanel = new TimeTrialMode(frame);
			frame.switchTo(frame.gamePanel);
		});
		statisticsButton.addActionListener(e -> {
			frame.switchTo(new StatisticsPanel(frame));
		});
		quitButton.addActionListener(e -> {
			frame.dispose();
		});
		musicButton.addActionListener(e -> {
			if (musicButton.getIcon().equals(musicButtonImage)) musicButton.setIcon(musicButtonImageX);
			else musicButton.setIcon(musicButtonImage);
		});
		effectsButton.addActionListener(e -> {
			if (effectsButton.getIcon().equals(effectsButtonImage)) effectsButton.setIcon(effectsButtonImageX);
			else effectsButton.setIcon(effectsButtonImage);
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(new ImageIcon("images/blue.jpg").getImage(), 0, 0, null);
	}
}
