package edu.neumont.csc150.bubblebuster;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatisticsPanel extends JPanel {
	private GUI frame;
	private JLabel totalPointsAllTime, totalCoinsAllTime, totalPlaytime,
		survivalHighScore, survivalGamesPlayed, survivalLongestTime,
		timeTrialHighScore, timeTrialGamesPlayed, timeTrialMostBubbles;

	public StatisticsPanel(GUI frame) {
		this.frame = frame;
		
		initializeComponents();
	}

	private void initializeComponents() {
		totalPointsAllTime = new JLabel(Statistics.totalPointsAllTime + "");
		totalCoinsAllTime = new JLabel(Statistics.totalCoinsAllTime + "");
		totalPlaytime = new JLabel(Statistics.totalPlaytime + "");
		survivalHighScore = new JLabel(Statistics.survivalHighScore + "");
		survivalGamesPlayed = new JLabel(Statistics.survivalGamesPlayed + "");
		survivalLongestTime = new JLabel(Statistics.survivalLongestTime + "");
		timeTrialHighScore = new JLabel(Statistics.timeTrialHighScore + "");
		timeTrialGamesPlayed = new JLabel(Statistics.timeTrialGamesPlayed + "");
		timeTrialMostBubbles = new JLabel(Statistics.timeTrialMostBubbles + "");
	}
}