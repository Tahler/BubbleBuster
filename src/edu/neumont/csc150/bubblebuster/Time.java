package edu.neumont.csc150.bubblebuster;

import java.io.Serializable;

public class Time implements Comparable<Time>, Serializable {
	private static final long serialVersionUID = -4849158459742175670L;
	
	private long milliseconds;
	
	public Time() {
		milliseconds = System.currentTimeMillis();
	}
	public Time(long milliseconds) {
		this.milliseconds = milliseconds;
	}
	
	public void addTime(long milliseconds) {
		this.milliseconds += milliseconds;
	}
	public void addTime(Time time) {
		this.milliseconds += time.milliseconds;
	}
	
	public long getMilliseconds() {
		return milliseconds;
	}
	
	public String toString() {
		long minutes = (milliseconds / 60000) % 60;
		long seconds = (milliseconds / 1000) % 60;
		long tenths = milliseconds % 10;
		
		return ((minutes < 10) ? "0" : "") + minutes
				+ ":" + ((seconds < 10) ? "0" : "") + seconds
				+ "." + tenths;
	}
	
	public static String format(long milliseconds) {
		long minutes = (milliseconds / 60000) % 60;
		long seconds = (milliseconds / 1000) % 60;
		long tenths = milliseconds % 10;
		
		return ((minutes < 10) ? "0" : "") + minutes
				+ ":" + ((seconds < 10) ? "0" : "") + seconds
				+ "." + tenths;
	}
	
	@Override
	public int compareTo(Time o) {
		return Double.compare(milliseconds, o.milliseconds);
	}
}
