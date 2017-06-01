package com.infinity.euler.num020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Answer021 {

	private static final int NUM_TO_STOP = 10000;
	
	public static void main(String[] args) {
		Map<Integer, List<Integer>> factorsMap = new HashMap<>();
		int[] candidates = new int[NUM_TO_STOP+1];
		
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
		
		Set<Integer> amicables = new HashSet<>();
		for (int a = 2; a <= NUM_TO_STOP; a++) {
			int dOfA = candidates[a];
			int b = dOfA;
			if (b < NUM_TO_STOP) {
				int dOfB = candidates[dOfA];
				
				if (a == dOfB && a != b) {
					amicables.add(a);
					amicables.add(b);
				}
			}
		}
		
		System.out.println("There are " + amicables.size()/2 + " amicable pairs");
		
		long answer = 0;
		for (Integer i : amicables) {
			answer += i;
		}
		
		System.out.println("The sum is " + answer);
	}

}
