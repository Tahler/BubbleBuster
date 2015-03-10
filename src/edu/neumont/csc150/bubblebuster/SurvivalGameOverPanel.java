package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class SurvivalGameOverPanel extends GameOverPanel {
	private JLabel timeLabel, timeSurvivedLabel, timeRecordLabel;
	
	public SurvivalGameOverPanel(Image background, int score, long time) {
		super(background, score, time);
		updateStatistics(score, time);
		this.initializeComponents(time);
		pointsRecordLabel.setText(Statistics.survivalHighScore + "");
		
		addComponents();
		playAgainButton.addActionListener(e -> {
			GUI.getInstance().gamePanel = new SurvivalMode();
			GUI.getInstance().switchTo(GUI.getInstance().gamePanel);
		});
		
		animateTransfer();
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
		timeSurvivedLabel = new JLabel(Time.format(time), JLabel.CENTER);
		if (Statistics.survivalLongestTime != null) timeRecordLabel = new JLabel(Statistics.survivalLongestTime.toString(), JLabel.CENTER);
		else timeRecordLabel = new JLabel("", JLabel.CENTER);
		
		Font headerFont = new Font("Arial", Font.BOLD, 24);
		Font contentFont = new Font("Arial", Font.PLAIN, 18);
		timeLabel.setFont(headerFont);
		timeLabel.setForeground(Color.white);
		timeSurvivedLabel.setFont(contentFont);
		timeSurvivedLabel.setForeground(Color.white);
		timeRecordLabel.setFont(contentFont);
		timeRecordLabel.setForeground(Color.white);
	}
	protected void addComponents() {
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;

		c.insets = new Insets(20, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		add(timeLabel, c);
		
		c.gridx = 1;
		add(timeSurvivedLabel, c);
		
		c.gridx = 2;
		add(timeRecordLabel, c);
	}
}
