package com.infinity.euler.num010;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Answer018 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		try (LineNumberReader in = new LineNumberReader(new FileReader("./data/data-018.txt"))) {
			
			int[] previous = null;
			int[] current = null;
			
			String line = null;
			while ((line = in.readLine()) != null) {
				
				previous = current;
				
				System.out.println(line);
				
				String[] parts = line.split(" ");
				current = new int[parts.length];
				
				for (int i = 0; i < current.length; i++) {
					current[i] = Integer.parseInt(parts[i]);
				}
				
				if (previous != null) {
					for (int i = 0; i < current.length; i++) {
						int first = 0;
						if (i > 0) {
							first = previous[i-1];
						}
						
						int second = 0;
						
						if (previous.length > i) {
							second = previous[i];
						}
						
						int largest = Math.max(first, second);
						
						current[i] += largest;
					}
				}
				
			}
			
			int answer = 0;
			
			for (int i = 0; i < current.length; i++) {
				answer = Math.max(answer, current[i]);
			}
			
			System.out.println("The largest path equals " + answer);
		}
		
	}

}
