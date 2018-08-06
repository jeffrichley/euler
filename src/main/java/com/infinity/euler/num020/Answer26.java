package com.infinity.euler.num020;

import java.util.ArrayList;
import java.util.List;

import com.infinity.euler.util.Sieve;

public class Answer26 {

	public static void main(String[] args) {

		// only need to look at primes under 1000
		List<Integer> primes = Sieve.primesUnder(1000);
		
		int longest = 0;
		int length = 0;
		
		for (Integer prime : primes) {
			// has to be co-prime with 10 so don't worry abut under 5
			if (prime > 5) {
				int tmpLength = getLength(1, new ArrayList<Integer>(), prime);
				if (tmpLength > length) {
					length = tmpLength;
					longest = prime;
				}
			}
			
		}
		
		System.out.printf("Complete: %d has a length of %d", longest, length);

	}

	private static int getLength(int init, List<Integer> rems, int d) {
		int rem = divBy(init, d);
		
		if (rems.contains(rem)) {
			return rems.size() - rems.indexOf(rem);
		} else {
			rems.add(rem);
			return getLength(rem, rems, d);
		}
	}

	private static int divBy(int rem, int div) {
		int y = Integer.MAX_VALUE;
		
		for (int x = 0; x < 5; x++) {
			if (rem * (Math.pow(10, x)) > div) {
				y = Math.min(x, y);
			}
		}
		
		return  rem * ((int) Math.pow(10, y)) % div;
	}

}
