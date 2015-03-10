package edu.neumont.csc150.bubblebuster;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PausePanel extends JPanel {
	private BubbleButton resumeButton, menuButton;
	private JPanel panel1, panel2;
	private final JLabel title;
	private MusicButton musicButton;
	private SoundButton	effectsButton;
	private Image background;
	
	public PausePanel(Image background) {
		title = new JLabel(new ImageIcon("resources/pause.png"), JLabel.CENTER);
		initializeButtons();
		addComponents();
		
		this.background = background;
		
		addKeyListener(new KeyListener() {
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					resume();
				}
			}
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {}
		});
		
		setVisible(true);
	}
	private void initializeButtons() {
		resumeButton = new BubbleButton("Resume");
		menuButton = new BubbleButton("Main Menu");
		musicButton = new MusicButton();
		effectsButton = new SoundButton();

		resumeButton.addActionListener(e -> {
			resume();
		});
		menuButton.addActionListener(e -> {
			GUI.getInstance().switchTo(new MainMenuPanel());
		});
	}
	private void addComponents() {
		setLayout(new BorderLayout());
		
		panel1 = new JPanel(new GridBagLayout());
		panel1.setOpaque(false);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.CENTER;
		
		title.setFont(new Font("SansSerif", Font.BOLD, 64));
		c.gridx = 0;
		c.gridy = 0;
		panel1.add(title, c);
		
		c.insets = new Insets(40, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 2;
		panel1.add(resumeButton, c);
		
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		panel1.add(menuButton, c);
		
		panel2 = new JPanel();
		panel2.setOpaque(false);
		
		panel2.add(musicButton);
		panel2.add(effectsButton);
		
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
	}
	
	public void resume() {
		((BubbleBuster) GUI.getInstance().gamePanel).togglePause();
		GUI.getInstance().switchTo(GUI.getInstance().gamePanel);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
		requestFocusInWindow();
	}
}