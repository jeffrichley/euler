package com.infinity.euler.num030;

public class Answer31 {

	public static void main(String[] args) {
		
		// 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
		
		int[] values = new int[] { 1, 2, 5, 10, 20, 50, 100, 200 };

		int targetValue = 200;
		
		// going to use dynamic programming, so we need a cache to reference
		int[] cache = new int[targetValue + 1];
		
		// bootstrap the system
		cache[0] = 1;
		
		// for each coin
		for (int i = 0; i < values.length; i++) {
			// look at every slot and add the number of times it can be combined
			for (int j = values[i]; j <= targetValue; j++) {
				cache[j] += cache[j - values[i]];
			}
		}
		
		System.out.printf("The number of combinations for %dp is %d", targetValue, cache[targetValue]);
	}
	
}
