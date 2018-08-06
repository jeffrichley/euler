package com.infinity.euler.num020;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Answer29 {

	public static void main(String[] args) {
		
		int maxA = 100;
		int maxB = 100;
		
		Set<BigDecimal> values = new HashSet<>();
		
		for (int a = 2; a <= maxA; a++) {
			for (int b = 2; b <= maxB; b++) {
				BigDecimal tmp = new BigDecimal(a).pow(b);
				values.add(tmp);
			}
		}

		System.out.printf("There are %d unique", values.size());
	}

}
