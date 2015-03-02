package edu.neumont.csc150.bubblebuster;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
		
		initializeComponents();
		addComponents();
	}

	private void initializeComponents() {
		title = new JLabel("Statistics");
		
		general = new JLabel("General");
		totalPointsAllTimeLabel = new JLabel("Total Points Earned");
		totalPointsAllTime = new JLabel(Statistics.totalPointsAllTime + "");
		totalCoinsAllTimeLabel = new JLabel("Total Coins Earned");
		totalCoinsAllTime = new JLabel(Statistics.totalCoinsAllTime + "");
		totalPlaytimeLabel = new JLabel("Total Playtime");
		totalPlaytime = new JLabel(Statistics.totalPlaytime + "");
		
		survival = new JLabel("Survival");
		survivalHighScoreLabel = new JLabel("High Score");
		survivalHighScore = new JLabel(Statistics.survivalHighScore + "");
		survivalGamesPlayedLabel = new JLabel("Games Played");
		survivalGamesPlayed = new JLabel(Statistics.survivalGamesPlayed + "");
		survivalLongestTimeLabel = new JLabel("Longest Time Survived");
		survivalLongestTime = new JLabel(Statistics.survivalLongestTime + "");
		
		timeTrial = new JLabel("Time Trial");
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
	}
	private void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		
		c.gridx = 0;
		c.gridy = 0;
		add(title, c);
		
		c.gridx = 0;
		c.gridy = 1;
		add(general, c);
		
		c.gridx = 0;
		c.gridy = 2;
		add(totalPointsAllTimeLabel, c);

		c.gridx = 1;
		c.gridy = 2;
		add(totalPointsAllTime, c);

		c.gridx = 0;
		c.gridy = 3;
		add(totalCoinsAllTimeLabel, c);

		c.gridx = 1;
		c.gridy = 3;
		add(totalCoinsAllTime, c);

		c.gridx = 0;
		c.gridy = 4;
		add(totalPlaytimeLabel, c);

		c.gridx = 1;
		c.gridy = 4;
		add(totalPlaytime, c);

		c.gridx = 0;
		c.gridy = 5;
		add(survival, c);

		c.gridx = 0;
		c.gridy = 6;
		add(survivalHighScoreLabel, c);

		c.gridx = 1;
		c.gridy = 6;
		add(survivalHighScore, c);

		c.gridx = 0;
		c.gridy = 7;
		add(survivalGamesPlayedLabel, c);

		c.gridx = 1;
		c.gridy = 7;
		add(survivalGamesPlayed, c);

		c.gridx = 0;
		c.gridy = 8;
		add(survivalLongestTimeLabel, c);

		c.gridx = 1;
		c.gridy = 8;
		add(survivalLongestTime, c);

		c.gridx = 0;
		c.gridy = 9;
		add(timeTrial, c);

		c.gridx = 0;
		c.gridy = 10;
		add(timeTrialHighScoreLabel, c);

		c.gridx = 1;
		c.gridy = 10;
		add(timeTrialHighScore, c);

		c.gridx = 0;
		c.gridy = 11;
		add(timeTrialGamesPlayedLabel, c);

		c.gridx = 1;
		c.gridy = 11;
		add(timeTrialGamesPlayed, c);

		c.gridx = 0;
		c.gridy = 12;
		add(timeTrialMostBubblesLabel, c);

		c.gridx = 1;
		c.gridy = 12;
		add(timeTrialMostBubbles, c);

		c.gridx = 0;
		c.gridy = 13;
		add(menuButton, c);
	}
	
}