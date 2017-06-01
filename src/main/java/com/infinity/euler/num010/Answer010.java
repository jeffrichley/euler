package com.infinity.euler.num010;

public class Answer010 {

	public static void main(String[] args) {
		int below = 2000000;
		int length = 2000000;

		int sqrt = (int) Math.sqrt(length);
		boolean[] marked = new boolean[length];


		for (int i = 2; i < sqrt; i++) {
			// first see if this one has been marked, if not, it is prime
			if (!marked[i]) {
				// now mark off multiples of this number
				int markIt = i * i;
				while (markIt < length) {
					marked[markIt] = true;
					markIt += i;
				}
			}
		}

		long answer = 0;
		
		for (int i = 2; i < below; i++) {
			if (!marked[i]) {
				answer += i;
			}
		}
		
		System.out.println("The values of all primes below " + below + " added together is " + answer);
	}

}
