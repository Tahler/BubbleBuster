package edu.neumont.csc150.bubblebuster;

import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUI extends JFrame implements MouseListener {
	public static int WIDTH;
	public static int HEIGHT;
	
	protected JPanel gamePanel;
	private JPanel currentPanel;
	
	private Cursor cursor, cursorPressed;
	
	private static GUI instance = null;
	public static GUI getInstance() {
		if (instance == null) {
			System.out.println("null");
			instance = new GUI();
		}
		return instance;
	}
	
	private GUI() {
		super("Bubble Buster");
		WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
		HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
		initializeFrame();
		initializeCursor();
		addMouseListener(this);
		switchTo(new MainMenuPanel());
		if (Preferences.musicEnabled) Sound.getInstance().startMusic();
	}
	private void initializeFrame() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
	}
	private void initializeCursor() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		cursor = kit.createCustomCursor(kit.getImage("resources/cursor.gif"), new Point(4, 4), "Hand");
		cursorPressed = kit.createCustomCursor(kit.getImage("resources/cursorPressed.gif"), new Point(4, 4), "Hand");
		setCursor(cursor);
	}
	
	public void switchTo(JPanel panel) {
		if (currentPanel != null) this.getContentPane().remove(currentPanel);
		currentPanel = panel;
		this.getContentPane().add(currentPanel);
		setVisible(true);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		setCursor(cursorPressed);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		setCursor(cursor);
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}
