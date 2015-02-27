package edu.neumont.csc150.bubblebuster;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class GameOverPanel extends JPanel {
	protected GUI frame;
	protected JPanel tablePanel, buttonPanel;
	protected JLabel titleLabel, col1Label, col2Label, pointsLabel, pointsEarnedLabel, pointsRecordLabel,
		coinsLabel, coinsEarnedLabel, coinsRecordLabel,
		currentCoinsLabel, balanceLabel;
	protected JButton playAgainButton, menuButton;
	
	public GameOverPanel(GUI frame, int score) {
		this.frame = frame;
		setBackground(new Color(0, 195, 217));
		initializeComponents(score);
		addActionListeners();
		setLayout(new BorderLayout(0, 0)); // TODO use spacing
	}
	private void initializeComponents(int score) {
		tablePanel = new JPanel(new GridLayout(5, 3)); // TODO use spacing
		buttonPanel = new JPanel(new GridLayout(1, 2, 0, 100));
		tablePanel.setBackground(this.getBackground());
		buttonPanel.setBackground(this.getBackground());
		
		titleLabel = new JLabel("Game Over", JLabel.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
		
		col1Label = new JLabel("This Run", JLabel.CENTER);
		col2Label = new JLabel("Record", JLabel.CENTER);
		pointsLabel = new JLabel("Points: ", JLabel.RIGHT);
		pointsEarnedLabel = new JLabel(score + "", JLabel.CENTER);
		pointsRecordLabel = new JLabel("", JLabel.CENTER);
//		pointsRecordLabel = new JLabel(Statistics.survivalHighScore + "");
		coinsLabel = new JLabel("Coins: ", JLabel.RIGHT);
		coinsEarnedLabel = new JLabel((score / 10) + "", JLabel.CENTER);
		coinsRecordLabel = new JLabel("", JLabel.CENTER);
//		coinsRecordLabel = new JLabel(Statistics.)
		currentCoinsLabel = new JLabel("Your coins: ", JLabel.RIGHT);
//		balanceLabel = new JLabel(Statistics.walletCoins + "");
		balanceLabel = new JLabel("", JLabel.CENTER);
		
		Font headerFont = new Font("Arial", Font.BOLD, 24);
		Font contentFont = new Font("Arial", Font.PLAIN, 18);
		col1Label.setFont(headerFont);
		col2Label.setFont(headerFont);
		pointsLabel.setFont(headerFont);
		coinsLabel.setFont(headerFont);
		currentCoinsLabel.setFont(headerFont);
		pointsEarnedLabel.setFont(contentFont);
		pointsRecordLabel.setFont(contentFont);
		coinsEarnedLabel.setFont(contentFont);
		balanceLabel.setFont(contentFont);
		
		playAgainButton = new JButton("Play Again");
		menuButton = new JButton("Back to Menu");
	}
	protected void addActionListeners() {
		menuButton.addActionListener(e -> {
			frame.switchTo(frame.mainMenuPanel);
		});
	}
	
	// Not called by the constructor, must be called from child classes
	protected void addComponents() {
		tablePanel.add(pointsLabel);
		tablePanel.add(pointsEarnedLabel);
		tablePanel.add(pointsRecordLabel);
		tablePanel.add(coinsLabel);
		tablePanel.add(coinsEarnedLabel);
		tablePanel.add(coinsRecordLabel);
		tablePanel.add(currentCoinsLabel);
		tablePanel.add(balanceLabel);
		tablePanel.add(new JLabel());
		
		buttonPanel.add(playAgainButton);
		buttonPanel.add(menuButton);
		
		add(titleLabel, BorderLayout.NORTH);
		add(tablePanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public void animateTransfer() {
		
	}
}
