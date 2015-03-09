package edu.neumont.csc150.bubblebuster;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class TimeTrialGameOverPanel extends GameOverPanel {
	private JLabel poppedLabel, poppedBubblesThisGameLabel, poppedRecordLabel;
	
	public TimeTrialGameOverPanel(GUI frame, Image background, int score, int popped) {
		super(frame, background, score, 90000L);
		updateStatistics(score, popped);
		initializeComponents(popped);
		addComponents();
		
		playAgainButton.addActionListener(e -> {
			frame.gamePanel = new TimeTrialMode(frame);
			frame.switchTo(frame.gamePanel);
			
		});
		animateTransfer();
	}
	private void updateStatistics(int score, int popped) {

			if (popped > Statistics.timeTrialMostBubbles) Statistics.timeTrialMostBubbles = popped;
		
		if (score > Statistics.timeTrialHighScore) Statistics.timeTrialHighScore = score;
		
		Statistics.timeTrialGamesPlayed++;
		
		try {
			Statistics.save();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void initializeComponents(int popped) {
		pointsRecordLabel.setText(Statistics.timeTrialHighScore + "");
		
		poppedLabel = new JLabel("Bubbles Popped: ", JLabel.RIGHT);
		poppedBubblesThisGameLabel = new JLabel("" + popped, JLabel.CENTER);
		poppedRecordLabel = new JLabel("" + Statistics.timeTrialMostBubbles, JLabel.CENTER);

		
		Font headerFont = new Font("Arial", Font.BOLD, 24);
		Font contentFont = new Font("Arial", Font.PLAIN, 18);
		poppedLabel.setFont(headerFont);
		poppedBubblesThisGameLabel.setFont(contentFont);
		poppedRecordLabel.setFont(contentFont);
	}
	protected void addComponents() {
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;

		c.insets = new Insets(20, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		add(poppedLabel, c);
		
		c.gridx = 1;
		add(poppedBubblesThisGameLabel, c);
		
		c.gridx = 2;
		add(poppedRecordLabel, c);
	}
}
