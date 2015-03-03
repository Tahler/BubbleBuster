package edu.neumont.csc150.bubblebuster;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SoundButton extends JButton {
	private final ImageIcon effectsButtonImage = new ImageIcon("images/soundFX.png");
	private final ImageIcon effectsButtonImageX = new ImageIcon("images/soundFXx.png");
	
	public SoundButton() {
		super();
		
		addActionListener(e -> {
			if (getIcon().equals(effectsButtonImage)) {
				Preferences.soundEffectsEnabled = false;
				setIcon(effectsButtonImageX);
			}
			else {
				Preferences.soundEffectsEnabled = true;
				setIcon(effectsButtonImage);
			}
		});
		
		if (Preferences.soundEffectsEnabled) setIcon(effectsButtonImage);
		else setIcon(effectsButtonImageX);
	}
}