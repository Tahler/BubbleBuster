package edu.neumont.csc150.bubblebuster;

import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
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
		initializeCursor();
		switchTo(new MainMenuPanel(this));
		if (Preferences.musicEnabled) Sound.getInstance().startMusic();
	}
	private void initializeFrame() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
	}
	private void initializeCursor() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("resources/cursor.gif");
		Cursor cursor = kit.createCustomCursor(img, new Point(0, 0), "Hand");
		setCursor(cursor);
	}
	
	public void switchTo(JPanel panel) {
		if (currentPanel != null) this.getContentPane().remove(currentPanel);
		currentPanel = panel;
		this.getContentPane().add(currentPanel);
		setVisible(true);
	}
}
