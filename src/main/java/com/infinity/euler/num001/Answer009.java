package com.infinity.euler.num001;

public class Answer009 {

	public static void main(String[] args) {
		
		long[] squares = new long[1000];
		
		for (int i = 0; i < squares.length; i++) {
			squares[i] = i * i;
		}
		
		for (int a = 0; a < 1000; a++) {
			for (int b = a + 1; b < 1000; b++) {
				for (int c = b + 1; c < 1000; c++) {
					long squareA = squares[a];
					long squareB = squares[b];
					long squareC = squares[c];
					if (squareA + squareB == squareC && a + b + c == 1000) {
						System.out.println(a + " * " + b + " * " + c + " = " + (a*b*c));
					}
				}
			}
		}
		
	}

}
