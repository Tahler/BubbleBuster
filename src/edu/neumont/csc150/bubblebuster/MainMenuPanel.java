package edu.neumont.csc150.bubblebuster;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel {
	// TODO: make these all "BubbleButton"s that extend JButton and override the paintComponent method
	private JButton survivalButton, timeTrialButton, shopButton, statisticsButton, tutorialButton, musicButton, effectsButton;
	
	public MainMenuPanel() {
		// Initialize buttons
		survivalButton = new JButton();
		timeTrialButton = new JButton();
		shopButton = new JButton();
		statisticsButton = new JButton();
		tutorialButton = new JButton();
		musicButton = new JButton();
		effectsButton = new JButton();
		
		// Add them to the panel
		setLayout(new BorderLayout());
		JPanel buttonPanel = new JPanel(new GridLayout());
		buttonPanel.add(survivalButton);
		buttonPanel.add(timeTrialButton);
		buttonPanel.add(shopButton);
		buttonPanel.add(statisticsButton);
		buttonPanel.add(tutorialButton);
		JPanel soundPanel = new JPanel();
		
		add(buttonPanel, BorderLayout.CENTER);
		add(musicButton);
		add(effectsButton);
	}
}
