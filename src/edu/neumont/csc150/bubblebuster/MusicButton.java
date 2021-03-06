package edu.neumont.csc150.bubblebuster;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MusicButton extends JButton {
	private final ImageIcon musicButtonImage = new ImageIcon("resources/music.png");
	private final ImageIcon musicButtonImageX = new ImageIcon("resources/musicx.png");
	
	public MusicButton() {
		super();
		
		setFocusable(false);

		addActionListener(e -> {
			if (getIcon().equals(musicButtonImage)) {
				Preferences.musicEnabled = false;
				setIcon(musicButtonImageX);
				Sound.getInstance().muteControl.setValue(true);
			}
			else {
				Preferences.musicEnabled = true;
				setIcon(musicButtonImage);
				Sound.getInstance().muteControl.setValue(false);
			}
			Preferences.save();
		});
		
		if (Preferences.musicEnabled) setIcon(musicButtonImage);
		else setIcon(musicButtonImageX);
	}
}
