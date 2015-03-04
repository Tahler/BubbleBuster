package edu.neumont.csc150.bubblebuster;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class SoundButton extends JButton {
	private final ImageIcon effectsButtonImage = new ImageIcon("images/soundFX.png");
	private final ImageIcon effectsButtonImageX = new ImageIcon("images/soundFXx.png");
	
	public SoundButton() {
		super();
		
		addActionListener(e -> {
			if (getIcon().equals(effectsButtonImage)) {
				Preferences.soundFXEnabled = false;
				setIcon(effectsButtonImageX);
			}
			else {
				Preferences.soundFXEnabled = true;
				setIcon(effectsButtonImage);
			}
			Preferences.save();
		});
		
		if (Preferences.soundFXEnabled) setIcon(effectsButtonImage);
		else setIcon(effectsButtonImageX);
	}
}