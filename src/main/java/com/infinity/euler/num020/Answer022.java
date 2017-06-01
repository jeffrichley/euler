package com.infinity.euler.num020;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Answer022 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		List<String> names = new ArrayList<>();
		
		try (LineNumberReader in = new LineNumberReader(new FileReader("./data/data-022.txt"))) {
			String line = in.readLine();
			String[] parts = line.split(",");
			
			for (String name : parts) {
				name = name.substring(1, name.length()-1);
				names.add(name);
			}
		}
		
		Collections.sort(names);
		
		long answer = 0;
		
		for (int i = 0; i < names.size(); i++) {
			String name = names.get(i);
			long value = 0;
			
			for (int j = 0; j < name.length(); j++) {
				int tmp = name.charAt(j) - 64;
				value += tmp;
			}
			
			answer += value * (i+1);
		}
		
		System.out.println("The total is " + answer);
	}

}
