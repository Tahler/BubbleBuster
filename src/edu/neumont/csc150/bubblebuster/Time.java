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
		return (((milliseconds / 60000) % 60 < 10) ? "0" + ((milliseconds / 60000) % 60) : "" + (milliseconds / 60000) % 60)
				+ ":" + (((milliseconds / 1000) % 60 < 10) ? "0" + ((milliseconds / 1000) % 60) : "" + ((milliseconds / 1000) % 60))
				+ "." + milliseconds % 10;
	}
	
	public static String format(long milliseconds) {
		return (((milliseconds / 60000) % 60 < 10) ? "0" + ((milliseconds / 60000) % 60) : "" + (milliseconds / 60000) % 60)
				+ ":" + (((milliseconds / 1000) % 60 < 10) ? "0" + ((milliseconds / 1000) % 60) : "" + ((milliseconds / 1000) % 60))
				+ "." + milliseconds % 10;
	}
	
	@Override
	public int compareTo(Time o) {
		return Double.compare(milliseconds, o.milliseconds);
	}
}
