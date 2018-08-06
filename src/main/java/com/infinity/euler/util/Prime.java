package com.infinity.euler.util;

public class Prime {
	
	public static boolean isPrime(int[] perm) {
		long check = 0;
		
		for (int i : perm) {
			check = check * 10 + i;
		}
		
		return isPrime(check);
	}
	
	public static boolean isPrime(long perm) {
		
		if (perm < 0) {
			return false;
		}

		if (perm == 2) {
			return true;
		} else if (perm == 3) {
			return true;
		} else if (perm % 2 == 0) {
			return false;
		} else if (perm % 3 == 0) {
			return false;
		} else {

			int i = 5;
			int w = 2;

			while (i * i <= perm) {
				if (perm % i == 0) {
					return false;
				}

				i += w;
				w = 6 - w;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(21 + " " + isPrime(21));
		System.out.println(7 + " " + isPrime(7));
	}

}
