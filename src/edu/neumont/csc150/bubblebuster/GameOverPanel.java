package edu.neumont.csc150.bubblebuster;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class GameOverPanel extends JPanel {
	protected GUI frame;
	protected JLabel titleLabel, col1Label, col2Label, pointsLabel, pointsEarnedLabel, pointsRecordLabel,
		coinsLabel, coinsEarnedLabel, coinsRecordLabel,
		currentCoinsLabel, balanceLabel;
	protected JButton playAgainButton, menuButton;
	private Image background;
	
	// TODO: USE GRIDBAGLAYOUT
	public GameOverPanel(GUI frame, Image background, int score, long time) {
		this.frame = frame;
		this.background = background;
		updateStatistics(score, time);
		
		initializeComponents(score);
		addActionListeners();
		
		GridLayout grid = new GridLayout(10, 4);
		setLayout(grid);
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
			frame.switchTo(new MainMenuPanel(frame));
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
		g.drawImage(background, 0, 0, null);
		g.setFont(new Font("Arial", Font.BOLD, 36));
		g.drawString("Game Over", GUI.WIDTH / 2 - (int) g.getFontMetrics().getStringBounds("Game Over", g).getWidth() / 2, GUI.HEIGHT / 5);
	}
	
	public void animateTransfer() {
		
	}
}
