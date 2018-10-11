package com.infinity.euler.num620;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author Jeffrey.Richley
 * 
 * Problem: https://projecteuler.net/problem=629
 *
 * https://discuss.codechef.com/questions/79515/grundy-number
 * http://goatleaps.xyz/euler/maths/Project-Euler-629.html
 * 
 */
public class Answer629 {

	public static final int NUM_ROCKS = 200;
	public static final int MAX_PILES = NUM_ROCKS;
	
	public static void main(String[] args) {
		
		// first we need to calculate the nimbers for each partition
		int[][] nimbers = getGrundyNimbers();
		
		// now that we have the nimbers, we can iterate through
		// all of the options and calculate if it would be winning or not
		long numWinners = calculateWinners(nimbers);
		
//		System.out.println();
		
//		printArray(nimbers);
	}

	private static int[][] getGrundyNimbers() {
		
		int[][] nimbers = new int[NUM_ROCKS+1][MAX_PILES+1];
		
		// calculate k = 2
		for (int i = 1; i <= NUM_ROCKS; i++) {
			nimbers[i][2] = (i+1) % 2;
		}

		// we now need where k = 3
		for (int n = 2; n <= MAX_PILES; n++) {
//			System.out.println("Processing " + n);
			
			Set<Integer> grundys = new HashSet<>();
			// look at k = 2
			for (int first = 1; first <= n / 2; first++) {
				int second = n - first;
				int grundy = nimbers[first][3] ^ nimbers[second][3];
				grundys.add(grundy);
//				System.out.println(first + " " + second + " : " + grundy);
			}
			
			// now add the k = 3
			if (n >= 3) {
				for (int first = 1; first <= n / 3; first++) {
					for (int second = first; second <= n - (first + second); second++) {
						int third = n - (first + second);
						
						int g1 = nimbers[first][3];
						int g2 = nimbers[second][3];
						int g3 = nimbers[third][3];
						
						int grundy = g1 ^ g2 ^ g3;
						grundys.add(grundy);
						
//						System.out.println(first + " " + second + " " + third + " : " + grundy);
					}
				}
			}
			
			int mex = findMex(grundys);
			nimbers[n][3] = mex;
			
//			System.out.println("Grundy for " + n + " is " + mex);
		}
		
		// calculate k >= 4
		for (int j = 4; j <= MAX_PILES; j++) {
			for (int i = 1; i <= NUM_ROCKS; i++) {
				nimbers[i][j] = i - 1;
			}
		}
		
		return nimbers;
	}

	private static int findMex(Set<Integer> grundys) {
		int mex = 0;
		
		while (grundys.contains(mex)) {
			mex++;
		}
		
		return mex;
	}

	private static long calculateWinners(int[][] nimbers) {
		
		// Let g(n) be the sum of f(n,k) over all 2 ≤ k ≤ n.
		long g = 0;
		int n = NUM_ROCKS;
		
		for (int numPiles = 1; numPiles <= MAX_PILES; numPiles++) {
			System.out.println(numPiles + " piles");

			// create the piles
			int[] piles = new int[numPiles];
			
			// initialize it with all ones to start
			Arrays.fill(piles, 1);

			boolean stillGood = true;
			while (stillGood) {
				// set up the first one
				int bigone = n - IntStream.of(piles).sum();
				
				if (bigone == 0 && numPiles != MAX_PILES) {
					break;
				}
				
				piles[piles.length-1] += bigone;

				printArray(piles);
				
				if (piles.length > 1) {
					// work through the last two
					while (piles[piles.length-1] - 1 >= piles[piles.length-2] + 1) {
						piles[piles.length-1]--;
						piles[piles.length-2]++;
						printArray(piles);
					}
					
				}

				if (piles.length > 2) {
					for (int i = piles.length - 2; i >= 1; ) {
						if (piles[i] - 1 >= piles[i-1] + 1) {
							piles[i]--;
							piles[i-1]++;
							piles[piles.length-1] = 1;
							break;
						}
						
						if (piles[piles.length-1] > piles[piles.length-2]) {
							int target = piles[piles.length-1] - 1;

							for (int j = piles.length-2; j >= 0; j--) {
								if (piles[j] < target) {
									piles[j]++;
									piles[piles.length-1] = 1;
									break;
								}
							}
							
							break;
						}

						stillGood = false;
						break;
					}
				} else {
					stillGood = false;
				}
			}
		}
		
		return g;
	}

	private static void printArray(int[][] array) {
		int length = array.length;
		for (int i = 0; i < length; i++) {
			printArray(array[i]);
			System.out.println();
		}
	}

	private static void printArray(int[] array) {
		int length = array.length-1;
		for (int i = 0; i < length; i++) {
			System.out.print(array[i] + ",");
		}
		System.out.println(array[length]);
	}
	
}
