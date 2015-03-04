package edu.neumont.csc150.bubblebuster;

import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	public static int WIDTH;
	public static int HEIGHT;
	
	protected JPanel gamePanel;
	private JPanel currentPanel;
	
	public GUI() {
		super("Bubble Buster");
		WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
		HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
		initializeFrame();
		switchTo(new MainMenuPanel(this));	
		
		if (Preferences.musicEnabled) Music.getInstance().start();
	}
	
	private void initializeFrame() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
	}
	
	public void switchTo(JPanel panel) {
		if (currentPanel != null) this.getContentPane().remove(currentPanel);
		currentPanel = panel;
		this.getContentPane().add(currentPanel);
		setVisible(true);
	}
}
