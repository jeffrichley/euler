package com.infinity.euler.num020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Answer23 {

private static final int NUM_TO_STOP = 28123;
	
	public static void main(String[] args) {
		Map<Integer, List<Integer>> factorsMap = new HashMap<>();
		int[] candidates = new int[NUM_TO_STOP+1];
		
		// get all the list of factors
		for (int i = 1; i < NUM_TO_STOP; i++) {
			int index = i+i;
			while (index <= NUM_TO_STOP) {
				List<Integer> factors = factorsMap.get(index);
				if (factors == null) {
					factors = new ArrayList<>();
					factorsMap.put(index, factors);
				}
				factors.add(i);
				index += i;
			}
		}

		for (int i = 1; i <= NUM_TO_STOP; i++) {
			List<Integer> factors = factorsMap.get(i);
			if (factors != null) {
				int value = 0;
				for (Integer val : factors) {
					value += val;
				}
				candidates[i] = value;
			}
		}
		
		// get all abundant numbers
		List<Integer> abundants = new ArrayList<>();
		for (int i = 1; i <= NUM_TO_STOP; i++) {
			if (i < candidates[i]) {
				abundants.add(i);
			}
		}
		
		// loop through and mark all the sums of abundants
		boolean[] checks = new boolean[NUM_TO_STOP];
		for (int i = 1; i < checks.length; i++) {
			checks[i] = true;
		}
		for (int i = 0; i < abundants.size(); i++) {
			for (int j = 0; j < abundants.size(); j++) {
				int one = abundants.get(i);
				int two = abundants.get(j);
				int index = one + two;
				if (index < checks.length) {
					checks[index] = false;
				}
			}
		}
		
		// loop through and get the sum
		long answer = 0;
		for (int i = 1; i < NUM_TO_STOP; i++) {
			if (checks[i]) {
				answer += i;
			}
		}
		
		System.out.println(answer);
	}
}
