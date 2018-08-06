package com.infinity.euler.num020;

/**
 * @author Jeffrey.Richley
 */
public class Answer24 {

	public static void main(String[] args) {
		 int[] perm = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

		for (int i = 0; i < 999999; i++) {

			// find the longest non-increasing suffix
			// save the next index as the pivot
			int pivot = -1;
			int suffixHeadIndex = perm.length - 1;

			// if pivot is negative, we haven't found the pivot point yet
			// also don't want to overrun the array
			while (pivot < 0 && suffixHeadIndex != 0) {
				if (perm[suffixHeadIndex] <= perm[suffixHeadIndex - 1]) {
					suffixHeadIndex--;
				} else {
					pivot = suffixHeadIndex - 1;
				}
			}
			
			// if we have a negative pivot, we exhausted our permutations
			if (pivot < 0) {
				System.out.printf("No more permutations. There were %d permutations.\n", i + 1);
				break;
			}

			// moving right to left, find the first element greater than the pivot
			for (int j = perm.length - 1; j >= 0; j--) {
				if (perm[j] > perm[pivot]) {
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

		for (int digit : perm) {
			System.out.print(digit);
		}
	}

}
