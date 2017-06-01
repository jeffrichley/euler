package com.infinity.euler.num010;

public class Answer015 {

	private static final int SIZE = 20;
	
	public static void main(String[] args) {
		long[][] grid = new long[SIZE+1][SIZE+1];
		
		for (int row = 0; row < SIZE+1; row++) {
			for (int column = 0; column < SIZE+1; column++) {
				long num = 0;

				// special case: must seed the first with a 1
				if (row == 0 && column == 0) {
					num = 1;
				}
				
				// add the one above
				if (row != 0) {
					num += grid[row-1][column];
				}
				
				// add the one to the left
				if (column != 0) {
					num += grid[row][column-1];
				}
				grid[row][column] = num;
			}
		}
		
		System.out.println("There are " + grid[SIZE][SIZE] + " paths");
	}

}
