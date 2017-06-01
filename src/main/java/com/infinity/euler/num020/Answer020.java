package com.infinity.euler.num020;

import java.math.BigInteger;

public class Answer020 {

	private static final int NUM_TO_STOP = 100; 

	public static void main(String[] args) {
		
		BigInteger mult = new BigInteger("1");
		
		for (int i = 1; i <= NUM_TO_STOP; i++) {
			mult = mult.multiply(BigInteger.valueOf(i));
		}
		
		String value = mult.toString();
		System.out.println("Factoral: " + value);
		
		int answer = 0;
		
		for (int i = 0; i < value.length(); i++) {
			String tmp = value.substring(i, i+1);
			answer += Integer.valueOf(tmp);
		}
		
		System.out.println("Answer: " + answer);
	}

}
