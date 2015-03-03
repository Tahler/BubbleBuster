package edu.neumont.csc150.bubblebuster;

import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	public static int WIDTH;
	public static int HEIGHT;
	
	protected JPanel mainMenuPanel, gamePanel, statisticsPanel;
	private JPanel currentPanel;
	
	public GUI() {
		this("");
	}
	public GUI(String title) {
		super(title);
		
		WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
		HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		initializePanels();
		initializeFrame();
		currentPanel = mainMenuPanel;
		switchTo(mainMenuPanel);
	}
	
	private void initializeFrame() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
	}
	private void initializePanels() {
		mainMenuPanel = new MainMenuPanel(this);
//		survivalPanel = new SurvivalMode(this);
		
//		add(survivalPanel);
		//add(mainMenuPanel);
		this.getContentPane().add(mainMenuPanel);
	}
	
	public void switchTo(JPanel panel) {
		System.out.println("in switchTo");
		if (currentPanel != null) {
			this.getContentPane().remove(currentPanel);
		}
		currentPanel = panel;
		this.getContentPane().add(currentPanel);
		//currentPanel.setVisible(true);
		//setContentPane(currentPanel);
	}
}
