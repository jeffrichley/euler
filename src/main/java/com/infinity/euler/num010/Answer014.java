package com.infinity.euler.num010;

import java.util.HashMap;
import java.util.Map;

public class Answer014 {

	private final int UNDER_NUMBER = 1000000;
	private final Map<Long, Long> precomputed = new HashMap<>(); 
	
	private void run() {
		
		long longest = 0;
		long longestStart = 0;
		
		for (int current = 13; current < UNDER_NUMBER; current++) {
			long chainLength = findChainLength(current);
			
			if (chainLength > longest) {
				longest = chainLength;
				longestStart = current;
			}
		}
		
		System.out.println("answer = " + longest + " starts with " + longestStart);
		System.out.println(precomputed.size() + " precomputations");
	}

	private long findChainLength(long current) {
		// need to stop if it is 1
		if (current == 1) {
			return 1;
		}

		// check to see if we have computed this before
		Long precomputedLength = precomputed.get(current);
		if (precomputedLength != null){
			return precomputedLength;
		}
		
		// since we haven't computed this yet, grunt it out
		long length = 0;
		long next = 1;
		if (current % 2 == 0) {
			next = current / 2;
		} else {
			next = current * 3 + 1;
		}
		
		length = 1 + findChainLength(next);
		
		precomputed.put(current, length);
		
		return length;
	}

	public static void main(String[] args) {
		new Answer014().run();
	}
	
}
