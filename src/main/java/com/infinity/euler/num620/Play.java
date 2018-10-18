package com.infinity.euler.num620;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Play {

	int numRocks = 10;
	int maxPiles = numRocks;

	public static void main(String[] args) {
		
//		new Play().generatePermutations();
		
		new Play().generatePerms();
		
	}

	private void generatePerms() {
		
		for (int numPiles = 1; numPiles <= maxPiles; numPiles++) {
			int[] piles = new int[numPiles];

			// degenerate case with all 1's and a final number
			Arrays.fill(piles, 1);
			piles[piles.length-1] += numRocks - IntStream.of(piles).sum();
			
			printArray(piles);

			getNextPerm(piles, 0);
			
		}
	}

	private void getNextPerm(int[] originalPiles, int updateIndex) {
		
		if (updateIndex == originalPiles.length-1) {
			return;
		}
		
		int[] piles = Arrays.copyOf(originalPiles, originalPiles.length);
		
		while (updateIndex+1 < piles.length && piles[updateIndex] < piles[piles.length-1] -1) {
			
			getNextPerm(piles, updateIndex+1);
			
			piles[updateIndex]++;
			int updatedValue = piles[updateIndex];
			for (int i = updateIndex+1; i < piles.length; i++) {
				piles[i] = updatedValue;
			}
			
			piles[piles.length-1] = 0;
			int sum = numRocks - IntStream.of(piles).sum();
			if (sum >= 0 && sum >= piles[piles.length-2]) {
				piles[piles.length-1] = sum;
				printArray(piles);
			}
			
		}
		
	}


	private void printArray(int[] array) {
		int length = array.length-1;
		for (int i = 0; i < length; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println(array[length]);
	}
}
