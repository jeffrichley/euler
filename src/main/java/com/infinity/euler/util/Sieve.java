package com.infinity.euler.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sieve {

	public static List<Integer> primesUnder(int underNum) {
		List<Integer> answer = new ArrayList<Integer>();
		
		for (int i = 2; i < underNum; i++) {
			answer.add(i);
		}
		
		for (int i = 2; i < underNum; i++) {
			Iterator<Integer> it = answer.iterator();
			while (it.hasNext()) {
				int val = it.next();
				if (i != val && val % i == 0) {
					it.remove();
				}
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		List<Integer> primes = primesUnder(21);
		
		for (Integer prime : primes) {
			System.out.println(prime);
		}
	}

}
