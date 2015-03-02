package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatisticsPanel extends JPanel {
	private GUI frame;
	private JLabel title;
	private JLabel general, survival, timeTrial;
	private JLabel totalPointsAllTimeLabel, totalCoinsAllTimeLabel, totalPlaytimeLabel,
		survivalHighScoreLabel, survivalGamesPlayedLabel, survivalLongestTimeLabel,
		timeTrialHighScoreLabel, timeTrialGamesPlayedLabel, timeTrialMostBubblesLabel;
	private JLabel totalPointsAllTime, totalCoinsAllTime, totalPlaytime,
		survivalHighScore, survivalGamesPlayed, survivalLongestTime,
		timeTrialHighScore, timeTrialGamesPlayed, timeTrialMostBubbles;
	private JButton menuButton;

	public StatisticsPanel(GUI frame) {
		this.frame = frame;
		setBackground(new Color(0, 195, 217));
		initializeComponents();
		addComponents();
	}

	private void initializeComponents() {
		title = new JLabel("Statistics", JLabel.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 36));
		
		general = new JLabel("General", JLabel.CENTER);
		totalPointsAllTimeLabel = new JLabel("Total Points Earned", JLabel.LEFT);
		totalPointsAllTime = new JLabel(Statistics.totalPointsAllTime + "");
		totalCoinsAllTimeLabel = new JLabel("Total Coins Earned", JLabel.LEFT);
		totalCoinsAllTime = new JLabel(Statistics.totalCoinsAllTime + "");
		totalPlaytimeLabel = new JLabel("Total Playtime", JLabel.LEFT);
		totalPlaytime = new JLabel(Statistics.totalPlaytime + "");
		
		survival = new JLabel("Survival Mode", JLabel.CENTER);
		survivalHighScoreLabel = new JLabel("High Score");
		survivalHighScore = new JLabel(Statistics.survivalHighScore + "");
		survivalGamesPlayedLabel = new JLabel("Games Played");
		survivalGamesPlayed = new JLabel(Statistics.survivalGamesPlayed + "");
		survivalLongestTimeLabel = new JLabel("Longest Time Survived");
		survivalLongestTime = new JLabel(Statistics.survivalLongestTime + "");
		
		timeTrial = new JLabel("Time-Trial Mode", JLabel.CENTER);
		timeTrialHighScoreLabel = new JLabel("High Score");
		timeTrialHighScore = new JLabel(Statistics.timeTrialHighScore + "");
		timeTrialGamesPlayedLabel = new JLabel("Games Played");
		timeTrialGamesPlayed = new JLabel(Statistics.timeTrialGamesPlayed + "");
		timeTrialMostBubblesLabel = new JLabel("Most Bubbles Popped in One Game");
		timeTrialMostBubbles = new JLabel(Statistics.timeTrialMostBubbles + "");
		
		menuButton = new BubbleButton("Back to Menu");
		menuButton.addActionListener(e -> {
			frame.switchTo(frame.mainMenuPanel);
		});
		
		Font headerFont = new Font("Arial", Font.BOLD, 24);
		Font contentFont = new Font("Arial", Font.PLAIN, 18);
		
		general.setFont(headerFont);
		totalPointsAllTimeLabel.setFont(contentFont);
		totalCoinsAllTimeLabel.setFont(contentFont);
		totalPlaytimeLabel.setFont(contentFont);
		survival.setFont(headerFont);
		survivalHighScoreLabel.setFont(contentFont);
		survivalGamesPlayedLabel.setFont(contentFont);
		survivalLongestTimeLabel.setFont(contentFont);
		timeTrial.setFont(headerFont);
		timeTrialHighScoreLabel.setFont(contentFont);
		timeTrialGamesPlayedLabel.setFont(contentFont);
		timeTrialMostBubblesLabel.setFont(contentFont);
	}
	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		
		c.weightx = 0.1;
		c.weighty = 0.0;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.insets = new Insets(0, 0, 20, 0);
		add(title, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		c.insets = new Insets(20, 0, 20, 0);
		add(general, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 10, 10);
		add(totalPointsAllTimeLabel, c);

		c.gridx = 1;
		add(totalPointsAllTime, c);

		c.gridx = 0;
		c.gridy = 3;
		add(totalCoinsAllTimeLabel, c);

		c.gridx = 1;
		add(totalCoinsAllTime, c);

		c.gridx = 0;
		c.gridy = 4;
		add(totalPlaytimeLabel, c);

		c.gridx = 1;
		add(totalPlaytime, c);

		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 2;
		c.insets = new Insets(20, 0, 20, 0);
		add(survival, c);

		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 10, 10);
		add(survivalHighScoreLabel, c);

		c.gridx = 1;
		add(survivalHighScore, c);

		c.gridx = 0;
		c.gridy = 7;
		add(survivalGamesPlayedLabel, c);

		c.gridx = 1;
		add(survivalGamesPlayed, c);

		c.gridx = 0;
		c.gridy = 8;
		add(survivalLongestTimeLabel, c);

		c.gridx = 1;
		add(survivalLongestTime, c);

		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 2;
		c.insets = new Insets(20, 0, 20, 0);
		add(timeTrial, c);

		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 10, 10);
		add(timeTrialHighScoreLabel, c);

		c.gridx = 1;
		c.gridy = 10;
		add(timeTrialHighScore, c);

		c.gridx = 0;
		c.gridy = 11;
		add(timeTrialGamesPlayedLabel, c);

		c.gridx = 1;
		add(timeTrialGamesPlayed, c);

		c.gridx = 0;
		c.gridy = 12;
		add(timeTrialMostBubblesLabel, c);

		c.gridx = 1;
		add(timeTrialMostBubbles, c);

		c.gridx = 0;
		c.gridy = 13;
		c.gridwidth = 2;
		add(menuButton, c);
	}
	
}