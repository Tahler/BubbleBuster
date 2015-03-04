package edu.neumont.csc150.bubblebuster;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MusicButton extends JButton {
	private final ImageIcon musicButtonImage = new ImageIcon("images/music.png");
	private final ImageIcon musicButtonImageX = new ImageIcon("images/musicx.png");
	
	public MusicButton() {
		super();

		addActionListener(e -> {
			if (getIcon().equals(musicButtonImage)) {
				Preferences.musicEnabled = false;
				setIcon(musicButtonImageX);
				Music.getInstance().stop();
			}
			else {
				Preferences.musicEnabled = true;
				setIcon(musicButtonImage);
				Music.getInstance().start();
			}
			Preferences.save();
		});
		
		if (Preferences.musicEnabled) setIcon(musicButtonImage);
		else setIcon(musicButtonImageX);
	}
}
