package com.infinity.euler.num010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Answer012 {

	private int numPrimesToCheck = 10000000;
	private int numFactorsToFind = 500;
	
	private List<Integer> primes = new ArrayList<>();

	private void run() {
		fillPrimes();
		
		long triangle = 0;
		int numFactors = 0;
		long count = 1;
		while (numFactors <= numFactorsToFind) {
			triangle += count++;
			
			int newNumFactors = findFactors(triangle);
			
			if (newNumFactors > numFactors) {
				numFactors = newNumFactors;
				System.out.println(count + " " + triangle + " " + numFactors);
			}
		}
		
		System.out.println(count + " " + triangle + " " + numFactors);
	}

	private int findFactors(long triangle) {
		List<Integer> primeDivisors = new ArrayList<>();
		
		for (Integer prime : primes) {
			if (prime > triangle/2) {
				break;
			}
			
			// if triangle is divisible by this prime number
			if (triangle % prime == 0) {
				// save the prime divisor
				primeDivisors.add(prime);
			}
		}
		
//		for (int i = 2; i < triangle/2; i++) {
//			// if this is a prime number
//			if (candidates[i] == 1) {
//				// and it is divisible by the prime number
//				if (triangle % i == 0) {
//					// save the prime divisor
//					primeDivisors.add(i);
//				}
//			}
//		}
		
		Collections.reverse(primeDivisors);
		
		int numDivisors = 1;
		long currentNumber = triangle;
		
		for (Integer prime : primeDivisors) {
			int num = 1;
			while (currentNumber % prime == 0) {
				num++;
				currentNumber /= prime;
			}
			numDivisors *= num;
		}
		
		
		return numDivisors;
	}

	private void fillPrimes() {
		int[] candidates = new int[numPrimesToCheck];
		for (int i = 2; i < candidates.length/2; i++) {
			int index = i;
			while (index < candidates.length) {
				candidates[index] += 1;
				index += i;
			}
		}
		
		for (int i = 2; i < candidates.length; i++) {
			if (candidates[i] == 1) {
				primes.add(i);
			}
		}
	}

	public static void main(String[] args) {
		
		new Answer012().run();
		
	}

}
