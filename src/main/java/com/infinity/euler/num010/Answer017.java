package com.infinity.euler.num010;

public class Answer017 {

	public static void main(String[] args) {
		int count = 0;
		
		// 1 - 999
		for (int i = 1; i <= 1000; i++) {
			int thousands = i / 1000;
			int hundreds = (i - (1000*thousands)) / 100;
			int tens = (i - (1000*thousands) - (100*hundreds)) / 10;
			int ones = i - (1000*thousands) - (100*hundreds) - (10*tens);

			String name = getName(thousands, hundreds, tens, ones).trim();
			
			String[] parts = name.split(" ");
			for (String part : parts) {
				count += part.length();
			}

			System.out.println(i + " " + thousands + hundreds + tens + ones + " " + name);
		}
		
		System.out.println(count + " 21124");
	}

	private static String getName(int thousands, int hundreds, int tens, int ones) {
		StringBuffer buff = new StringBuffer();
		
		// thousands
		if (thousands > 0) {
			addThousands(buff, thousands);
		}
		
		// hundreds
		if (hundreds > 0) {
			addHundreds(buff, hundreds);
		}
		
		// and
		if ((thousands >= 1 || hundreds >= 1) && (tens > 0 || ones > 0)) {
			buff.append(" and");
		}
		
		// teens
		if (tens == 1) {
			buff.append(" ");
			addteens(buff, ones);
		} else {
		
			// tens
			if (tens > 0) {
				buff.append(" ");
				addTens(buff, tens);
			}
			
			// ones
			if (ones > 0) {
				buff.append(" ");
				addOnes(buff, ones);
			}
		}
		
		return buff.toString();
	}

	private static void addTens(StringBuffer buff, int tens) {
		switch (tens) {
		case 2:
			buff.append("twenty");
			break;

		case 3:
			buff.append("thirty");
			break;

		case 4:
			buff.append("forty");
			break;

		case 5:
			buff.append("fifty");
			break;

		case 6:
			buff.append("sixty");
			break;

		case 7:
			buff.append("seventy");
			break;

		case 8:
			buff.append("eighty");
			break;

		case 9:
			buff.append("ninety");
			break;
			
		default:
			break;
		}
	}

	private static void addteens(StringBuffer buff, int ones) {
		switch (ones) {
		case 0:
			buff.append("ten");
			break;

		case 1:
			buff.append("eleven");
			break;

		case 2:
			buff.append("twelve");
			break;

		case 3:
			buff.append("thirteen");
			break;

		case 4:
			buff.append("fourteen");
			break;

		case 5:
			buff.append("fifteen");
			break;

		case 6:
			buff.append("sixteen");
			break;

		case 7:
			buff.append("seventeen");
			break;

		case 8:
			buff.append("eighteen");
			break;

		case 9:
			buff.append("nineteen");
			break;
			
		default:
			break;
		}
	}

	private static void addHundreds(StringBuffer buff, int hundreds) {
		addOnes(buff, hundreds);
		buff.append(" hundred");
	}

	private static void addThousands(StringBuffer buff, int thousands) {
		addOnes(buff, thousands);
		buff.append(" thousand");
	}

	private static void addOnes(StringBuffer buff, int ones) {
		switch (ones) {
		case 1:
			buff.append("one");
			break;

		case 2:
			buff.append("two");
			break;

		case 3:
			buff.append("three");
			break;

		case 4:
			buff.append("four");
			break;

		case 5:
			buff.append("five");
			break;

		case 6:
			buff.append("six");
			break;

		case 7:
			buff.append("seven");
			break;

		case 8:
			buff.append("eight");
			break;

		case 9:
			buff.append("nine");
			break;

		default:
			break;
		}
	}


}
