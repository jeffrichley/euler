package com.infinity.euler.num620;

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

	public static final int NUM_ROCKS = 8;
	public static final int MAX_PILES = NUM_ROCKS;
	
	public static void main(String[] args) {
		
		// first we need to calculate the nimbers for each partition
		int[][] nimbers = getGrundyNimbers();
		
		// now that we have the nimbers, we can iterate through
		// all of the options and calculate if it would be winning or not
		long numWinners = calculateWinners(nimbers);
		
//		printArray(nimbers);
	}

	private static int[][] getGrundyNimbers() {
		
		int[][] nimbers = new int[NUM_ROCKS+1][MAX_PILES+1];
		
		// calculate k = 2
		for (int i = 1; i < NUM_ROCKS; i++) {
			nimbers[i][2] = (i+1) % 2;
		}

		// we now need where k = 3
		for (int n = 2; n <= MAX_PILES; n++) {
			System.out.println("Processing " + n);
			for (int first = 1; first <= n / 2; first++) {
				int second = n - first;
				int grundy = nimbers[first][3] ^ nimbers[second][3];
				System.out.println(first + " " + second + " = " + grundy);
			}
		}
		
		// calculate k >= 4
		for (int j = 4; j <= MAX_PILES; j++) {
			for (int i = 1; i < NUM_ROCKS; i++) {
				nimbers[i][j] = i - 1;
			}
		}
		
		return nimbers;
	}

	private static long calculateWinners(int[][] nimbers) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static void printArray(int[][] array) {
		int length = array.length-1;
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
