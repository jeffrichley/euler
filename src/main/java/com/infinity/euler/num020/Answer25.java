package com.infinity.euler.num020;

import java.math.BigDecimal;

public class Answer25 {

	private static final BigDecimal ONE = new BigDecimal(1);
	private static final BigDecimal TEN = new BigDecimal(10);

	public static void main(String[] args) {

		BigDecimal one = new BigDecimal(1);
		BigDecimal two = new BigDecimal(1);

		int count = 2;

		// keep going until we have 1000 digits
		while (hasNumDigits(two) < 1000) {
			count++;

			// calculate the fib number
			BigDecimal next = one.add(two);

			one = two;
			two = next;

		}

		System.out.printf("The index of the first with 1000 digits is %d", count);
	}

	private static int hasNumDigits(BigDecimal number) {

		int length = 0;

		BigDecimal temp = ONE;

		// step by 10 to find out how many characters there are
		while (temp.compareTo(number) == -1 || temp.compareTo(number) == 0) {
			length++;
			temp = temp.multiply(TEN);
		}
		return length;

	}

}
