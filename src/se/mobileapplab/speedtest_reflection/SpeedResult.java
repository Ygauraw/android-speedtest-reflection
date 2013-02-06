package se.mobileapplab.speedtest_reflection;

import java.lang.ref.WeakReference;

public class SpeedResult {
	String name;
	long time;
	boolean didGC;
	
	private WeakReference<Object> check;
	
	SpeedResult(String name) {
		this.name = name;
		didGC = false;
		time = System.currentTimeMillis();
		check = new WeakReference<Object>(new Object());
	}
	
	void end() {
		time = System.currentTimeMillis() - time;
		didGC = check.get()==null;
	}
}
