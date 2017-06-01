package com.infinity.euler.num001;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Answer008 {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		// how long of a string of characters should we look at
		int length = 13;

		
		// get the data from the data file that contains the list of numbers to traverse
		StringBuilder buff = new StringBuilder();
		try (LineNumberReader in = new LineNumberReader(new FileReader("./data/data-008.txt"))) {
			String line = null;
			while ((line = in.readLine()) != null) {
				line = line.trim();
				buff.append(line);
			}
		}
		
		String data = buff.toString();
		
		long largestValue = 0;
		long[] values = new long[length];
		for (int i = 0; i < length; i++) {
			values[i] = 1;
		}
		
		for (int i = 0; i < data.length(); i++) {
			long num = Long.parseLong(data.substring(i, i+1));
			
			for (int j = 0; j < length - 1; j++) {
				values[j] *= num;
			}
			values[length - 1] = num;
			
			if (values[0] > largestValue) {
				largestValue = values[0];
			}
			
			for (int j = 0; j < length - 1; j++) {
				values[j] = values[j+1];
			}
			values[length-1] = 1;
		}
		
		for (int i = 0; i < values.length; i++) {
			if (values[i] > largestValue) {
				largestValue = values[i];
			}
		}
		
		System.out.println("The largetst " + length + " string of characters multiplied together is " + largestValue);
	}
	
}
