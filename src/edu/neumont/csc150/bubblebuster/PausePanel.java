package edu.neumont.csc150.bubblebuster;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PausePanel extends JPanel {
	private GUI frame;
	private JButton resumeButton, menuButton, 
		musicButton, effectsButton;
	private JPanel panel1, panel2;
	private final JLabel title = new JLabel("Paused");
	
	public PausePanel(GUI frame) {
		this.frame = frame;
		initializeButtons();
		addComponents();
		addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				System.out.println("mouse");
			}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				System.out.println("click");
				requestFocusInWindow();
			}
		});
		setVisible(true);
	}
	
	private void initializeButtons() {
		resumeButton = new BubbleButton("Resume");
		menuButton = new BubbleButton("Main Menu");
		musicButton = new BubbleButton("m");
		effectsButton = new BubbleButton("s");
		
		resumeButton.addActionListener(e -> {
			System.out.println("clicked resume");
			((BubbleBuster) frame.gamePanel).togglePause();
			frame.switchTo(frame.gamePanel);
		});
		resumeButton.addKeyListener(new KeyListener() {
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.out.println("key");
					resumeButton.doClick();
				}
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		menuButton.addActionListener(e -> {
			frame.switchTo(frame.mainMenuPanel);
		});
	}
	private void addComponents() {
		setLayout(new BorderLayout());
		
		panel1 = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.CENTER;
		
		title.setFont(new Font("SansSerif", Font.BOLD, 30));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		panel1.add(title, c);
		
		c.insets = new Insets(40, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel1.add(resumeButton, c);
		
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		panel1.add(menuButton, c);
		
		panel2 = new JPanel();
		panel2.add(musicButton);
		panel2.add(effectsButton);
		
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
	}
	
}