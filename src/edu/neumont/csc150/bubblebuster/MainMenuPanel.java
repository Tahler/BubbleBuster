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
		survivalButton = new JButton("Survival Mode");
		timeTrialButton = new JButton("Time Trial Mode");
		shopButton = new JButton("Shop");
		statisticsButton = new JButton("Statistics");
		tutorialButton = new JButton("Tutorial");
		musicButton = new JButton("m");
		effectsButton = new JButton("s");
		
		// Add them to the panel
		setLayout(new BorderLayout());
		
		JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
		buttonPanel.add(survivalButton);
		buttonPanel.add(timeTrialButton);
		buttonPanel.add(shopButton);
		buttonPanel.add(statisticsButton);
		buttonPanel.add(tutorialButton);
		
		JPanel soundPanel = new JPanel();
		soundPanel.add(musicButton);
		soundPanel.add(effectsButton);
		
		add(buttonPanel, BorderLayout.CENTER);
		add(soundPanel, BorderLayout.SOUTH);
	}
}
