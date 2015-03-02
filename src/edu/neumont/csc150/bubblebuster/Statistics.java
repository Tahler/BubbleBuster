package edu.neumont.csc150.bubblebuster;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Statistics implements Serializable {
	private static final long serialVersionUID = 4869437529924444269L;

	public static int walletCoins,
		totalPointsAllTime, totalCoinsAllTime, 
		survivalHighScore, survivalGamesPlayed, survivalLongestStreak,
		timeTrialHighScore, timeTrialGamesPlayed, timeTrialLongestStreak, timeTrialMostBubbles;
	public static Time totalPlaytime, survivalLongestTime;
	
	public static void save() throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("statistics")));
		out.writeObject(walletCoins);
		out.writeObject(totalPointsAllTime);
		out.writeObject(totalCoinsAllTime);
		out.writeObject(totalPlaytime);
		out.writeObject(survivalHighScore);
		out.writeObject(survivalGamesPlayed);
		out.writeObject(survivalLongestStreak);
		out.writeObject(survivalLongestTime);
		out.writeObject(timeTrialHighScore);
		out.writeObject(timeTrialGamesPlayed);
		out.writeObject(timeTrialLongestStreak);
		out.writeObject(timeTrialMostBubbles);
		out.close();
	}
	public static void load() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("statistics")));
		walletCoins = (int) in.readObject();
		totalPointsAllTime = (int) in.readObject();
		totalCoinsAllTime = (int) in.readObject();
		totalPlaytime = (Time) in.readObject();
		survivalHighScore = (int) in.readObject();
		survivalGamesPlayed = (int) in.readObject();
		survivalLongestStreak = (int) in.readObject();
		survivalLongestTime = (Time) in.readObject();
		timeTrialHighScore = (int) in.readObject();
		timeTrialGamesPlayed = (int) in.readObject();
		timeTrialLongestStreak = (int) in.readObject();
		timeTrialMostBubbles = (int) in.readObject();
		in.close();
	}
	
	public static String staticToString() {
		return  walletCoins + "\n" + 
				totalPointsAllTime + "\n" + totalCoinsAllTime + "\n" + totalPlaytime + "\n" + 
				survivalHighScore + "\n" + survivalGamesPlayed + "\n" + survivalLongestStreak + "\n" + survivalLongestTime + "\n" + 
				timeTrialHighScore + "\n" + timeTrialGamesPlayed + "\n" + timeTrialLongestStreak + "\n" + timeTrialMostBubbles;
	}
	
	public static void printAllFields() {
		System.out.println(walletCoins);
		System.out.println(totalPointsAllTime);
		System.out.println(totalCoinsAllTime);
		System.out.println(totalPlaytime);
		System.out.println(survivalHighScore);
		System.out.println(survivalGamesPlayed);
		System.out.println(survivalLongestStreak);
		System.out.println(survivalLongestTime);
		System.out.println(timeTrialHighScore);
		System.out.println(timeTrialGamesPlayed);
		System.out.println(timeTrialLongestStreak);
		System.out.println(timeTrialMostBubbles);
	}
}
