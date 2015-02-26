package edu.neumont.csc150.bubblebuster;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class GameOverPanel extends JPanel {
	private GUI frame;
	protected JLabel pointsLabel, pointsEarnedLabel, pointsRecordLabel,
		coinsLabel, coinsEarnedLabel, coinsRecordLabel,
		currentCoinsLabel, balanceLabel;
	private JButton playAgainButton, menuButton;
	
	public GameOverPanel(GUI frame, int score) {
		initializeComponents(score);
		addActionListeners();
		setLayout(new GridLayout(4, 3)); // TODO use spacing
	}
	private void initializeComponents(int score) {
		pointsLabel = new JLabel("Points: ");
		pointsEarnedLabel = new JLabel(score + "");
		pointsRecordLabel = new JLabel();
//		pointsRecordLabel = new JLabel(Statistics.survivalHighScore + "");
		coinsLabel = new JLabel("Coins: ");
		coinsEarnedLabel = new JLabel((score / 10) + "");
		coinsRecordLabel = new JLabel();
//		coinsRecordLabel = new JLabel(Statistics.)
		currentCoinsLabel = new JLabel("Your coins: ");
//		balanceLabel = new JLabel(Statistics.walletCoins + "");
		balanceLabel = new JLabel();
		
		playAgainButton = new JButton("Play Again");
		menuButton = new JButton("Back to Menu");
	}
	private void addActionListeners() {
		playAgainButton.addActionListener(e -> {
			frame.survivalPanel = new SurvivalMode(frame);
			frame.switchTo(frame.survivalPanel);
		});
		menuButton.addActionListener(e -> {
			frame.switchTo(frame.mainMenuPanel);
		});
	}
	protected void addComponents() {
		add(pointsLabel);
		add(pointsEarnedLabel);
		add(pointsRecordLabel);
		add(coinsLabel);
		add(coinsEarnedLabel);
		add(coinsRecordLabel);
		add(currentCoinsLabel);
		add(balanceLabel);
		add(new JPanel());
	}
	
	public void animateTransfer() {
		
	}
}
