package edu.neumont.csc150.bubblebuster;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	private JPanel mainMenuPanel;
	
	private JPanel currentPanel;
	
	public GUI() {
		this("");
	}
	
	public GUI(String title) {
		super(title);
		initializeFrame();
		initializePanels();
		switchTo(mainMenuPanel);
	}
	
	private void initializeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	private void initializePanels() {
		mainMenuPanel = new MainMenuPanel();
		
		add(mainMenuPanel);
	}
	
	public void switchTo(JPanel panel) {
		if (currentPanel != null) currentPanel.setVisible(false);
		currentPanel = panel;
		panel.setVisible(true);
	}
}
