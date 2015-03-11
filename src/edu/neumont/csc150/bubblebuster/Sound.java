package edu.neumont.csc150.bubblebuster;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;

// Singleton class design
public class Sound {
	protected BooleanControl muteControl;
	protected Clip menuMusic;
	protected Clip gameMusic;
	protected Clip[] popEffects;
	private int nSounds;
	
	private static Sound instance = null;
	public static Sound getInstance() {
		if (instance == null) instance = new Sound();
		return instance;
	}
	
	private Sound() {
		try {
			menuMusic = AudioSystem.getClip();
			gameMusic = AudioSystem.getClip();
		}
		catch (Exception e) {e.printStackTrace();}
	}
	
	public void toggleMute() {
		muteControl.setValue(!muteControl.getValue());
	}
	
	public void startMenuMusic() {
		gameMusic.stop();
		
		if (!menuMusic.isRunning()) {
			try {
				menuMusic = AudioSystem.getClip();
			
				AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("resources/bubblebuster.wav"));
		        menuMusic.open(inputStream);
				
				muteControl = (BooleanControl) menuMusic.getControl(BooleanControl.Type.MUTE);
			    if (Preferences.musicEnabled) muteControl.setValue(false);
			    else muteControl.setValue(true);
			    
			    menuMusic.loop(Clip.LOOP_CONTINUOUSLY);
			} 
			catch (Exception e) {e.printStackTrace();}
		}
	}
	public void stopMenuMusic() {
		menuMusic.stop();
	}
	
	public void startGameMusic() {
		if (!gameMusic.isRunning()) {
			try {
				stopMenuMusic();
				stopGameMusic();
				
				gameMusic = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(Preferences.ambianceFolderLocation + "/music.wav"));
		        gameMusic.open(inputStream);
		        
		        muteControl = (BooleanControl) gameMusic.getControl(BooleanControl.Type.MUTE);
			    if (Preferences.musicEnabled) muteControl.setValue(false);
			    else muteControl.setValue(true);
		        
		        // Also reset the pop sounds
		        nSounds = 0;
		        for (String file : new File(Preferences.skinFolderLocation).list()) {
		        	if (file.contains(".wav")) nSounds++;
				}
		        
		        popEffects = new Clip[nSounds];
		        for (int i = 0; i < popEffects.length; i++) {
					popEffects[i] = AudioSystem.getClip();
					popEffects[i].open(AudioSystem.getAudioInputStream(new File(Preferences.skinFolderLocation + "/pop" + (i+1) + ".wav")));
				}
		        
		        gameMusic.loop(Clip.LOOP_CONTINUOUSLY);
			}
			catch (Exception e) {e.printStackTrace();}
		}
	}
	public void stopGameMusic() {
		try {
			gameMusic.stop();
		}
		catch (Exception e) {}
	}
	
	public void playPop() {
		int i = new Random().nextInt(nSounds);
		popEffects[i].setMicrosecondPosition(0);
		popEffects[i].start();
	}
}
