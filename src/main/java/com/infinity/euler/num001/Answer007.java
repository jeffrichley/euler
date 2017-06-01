package com.infinity.euler.num001;

/**
 * 10001th 
 * 
 * @author Jeffrey.Richley
 */
public class Answer007 {

	public static void main(String[] args) {

		int whichPrime = 10001;
		
		int length = 10000000;
		
		int sqrt = (int) Math.sqrt(length);
		boolean[] marked = new boolean[length];
		
		int numFound = 0;
		int lastChecked = 0;
		
		for (int i = 2; i < sqrt; i++) {
			// first see if this one has been marked, if not, it is prime
			if (!marked[i]) {
				numFound++;
				// if we have found which one we are looking for, print it and stop
				if (numFound == whichPrime) {
					System.out.println("The " + whichPrime + "th is " + i);
					break;
				}

				// now mark off multiples of this number
				int markIt = i * i;
				while (markIt < length) {
					marked[markIt] = true;
					markIt += i;
				}
			}
			
			lastChecked = i;
		}
		
		// now that we have marked all of the prime numbers
		// we simply need to loop through all the rest and 
		// find the one we are looking for, if we haven't found it yet
		if (numFound < whichPrime) {
			for (int i = lastChecked; i < length; i++) {
				if (!marked[i]) {
					numFound++;
					// if we have found which one we are looking for, print it and stop
					if (numFound == whichPrime) {
						System.out.println("The " + whichPrime + "th is " + i);
						break;
					}
				}
			}
		}
		
		
	}

}
