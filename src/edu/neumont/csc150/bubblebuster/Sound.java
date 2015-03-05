package edu.neumont.csc150.bubblebuster;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

// Singleton class design
public class Sound {
	protected Clip music;
	protected Clip[] popEffects;
	private static final int nSounds = new File(Preferences.skinFolderLocation + "/sounds").list().length;
	public static Sound instance = null;
	
	public static Sound getInstance() {
		if(instance == null) instance = new Sound();
		return instance;
	}
	
	private Sound() {
		System.out.println(nSounds + " files found in the skin folder");
		try {
			music = AudioSystem.getClip();
	        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(Preferences.ambianceFolderLocation + "/music.wav"));
	        music.open(inputStream);
	        
	        popEffects = new Clip[nSounds];
	        for (int i = 0; i < popEffects.length; i++) {
				popEffects[i] = AudioSystem.getClip();
				popEffects[i].open(AudioSystem.getAudioInputStream(new File(Preferences.skinFolderLocation + "/sounds/pop" + (i+1) + ".wav")));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void startMusic() {
		music.loop(Clip.LOOP_CONTINUOUSLY);
	}
	public void stopMusic() {
		music.stop();
	}
	
	public void playPop() {
		int i = new Random().nextInt(nSounds);
		popEffects[i].setMicrosecondPosition(0);
		popEffects[i].start();
	}
}
