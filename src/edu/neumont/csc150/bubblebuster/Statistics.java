package edu.neumont.csc150.bubblebuster;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Statistics implements Serializable {
	private static final long serialVersionUID = 4869437529924444269L;

	public static int walletCoins,
		totalPointsAllTime, totalCoinsAllTime, 
		survivalHighScore, survivalGamesPlayed,
		timeTrialHighScore, timeTrialGamesPlayed, timeTrialMostBubbles;
	public static Time totalPlaytime, survivalLongestTime;
	
	public static void save() throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("statistics")));
		out.writeObject(walletCoins);
		out.writeObject(totalPointsAllTime);
		out.writeObject(totalCoinsAllTime);
		out.writeObject(totalPlaytime);
		if (totalPlaytime == null) totalPlaytime = new Time(0);
		out.writeObject(survivalHighScore);
		out.writeObject(survivalGamesPlayed);
		if (survivalLongestTime == null) survivalLongestTime = new Time(0);
		out.writeObject(survivalLongestTime);
		out.writeObject(timeTrialHighScore);
		out.writeObject(timeTrialGamesPlayed);
		out.writeObject(timeTrialMostBubbles);
		out.close();
	}
	/**
	 * Tries to load a currently existing statistics file.  If no such file exists, the file will be created with defaults.
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void load() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("statistics")));
			walletCoins = (int) in.readObject();
			totalPointsAllTime = (int) in.readObject();
			totalCoinsAllTime = (int) in.readObject();
			totalPlaytime = (Time) in.readObject();
			survivalHighScore = (int) in.readObject();
			survivalGamesPlayed = (int) in.readObject();
			survivalLongestTime = (Time) in.readObject();
			timeTrialHighScore = (int) in.readObject();
			timeTrialGamesPlayed = (int) in.readObject();
			timeTrialMostBubbles = (int) in.readObject();
			in.close();
		}
		catch (Exception e) {
			try {
				Statistics.save();
			}
			catch (IOException e1) {
				// Should never really be reached.
				e1.printStackTrace();
			}
		}
	}
	
	public static String staticToString() {
		return  walletCoins + "\n" + 
				totalPointsAllTime + "\n" + totalCoinsAllTime + "\n" + totalPlaytime + "\n" + 
				survivalHighScore + "\n" + survivalGamesPlayed + "\n" + survivalLongestTime + "\n" + 
				timeTrialHighScore + "\n" + timeTrialGamesPlayed + "\n" + timeTrialMostBubbles;
	}
	
	public static void printAllFields() {
		System.out.println(walletCoins);
		System.out.println(totalPointsAllTime);
		System.out.println(totalCoinsAllTime);
		System.out.println(totalPlaytime);
		System.out.println(survivalHighScore);
		System.out.println(survivalGamesPlayed);
		System.out.println(survivalLongestTime);
		System.out.println(timeTrialHighScore);
		System.out.println(timeTrialGamesPlayed);
		System.out.println(timeTrialMostBubbles);
	}
}
