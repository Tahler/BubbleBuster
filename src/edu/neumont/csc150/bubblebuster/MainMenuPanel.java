package edu.neumont.csc150.bubblebuster;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainMenuPanel extends JPanel {
	private JFrame frame;
	private final JLabel title = new JLabel("Bubble Buster!");
	// TODO: make these all "BubbleButton"s that extend JButton and override the paintComponent method
	private JButton survivalButton, timeTrialButton, shopButton, statisticsButton, tutorialButton, quitButton, musicButton, effectsButton;
	
	public MainMenuPanel(JFrame frame) {
		this.frame = frame;
		
		// Initialize buttons
		survivalButton = new JButton(new ImageIcon("bubble2.jpg"));
//		survivalButton.setBorder(new EmptyBorder(0,0,0,0)); // removes the hover stuff
		timeTrialButton = new JButton("Time Trial Mode");
		shopButton = new JButton("Shop");
		statisticsButton = new JButton("Statistics");
		tutorialButton = new JButton("Tutorial");
		quitButton = new JButton("Quit");
		musicButton = new JButton("m");
		effectsButton = new JButton("s");
		
		// Add them to the panel
		setLayout(new BorderLayout());
		
		JPanel buttonPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.CENTER;
		
		title.setFont(new Font("SansSerif", Font.BOLD, 30));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 0;
		buttonPanel.add(title, c);
		
		c.ipady = 40;
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
		
		JPanel soundPanel = new JPanel();
		soundPanel.add(musicButton);
		soundPanel.add(effectsButton);
		
		addListeners();
		
		add(buttonPanel, BorderLayout.CENTER);
		add(soundPanel, BorderLayout.SOUTH);
	}
	
	private void addListeners() {
		quitButton.addActionListener(e -> {
			frame.dispose();
		});
	}
}
