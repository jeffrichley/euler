package com.infinity.euler.num010;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Answer011 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		long[][] grid = new long[20][20];
		
		try (LineNumberReader in = new LineNumberReader(new FileReader("./data/data-011.txt"))) {
			String line = null;
			int lineCount = 0;
			while ((line = in.readLine()) != null) {
				String[] parts = line.split(" ");
				long[] lineNums = grid[lineCount++];
				for (int i = 0; i < parts.length; i++) {
					lineNums[i] = Long.parseLong(parts[i]);
				}
			}
		}
		
		long largestValue = 0;
		
		// to the right
		for (int row = 0; row < 20; row++) {
			for (int column = 0; column < 20; column++) {
				long val = grid[row][column];
				if (column < 19) {
					val *= grid[row][column+1];
					if (column < 18) {
						val *= grid[row][column+2];
						if (column < 17) {
							val *= grid[row][column+3];
						}
					}
				}
				if (val > largestValue) {
					largestValue = val;
				}
			}
		}
		System.out.println(largestValue);
		
		// down
		for (int row = 0; row < 20; row++) {
			for (int column = 0; column < 20; column++) {
				long val = grid[row][column];
				if (row < 19) {
					val *= grid[row+1][column];
					if (row < 18) {
						val *= grid[row+2][column];
						if (row < 17) {
							val *= grid[row+3][column];
						}
					}
				}
				if (val > largestValue) {
					largestValue = val;
				}
			}
		}
		System.out.println(largestValue);
		
		// diagonal down
		for (int row = 0; row < 20; row++) {
			for (int column = 0; column < 20; column++) {
				long val = grid[row][column];
				if (row < 19 && column < 19) {
					val *= grid[row+1][column+1];
					if (row < 18 && column < 18) {
						val *= grid[row+2][column+2];
						if (row < 17 && column < 17) {
							val *= grid[row+3][column+3];
						}
					}
				}
				if (val > largestValue) {
					largestValue = val;
				}
			}
		}
		System.out.println(largestValue);
		
		// diagonal up
		for (int row = 0; row < 20; row++) {
			for (int column = 0; column < 20; column++) {
				long val = grid[row][column];
				if (row > 0 && column < 19) {
					val *= grid[row-1][column+1];
					if (row > 1 && column < 18) {
						val *= grid[row-2][column+2];
						if (row > 2 && column < 17) {
							val *= grid[row-3][column+3];
						}
					}
				}
				if (val > largestValue) {
					largestValue = val;
				}
			}
		}
		System.out.println(largestValue);
		
		System.out.println("The largest product of 4 in a row nums is " + largestValue);
	}

}
