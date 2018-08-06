package com.infinity.euler.num020;

import com.infinity.euler.util.Prime;

public class Answer027 {

	public static void main(String[] args) {
		
		long product = 0;
		int longest = 0;
		
		for (int a = -999; Math.abs(a) < 1000; a++) {
			for (int b = -1000; Math.abs(b) <= 1000; b++) {
				
				int tmpLength = getLength(a, b);
				if (tmpLength > longest) {
					System.out.printf("Found a new one longer, %d %d with length %d\n", a, b, tmpLength);
					
					longest = tmpLength;
					product = a * b;
				}
				
			}
		}
		
		System.out.printf("The answer is: %d", product);
	}

	private static int getLength(int a, int b) {
		boolean prime = true;
		
		int count = 0;
		
		while (prime) {
			
			// n^2+an+b
			long n = count;
			long quadradic = (long) (Math.pow(n, 2) + (a * n) + b); 
			
			if (Prime.isPrime(quadradic)) {
				count++;
			} else {
				prime = false;
			}
		}
		
		return count;
	}

}
