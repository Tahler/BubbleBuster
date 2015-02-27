package edu.neumont.csc150.bubblebuster;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SurvivalGameOverPanel extends GameOverPanel {
	private JLabel timeLabel, timeSurvivedLabel, timeRecordLabel;
	
	public SurvivalGameOverPanel(GUI frame, int score, String time) {
		super(frame, score);
		// update statistics
		initializeComponents(time);
		addComponents();
	}
	private void initializeComponents(String time) {
		timeLabel = new JLabel("Time Survived: ", JLabel.RIGHT);
		timeSurvivedLabel = new JLabel(time, JLabel.CENTER);
		timeRecordLabel = new JLabel("", JLabel.CENTER);
//		timeRecordLabel = new JLabel(Statistics.survivalLongestTime);
		
		Font headerFont = new Font("Arial", Font.BOLD, 24);
		Font contentFont = new Font("Arial", Font.PLAIN, 18);
		timeLabel.setFont(headerFont);
		timeSurvivedLabel.setFont(contentFont);
		timeRecordLabel.setFont(contentFont);
	}
	protected void addComponents() {
		tablePanel.add(new JLabel());
		tablePanel.add(col1Label);
		tablePanel.add(col2Label);
		tablePanel.add(timeLabel);
		tablePanel.add(timeSurvivedLabel);
		tablePanel.add(timeRecordLabel);
		super.addComponents();
	}
}
