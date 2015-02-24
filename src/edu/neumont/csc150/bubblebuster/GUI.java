package edu.neumont.csc150.bubblebuster;

import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		initializePanels();
		initializeFrame();		
		switchTo(mainMenuPanel);
	}
	
	private void initializeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
	}
	private void initializePanels() {
		mainMenuPanel = new MainMenuPanel(this);
		
		add(mainMenuPanel);
	}
	
	public void switchTo(JPanel panel) {
		if (currentPanel != null) currentPanel.setVisible(false);
		currentPanel = panel;
		panel.setVisible(true);
	}
}
