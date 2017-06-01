package com.infinity.euler.num010;

public class Answer017 {

	public static void main(String[] args) {
		int count = 0;
		
		// 1 - 999
		for (int i = 1; i < 1000; i++) {
			int hundreds = i / 100;
			int tens = (i - (100*hundreds)) / 10;
			int ones = i - (100*hundreds) - (10*tens);
			
			System.out.println(i + " " + hundreds + tens + ones);
			
			// count hundreds
			
			// count tens
			count += countTens(tens, ones);
			
		}
		
		// 1000
		count += 11;
		
		System.out.println(count);
	}

	private static int countTens(int tens, int ones) {
		int answer = 0;
		
		switch (tens) {
		case 1:
			if (ones == 0) {
				// ten
				answer = 3;
			} else {
//				answer = countTeens()
			}
			break;

		default:
			break;
		}
		
		return answer ;
	}

	private static int countOnes(int ones) {
		int answer = 0;
		
		switch (ones) {
		case 1:
		case 2:
		case 6:
			answer = 3;
			break;
			
		case 4:
		case 5:
		case 9:
			answer = 4;
			break;

		case 3:
		case 7:
		case 8:
			answer = 5;
			break;

		default:
			break;
		}
		
		return answer;
	}

}
