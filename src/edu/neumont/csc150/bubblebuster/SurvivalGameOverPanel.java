package edu.neumont.csc150.bubblebuster;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SurvivalGameOverPanel extends GameOverPanel {
	private JLabel timeLabel, timeSurvivedLabel, timeRecordLabel;
	
	public SurvivalGameOverPanel(GUI frame, int score, String time) {
		super(frame, score);
		// update statistics
		timeLabel = new JLabel("Time Survived: ");
		timeSurvivedLabel = new JLabel(time);
		timeRecordLabel = new JLabel();
//		timeRecordLabel = new JLabel(Statistics.survivalLongestTime);
		addComponents();
	}
	protected void addComponents() {
		add(timeLabel);
		add(timeSurvivedLabel);
		add(timeRecordLabel);
		super.addComponents();
	}
	
}
