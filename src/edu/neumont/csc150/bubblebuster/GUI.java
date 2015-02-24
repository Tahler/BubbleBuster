package edu.neumont.csc150.bubblebuster;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	private JPanel mainMenuPanel;
	
	public GUI() {
		this("");
	}
	
	public GUI(String title) {
		super(title);
		initializeFrame();
	}
	
	private void initializeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	private void initializePanels() {
		mainMenuPanel = new MainMenuPanel();
	}
}
