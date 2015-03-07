package edu.neumont.csc150.bubblebuster;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class GameOverPanel extends JPanel {
	protected GUI frame;
	protected JLabel titleLabel, colThisRunLabel, colRecordLabel, 
		pointsLabel, pointsEarnedLabel, pointsRecordLabel,
		coinsLabel, coinsEarnedLabel, coinsRecordLabel,
		currentCoinsLabel, balanceLabel;
	protected BubbleButton playAgainButton, menuButton;
	private Image background;
	
	public GameOverPanel(GUI frame, Image background, int score, long time) {
		this.frame = frame;
		this.background = background;
		updateStatistics(score, time);
		
		initializeComponents(score);
		addComponents();
	}
	private void updateStatistics(int score, long time) {
		Statistics.walletCoins += score / 10;
		Statistics.totalCoinsAllTime += score / 10;
		Statistics.totalPointsAllTime += score;
		
		if (Statistics.totalPlaytime != null) Statistics.totalPlaytime.addTime(time);
		else Statistics.totalPlaytime = new Time(time);
	}
	private void initializeComponents(int score) {
		titleLabel = new JLabel("Game Over", JLabel.CENTER);
		colThisRunLabel = new JLabel("This Run", JLabel.CENTER);
		colRecordLabel = new JLabel("Record", JLabel.CENTER);
		pointsLabel = new JLabel("Points: ", JLabel.RIGHT);
		pointsEarnedLabel = new JLabel(score + "", JLabel.CENTER);
		pointsRecordLabel = new JLabel("", JLabel.CENTER); // will be updated in the subclass
		coinsLabel = new JLabel("Coins: ", JLabel.RIGHT);
		coinsEarnedLabel = new JLabel((score / 10) + "", JLabel.CENTER);
		coinsRecordLabel = new JLabel("", JLabel.CENTER);
		currentCoinsLabel = new JLabel("Your coins: ", JLabel.RIGHT);
		balanceLabel = new JLabel(Statistics.walletCoins + "", JLabel.CENTER);
		
		titleLabel.setFont(new Font("Arial", Font.BOLD, 64));
		Font headerFont = new Font("Arial", Font.BOLD, 24);
		Font contentFont = new Font("Arial", Font.PLAIN, 18);
		colThisRunLabel.setFont(headerFont);
		colRecordLabel.setFont(headerFont);
		pointsLabel.setFont(headerFont);
		coinsLabel.setFont(headerFont);
		currentCoinsLabel.setFont(headerFont);
		pointsEarnedLabel.setFont(contentFont);
		pointsRecordLabel.setFont(contentFont);
		coinsEarnedLabel.setFont(contentFont);
		balanceLabel.setFont(contentFont);
		
		playAgainButton = new BubbleButton("Play Again");
		menuButton = new BubbleButton("Back to Menu");
		menuButton.addActionListener(e -> {
			frame.switchTo(new MainMenuPanel(frame));
		});
	}
	
	// Not called by the constructor, must be called from child classes
	protected void addComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 0;
		add(titleLabel, c);
		
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		add(colThisRunLabel, c);
		
		c.gridx = 2;
		add(colRecordLabel, c);
		
		c.gridx = 0;
		c.gridy = 3; // Skipping gridy = 2, that will be filled in by the subclasses
		add(pointsLabel,c );
		
		c.gridx = 1;
		add(pointsEarnedLabel, c);
		
		c.gridx = 2;
		add(pointsRecordLabel, c);
		
		c.gridx = 0;
		c.gridy = 3;
		add(coinsLabel, c);
		
		c.gridx = 1;
		add(coinsEarnedLabel, c);
		
		c.gridx = 2;
		add(coinsRecordLabel, c);
		
//		add(currentCoinsLabel);
//		add(balanceLabel);
//		add(new JLabel());
//		add(new JLabel());
//		
//		add(new JLabel());
//		add(playAgainButton, Alignment.CENTER);
//		add(menuButton, Alignment.CENTER);
//		add(new JLabel());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
	}
	
	// TODO: animate the coins transferring
	public void animateTransfer() {
		
	}
}
