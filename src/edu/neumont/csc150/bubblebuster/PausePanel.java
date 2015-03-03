package edu.neumont.csc150.bubblebuster;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PausePanel extends JPanel {
	private GUI frame;
	private JButton resumeButton, menuButton;
	private JPanel panel1, panel2;
	private final JLabel title = new JLabel("Paused");
	private JButton	musicButton, effectsButton;
	private final ImageIcon musicButtonImage = new ImageIcon("images/music.png");
	private final ImageIcon musicButtonImageX = new ImageIcon("images/musicx.png");
	private final ImageIcon effectsButtonImage = new ImageIcon("images/soundFX.png");
	private final ImageIcon effectsButtonImageX = new ImageIcon("images/soundFXx.png");
	
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
		musicButton = new JButton(musicButtonImage);
		effectsButton = new JButton(effectsButtonImage);

		resumeButton.addActionListener(e -> {
			System.out.println("clicked resume");
			((BubbleBuster) frame.survivalPanel).togglePause();
			frame.switchTo(frame.survivalPanel);
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
		musicButton.addActionListener(e -> {
			if (musicButton.getIcon().equals(musicButtonImage)) musicButton.setIcon(musicButtonImageX);
			else musicButton.setIcon(musicButtonImage);
		});
		effectsButton.addActionListener(e -> {
			if (effectsButton.getIcon().equals(effectsButtonImage)) effectsButton.setIcon(effectsButtonImageX);
			else effectsButton.setIcon(effectsButtonImage);
		});
	}
	private void addComponents() {
		setLayout(new BorderLayout());
		
		panel1 = new JPanel(new GridBagLayout());
		panel1.setBackground(new Color(0, 195, 217));
		
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
		panel2.setBackground(new Color(0, 195, 217));
		
		panel2.add(musicButton);
		panel2.add(effectsButton);
		
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
	}
	
}