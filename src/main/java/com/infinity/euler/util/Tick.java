package com.infinity.euler.util;

public class Tick {

	private long last = System.currentTimeMillis();
	private long start = last;
	
	public void tick(String msg) {
		long now = System.currentTimeMillis();
		
		System.out.printf("%s: %d %d%n", msg, now - last, now - start);
		
		last = now;
	}
	
}
