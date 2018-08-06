package com.infinity.euler.num030;

import java.math.BigInteger;

public class Answer030 {

	public static void main(String[] args) {
		
		// precompute all powers
		int[] powers = new int[10];
		for (int i = 0; i < 10; i++) {
			powers[i] = (int) Math.pow(i, 5);
		}

		long finalSum = 0;
		
		for (int i = 2; i < 999999; i++) {
			int number = i;
			int sum = 0;
			while (number > 0) {
			    int num =  number % 10;
			    
			    sum += powers[num];
			    
			    number = number / 10;
			}
			
			if (sum == i) {
				System.out.println(i);
				finalSum += i;
			}
		}
		
		System.out.printf("The sum is %d", finalSum);
		
//		BigInteger b = BigInteger.valueOf(9);
//		for (int i = 0; i < 20; i++) {
//			b = b.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(9));
//			BigInteger num = BigInteger.valueOf(powers[9]).multiply(BigInteger.valueOf(b.toString().length()));
//			
//			System.out.println(b + " " + num + " " + num.compareTo(b));
//		}
		
	}

}
