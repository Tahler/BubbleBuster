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
	private BubbleButton menuButton;
	private ImageIcon background;

	public StatisticsPanel(GUI frame) {
		this.frame = frame;
		background = new ImageIcon("resources/blue.jpg");
		setOpaque(false);
		initializeComponents();
		addComponents();
	}
	private void initializeComponents() {
		title = new JLabel("Statistics", JLabel.CENTER);
		
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
			frame.switchTo(new MainMenuPanel(frame));
		});
		
		Font headerFont = new Font("Arial", Font.BOLD, 24);
		Font contentFont = new Font("Arial", Font.PLAIN, 18);
		
		title.setFont(new Font("Arial", Font.BOLD, 36));
		title.setForeground(Color.WHITE);
		general.setFont(headerFont);
		general.setForeground(Color.WHITE);
		totalPointsAllTimeLabel.setFont(contentFont);
		totalPointsAllTimeLabel.setForeground(Color.WHITE);
		totalPointsAllTime.setFont(contentFont);
		totalPointsAllTime.setForeground(Color.WHITE);
		totalCoinsAllTimeLabel.setFont(contentFont);
		totalCoinsAllTimeLabel.setForeground(Color.WHITE);
		totalCoinsAllTime.setFont(contentFont);
		totalCoinsAllTime.setForeground(Color.WHITE);
		totalPlaytimeLabel.setFont(contentFont);
		totalPlaytimeLabel.setForeground(Color.WHITE);
		totalPlaytime.setFont(contentFont);
		totalPlaytime.setForeground(Color.WHITE);
		survival.setFont(headerFont);
		survival.setForeground(Color.WHITE);
		survivalHighScoreLabel.setFont(contentFont);
		survivalHighScoreLabel.setForeground(Color.WHITE);
		survivalHighScore.setFont(contentFont);
		survivalHighScore.setForeground(Color.WHITE);
		survivalGamesPlayedLabel.setFont(contentFont);
		survivalGamesPlayedLabel.setForeground(Color.WHITE);
		survivalGamesPlayed.setFont(contentFont);
		survivalGamesPlayed.setForeground(Color.WHITE);
		survivalLongestTimeLabel.setFont(contentFont);
		survivalLongestTimeLabel.setForeground(Color.WHITE);
		survivalLongestTime.setFont(contentFont);
		survivalLongestTime.setForeground(Color.WHITE);
		timeTrial.setFont(headerFont);
		timeTrial.setForeground(Color.WHITE);
		timeTrialHighScoreLabel.setFont(contentFont);
		timeTrialHighScoreLabel.setForeground(Color.WHITE);
		timeTrialHighScore.setFont(contentFont);
		timeTrialHighScore.setForeground(Color.WHITE);
		timeTrialGamesPlayedLabel.setFont(contentFont);
		timeTrialGamesPlayedLabel.setForeground(Color.WHITE);
		timeTrialGamesPlayed.setFont(contentFont);
		timeTrialGamesPlayed.setForeground(Color.WHITE);
		timeTrialMostBubblesLabel.setFont(contentFont);
		timeTrialMostBubblesLabel.setForeground(Color.WHITE);
		timeTrialMostBubbles.setFont(contentFont);
		timeTrialMostBubbles.setForeground(Color.WHITE);
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
		add(general, c);
		
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 10, 0);
		add(totalPointsAllTimeLabel, c);
		
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 1;
		add(totalPointsAllTime, c);
		
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 3;
		add(totalCoinsAllTimeLabel, c);
		
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 1;
		add(totalCoinsAllTime, c);
		
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 4;
		add(totalPlaytimeLabel, c);
		
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 1;
		add(totalPlaytime, c);
		
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 2;
		c.insets = new Insets(20, 0, 20, 0);
		add(survival, c);

		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 10, 10);
		add(survivalHighScoreLabel, c);

		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 1;
		add(survivalHighScore, c);

		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 7;
		add(survivalGamesPlayedLabel, c);

		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 1;
		add(survivalGamesPlayed, c);

		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 8;
		add(survivalLongestTimeLabel, c);

		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 1;
		add(survivalLongestTime, c);

		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 2;
		c.insets = new Insets(20, 0, 20, 0);
		add(timeTrial, c);

		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 1;
		c.insets = new Insets(0, 0, 10, 10);
		add(timeTrialHighScoreLabel, c);

		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 1;
		c.gridy = 10;
		add(timeTrialHighScore, c);

		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 11;
		add(timeTrialGamesPlayedLabel, c);

		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 1;
		add(timeTrialGamesPlayed, c);

		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 12;
		add(timeTrialMostBubblesLabel, c);

		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 1;
		add(timeTrialMostBubbles, c);

		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 13;
		c.gridwidth = 2;
		c.insets = new Insets(40, 0, 0, 0);
		add(menuButton, c);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}
}