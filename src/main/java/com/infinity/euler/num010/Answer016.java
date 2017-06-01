package com.infinity.euler.num010;

import java.math.BigInteger;

public class Answer016 {

	public static void main(String[] args) {
		BigInteger two = new BigInteger("2");
		BigInteger answer = new BigInteger("2");
				
		for (int i = 1; i < 1000; i++) {
			answer = answer.multiply(two);
		}

		System.out.println(answer);
		
		String s = answer.toString();
		long sum = 0;
		for (int i = 0; i < s.length(); i++) {
			String tmp = s.substring(i, i+1);
			long t = Long.parseLong(tmp);
			sum += t;
		}
		
		System.out.println(sum);
	}

}
