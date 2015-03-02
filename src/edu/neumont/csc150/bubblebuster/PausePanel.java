package edu.neumont.csc150.bubblebuster;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PausePanel extends JPanel {

	private JButton resumeButton, menuButton, 
		musicButton, effectsButton;
	private JPanel panel1, panel2;
	private final JLabel title = new JLabel("Paused");
	
	public PausePanel() {
		initializeButtons();
		addComponents();
		setVisible(true);
	}
	
	private void initializeButtons() {
		resumeButton = new BubbleButton("Resume") ;
		menuButton = new BubbleButton("Main Menu") ;
		musicButton = new BubbleButton("m") ;
		effectsButton = new BubbleButton("s") ;
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
		panel1.add(menuButton, c);
		
		c.insets = new Insets(10, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 3;
		panel1.add(resumeButton, c);
		
		panel2 = new JPanel();
		panel2.add(musicButton);
		panel2.add(effectsButton);
		
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
	}
	
}