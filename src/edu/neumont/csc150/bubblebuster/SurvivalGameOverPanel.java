package edu.neumont.csc150.bubblebuster;

import java.awt.Font;

import javax.swing.JLabel;

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
