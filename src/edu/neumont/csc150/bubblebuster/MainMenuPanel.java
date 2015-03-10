package edu.neumont.csc150.bubblebuster;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainMenuPanel extends JPanel {
	private JLabel title;
	private JPanel buttonPanel, soundPanel;
	private BubbleButton survivalButton, timeTrialButton, shopButton, statisticsButton, quitButton;
//	private BubbleButton survivalButton, timeTrialButton, shopButton, statisticsButton, tutorialButton, quitButton;
	private MusicButton musicButton;
	private SoundButton	effectsButton;
	private ImageIcon background;
	
	public MainMenuPanel() {
		background = new ImageIcon("resources/blue.jpg");
		initializeComponents();
		addComponents();
		addListeners();
	}
	private void initializeComponents() {
		title = new JLabel(new ImageIcon("resources/title.png"), JLabel.CENTER);
		
		survivalButton = new BubbleButton("Survival Mode");
		timeTrialButton = new BubbleButton("Time Trial Mode");
		shopButton = new BubbleButton("Shop");
		statisticsButton = new BubbleButton("Statistics");
//		tutorialButton = new BubbleButton("Tutorial");
		quitButton = new BubbleButton("Quit");
		
		musicButton = new MusicButton();
		effectsButton = new SoundButton();
	}
	private void addComponents() {
		setLayout(new BorderLayout());
		
		buttonPanel = new JPanel(new GridBagLayout());
		buttonPanel.setOpaque(false);
		
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;

		c.gridx = 0;
		c.gridy = 0;
		buttonPanel.add(title, c);
		
		c.insets = new Insets(40, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		buttonPanel.add(survivalButton, c);
		
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		buttonPanel.add(timeTrialButton, c);
		
		c.gridx = 0;
		c.gridy = 4;
		buttonPanel.add(shopButton, c);

		c.gridx = 0;
		c.gridy = 5;
		buttonPanel.add(statisticsButton, c);
		
//		c.gridx = 0;
//		c.gridy = 6;
//		buttonPanel.add(tutorialButton, c);

		c.gridx = 0;
		c.gridy = 7;
		buttonPanel.add(quitButton, c);
		
		soundPanel = new JPanel();
		soundPanel.setOpaque(false);
		soundPanel.add(musicButton);
		soundPanel.add(effectsButton);
		
		add(buttonPanel, BorderLayout.CENTER);
		add(soundPanel, BorderLayout.SOUTH);
	}
	private void addListeners() {
		survivalButton.addActionListener(e -> {
			GUI.getInstance().gamePanel = new SurvivalMode();
			GUI.getInstance().switchTo(GUI.getInstance().gamePanel);
		});
		timeTrialButton.addActionListener(e -> {
			GUI.getInstance().gamePanel = new TimeTrialMode();
			GUI.getInstance().switchTo(GUI.getInstance().gamePanel);
		});
		statisticsButton.addActionListener(e -> {
			GUI.getInstance().switchTo(new StatisticsPanel());
		});
		shopButton.addActionListener(e -> {
			GUI.getInstance().switchTo(new ShopPanel());
		});
		quitButton.addActionListener(e -> {
			GUI.getInstance().dispose();
			System.exit(0);
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}
}
