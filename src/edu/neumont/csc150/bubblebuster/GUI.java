package edu.neumont.csc150.bubblebuster;

import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {
	public static int WIDTH;
	public static int HEIGHT;
	
	protected JPanel mainMenuPanel, survivalPanel;
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
		setExtendedState(Frame.MAXIMIZED_BOTH);
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
	}
	private void initializePanels() {
		mainMenuPanel = new MainMenuPanel(this);
		survivalPanel = new SurvivalPanel(this);
		
		add(survivalPanel);
		add(mainMenuPanel);
	}
	
	public void switchTo(JPanel panel) {
		if (currentPanel != null) currentPanel.setVisible(false);
		currentPanel = panel;
		panel.setVisible(true);
	}
}
