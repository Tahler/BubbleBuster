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
		this("");
	}
	public GUI(String title) {
		super(title);
		WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
		HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
		initializeFrame();
		switchTo(new MainMenuPanel(this));
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
