package com.infinity.euler.num620;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Answer629 {
	
	private static int n = 6;
	private static int k = 6;
	

//	public static void main(String[] args) {
//		
//		// winning position f(5,2)=3
////		System.out.println(isWinning(1,1,1,2));
////		System.out.println(isWinning(1,1,3));
////		System.out.println(isWinning(1,4));
////		System.out.println(isWinning(2,3));
//		
//		// winning position f(5,3)=5
////		System.out.println(isWinning(1,1,1,2));
////		System.out.println(isWinning(1,1,3));
////		System.out.println(isWinning(1,4));
////		System.out.println(isWinning(2,3));
////		System.out.println(isWinning(5));
//		
//		// get all the combinations for starting piles
//		new Answer629().run();
//		
//	}
	
	public static void main(String[] args) {
		new Answer629().run();
	}
	

	private void run() {
		
		List<int[]> staring = getStartingCombos(n, k);
	}

	private ArrayList<int[]> getStartingCombos(int numRocks, int maxPiles) {
		ArrayList<int[]> potential = new ArrayList<int[]>();
		

		// initialize the dynamic programming table
		Cell[][] table = new Cell[numRocks+1][maxPiles+1];
		for (int i = 0; i < numRocks+1; i++) {
			for (int j = 0; j < maxPiles+1; j++) {
				table[i][j] = new Cell();
			}
		}
		
		// set up the base cases in number of rocks 2
		for (int tmpRocks = 2; tmpRocks <= numRocks; tmpRocks++) {
			int i = 1;
			int j = tmpRocks - i;
			while (i <= j) {
				table[tmpRocks][2].addOption(new int[] {i,j});
				
				i++;
				j = tmpRocks - i;
			}
		}
		
		// set up the base cases for the diagonal
		for (int i = 3; i <= numRocks && i <= maxPiles; i++) {
			int[] option = new int[i];
			Arrays.fill(option, 1);
			table[i][i].addOption(option);
		}
		
		
		
		for (int rocks = 3; rocks <= numRocks; rocks++) {
			for (int piles = 3; piles < rocks; piles++) {
				int maxPilePieces = rocks - piles + 1;
				System.out.println(rocks + " " + piles + " " + maxPilePieces);
				
				List<int[]> possible = new ArrayList<>();
				int pileLookup = piles - 1;
				for (int tmp = maxPilePieces; tmp > 1; tmp--) {
					int rockLookup = rocks - tmp;
					Cell lookup = table[rockLookup][pileLookup];
					System.out.print("\t");
					for (int[] lookupOption : lookup.getOptions()) {
						for (int t : lookupOption) {
							System.out.print(t+",");
						}
						System.out.println(tmp);
					}
				}
			}
		}
		
//		for (int rocks = 3; rocks <= numRocks; rocks++) {
//			for (int piles = 2; piles <= maxPiles; piles++) {
//				int largestPile = rocks - (piles-1);
//				for (int nextPile = 1; nextPile <= largestPile; nextPile++) {
//					System.out.println(rocks + " rocks " + piles + " piles " + nextPile);
//					Cell lastCell = table[rocks-nextPile][piles-1];
//					List<int[]> options = lastCell.getOptions();
//					if (!options.isEmpty()) {
//						for (int[] option : options) {
//							for (int t = 0; t < option.length; t++) {
//								System.out.print(t + ",");
//							}
//						}
//						System.out.println(nextPile);
//					}
//				}
//			}
//		}
		
		
		return potential;
	}

	private static boolean isWinning(int ...nums) {
		
		if (nums.length == 1) {
			return nums[0] != 0;
		} else {
			int tmp = 0;
			
			for (int i = 0; i < nums.length; i++) {
				tmp ^= nums[i];
			}
			
			return tmp != 0;
		}
		
	}

	public class Cell {
		
		private List<int[]> options = new ArrayList<>();

		public List<int[]> getOptions() {
			return options;
		}

		public void addOption(int[] option) {
			options.add(option);
		}
		
	}
}
