package edu.neumont.csc150.bubblebuster;

import java.awt.Font;
import java.io.IOException;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SurvivalGameOverPanel extends GameOverPanel {
	private JLabel timeLabel, timeSurvivedLabel, timeRecordLabel;
	
	public SurvivalGameOverPanel(GUI frame, int score, long time) {
		super(frame, score, time);
		updateStatistics(score, time);
		initializeComponents(time);
		addComponents();
	}
	private void updateStatistics(int score, long time) {
		if (Statistics.survivalLongestTime != null) {
			if (time > Statistics.survivalLongestTime.getMilliseconds()) Statistics.survivalLongestTime = new Time(time);
		}
		else Statistics.survivalLongestTime = new Time(time);
		
		if (score > Statistics.survivalHighScore) Statistics.survivalHighScore = score;
		
		Statistics.survivalGamesPlayed++;
		
		try {
			Statistics.save();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void initializeComponents(long time) {
		pointsRecordLabel.setText(Statistics.survivalHighScore + "");
		
		timeLabel = new JLabel("Time Survived: ", JLabel.RIGHT);
		timeSurvivedLabel = new JLabel(Time.toString(time), JLabel.CENTER);
		if (Statistics.survivalLongestTime != null) timeRecordLabel = new JLabel(Statistics.survivalLongestTime.toString(), JLabel.CENTER);
		else timeRecordLabel = new JLabel("", JLabel.CENTER);
		
		Font headerFont = new Font("Arial", Font.BOLD, 24);
		Font contentFont = new Font("Arial", Font.PLAIN, 18);
		timeLabel.setFont(headerFont);
		timeSurvivedLabel.setFont(contentFont);
		timeRecordLabel.setFont(contentFont);
	}
	protected void addComponents() {
		addEmptyRow();
		addEmptyRow();
		add(new JLabel());
		add(col1Label);
		add(col2Label);
		add(new JLabel());
		add(timeLabel);
		add(timeSurvivedLabel);
		add(timeRecordLabel);
		add(new JLabel());
		super.addComponents();
	}
	protected void addActionListeners() {
		super.addActionListeners();
		playAgainButton.addActionListener(e -> {
			frame.survivalPanel = new SurvivalMode(frame);
			frame.switchTo(frame.survivalPanel);
		});
	}
}
