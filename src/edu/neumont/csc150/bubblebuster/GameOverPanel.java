package edu.neumont.csc150.bubblebuster;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class GameOverPanel extends JPanel {
	protected GUI frame;
	protected JLabel titleLabel, col1Label, col2Label, pointsLabel, pointsEarnedLabel, pointsRecordLabel,
		coinsLabel, coinsEarnedLabel, coinsRecordLabel,
		currentCoinsLabel, balanceLabel;
	protected JButton playAgainButton, menuButton;
	
	// TODO: USE GRIDBAGLAYOUT
	public GameOverPanel(GUI frame, int score) {
		this.frame = frame;
		updateStatistics(score);
		setBackground(new Color(0, 195, 217));
		initializeComponents(score);
		addActionListeners();
		GridLayout grid = new GridLayout(10, 4);
		setLayout(grid);
	}
	private void updateStatistics(int score) {
		Statistics.walletCoins += score / 10;
		Statistics.totalCoinsAllTime += score / 10;
		Statistics.totalPointsAllTime += score;
	}
	private void initializeComponents(int score) {
		titleLabel = new JLabel("Game Over", JLabel.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
		
		col1Label = new JLabel("This Run", JLabel.CENTER);
		col2Label = new JLabel("Record", JLabel.CENTER);
		pointsLabel = new JLabel("Points: ", JLabel.RIGHT);
		pointsEarnedLabel = new JLabel(score + "", JLabel.CENTER);
		pointsRecordLabel = new JLabel("", JLabel.CENTER); // will be updated in the subclass
		coinsLabel = new JLabel("Coins: ", JLabel.RIGHT);
		coinsEarnedLabel = new JLabel((score / 10) + "", JLabel.CENTER);
		coinsRecordLabel = new JLabel("", JLabel.CENTER);
//		coinsRecordLabel = new JLabel(Statistics.)
		currentCoinsLabel = new JLabel("Your coins: ", JLabel.RIGHT);
		balanceLabel = new JLabel(Statistics.walletCoins + "", JLabel.CENTER);
		
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
		
//		playAgainButton = new JButton(new ImageIcon(Toolkit.getDefaultToolkit().getImage("images\\button.png")));
//		playAgainButton.setBackground(null);
//		playAgainButton.setBorder(null);
//		playAgainButton.setText("Play Again");
		playAgainButton = new BubbleButton("Play Again");
		menuButton = new BubbleButton("Back to Menu");
	}
	protected void addActionListeners() {
		menuButton.addActionListener(e -> {
			frame.switchTo(frame.mainMenuPanel);
		});
	}
	
	// Not called by the constructor, must be called from child classes
	protected void addEmptyRow() {
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
	}
	protected void addComponents() {
		add(pointsLabel);
		add(pointsEarnedLabel);
		add(pointsRecordLabel);
		add(new JLabel());
		
		add(coinsLabel);
		add(coinsEarnedLabel);
		add(coinsRecordLabel);
		add(new JLabel());
		
		add(currentCoinsLabel);
		add(balanceLabel);
		add(new JLabel());
		add(new JLabel());
		
		addEmptyRow();
		
		add(new JLabel());
		add(playAgainButton, Alignment.CENTER);
		add(menuButton, Alignment.CENTER);
		add(new JLabel());
		
		addEmptyRow();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Arial", Font.BOLD, 36));
		g.drawString("Game Over", GUI.WIDTH / 2 - (int) g.getFontMetrics().getStringBounds("Game Over", g).getWidth() / 2, GUI.HEIGHT / 5);
	}
	
	public void animateTransfer() {
		
	}
}
