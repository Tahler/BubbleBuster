package edu.neumont.csc150.bubblebuster;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

// Singleton class design
public class Music {
	protected Clip music;
	public static Music instance = null;
	
	public static Music getInstance() {
		if(instance == null) instance = new Music();
		return instance;
	}
	
	private Music() {
		try {
			music = AudioSystem.getClip();
	        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(Preferences.ambianceFolderLocation + "/music.wav"));
	        music.open(inputStream);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void start() {
		music.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		music.stop();
	}
}
