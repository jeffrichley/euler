package com.infinity.euler.num040;

public class Answer41 {

	public static void main(String[] args) {

		int n = 9;

		// we need to loop down from 9 characters
		boolean found = false;
		while (!found) {
			found = checkPerm(n);
			n--;
		}
	}

	private static boolean checkPerm(int n) {

		// create the array to look for primes with
		int[] perm = new int[ n];
		for (int i = 0; i < n; i++) {
			perm[i] = n - i;
		}


		while (true) {

			//check if the current is prime
			if (isPrime(perm)) {
				System.out.print("Largest Prime: ");

				for (int digit : perm) {
					System.out.print(digit);
				}

				return true;
			}

			// find the longest non-increasing suffix
			// save the next index as the pivot
			int pivot = -1;
			int suffixHeadIndex = perm.length - 1;

			// if pivot is negative, we haven't found the pivot point yet
			// also don't want to overrun the array
			while (pivot < 0 && suffixHeadIndex != 0) {
				if (perm[suffixHeadIndex] >= perm[suffixHeadIndex - 1]) {
					suffixHeadIndex--;
				} else {
					pivot = suffixHeadIndex - 1;
				}
			}

			// if we have a negative pivot, we exhausted our permutations
			if (pivot < 0) {
				System.out.println("No more permutations.");
				break;
			}

			// moving right to left, find the first element less than the pivot
			for (int j = perm.length - 1; j >= 0; j--) {
				if (perm[j] < perm[pivot]) {
					// swap the found index with pivot
					int tmp = perm[pivot];
					perm[pivot] = perm[j];
					perm[j] = tmp;

					break;
				}
			}

			// reverse the order of the suffix
			int end = perm.length - 1;
			int start = pivot + 1;
			while (start < end) {
				int tmp = perm[start];
				perm[start] = perm[end];
				perm[end] = tmp;

				start++;
				end--;
			}
			
		}
		
		return false;
	}

	private static boolean isPrime(int[] perm) {
		long check = 0;

		for (int i : perm) {
			check = check * 10 + i;
		}

		if (check == 2) {
			return true;
		} else if (check == 3) {
			return true;
		} else if (check % 2 == 0) {
			return false;
		} else if (check % 3 == 0) {
			return false;
		} else {

			int i = 5;
			int w = 2;

			while (i * i <= check) {
				if (check % i == 0) {
					return false;
				}

				i += w;
				w = 6 - w;
			}
		}

		return true;
	}

}
