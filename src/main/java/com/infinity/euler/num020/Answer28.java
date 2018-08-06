package com.infinity.euler.num020;

public class Answer28 {

	private static int[][] createBoard(int size) {

		int[][] board = new int[size][size];

		int count = 1;

		int x = size / 2;
		int y = size / 2;

		// set center
		board[x][y] = count++;

		int sideSize = 3;
		while (x != size - 1 && y != 0) {
			// move to the right
			x++;
			board[x][y] = count++;

			// move down appropriate number
			int numMoveDown = sideSize - 2;
			for (int i = 0; i < numMoveDown; i++) {
				y++;
				board[x][y] = count++;
			}

			// move left appropriate number
			for (int i = 0; i < sideSize - 1; i++) {
				x--;
				board[x][y] = count++;
			}

			// move up appropriate number
			for (int i = 0; i < sideSize - 1; i++) {
				y--;
				board[x][y] = count++;
			}

			// move right appropriate number
			for (int i = 0; i < sideSize - 1; i++) {
				x++;
				board[x][y] = count++;
			}

			sideSize += 2;
		}

		return board;
	}

	private static long sum(int[][] board) {
		long sum = 0;

		int middle = board.length / 2;

		for (int x = 0; x < board.length; x++) {
			sum += board[x][x];
			if (x != middle) {
				sum += board[x][board.length - 1 - x];
			}
		}

		return sum;
	}

	public static void main(String[] args) {

		int size = 1001;

		int[][] board = createBoard(size);

		long sum = sum(board);

		System.out.println("The answer is " + sum);
	}

}
