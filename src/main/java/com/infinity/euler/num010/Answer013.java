package com.infinity.euler.num010;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.math.BigInteger;

public class Answer013 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BigInteger total = new BigInteger("0");
		
		try (LineNumberReader in = new LineNumberReader(new FileReader("./data/data-013.txt"))) {
			String line = null;
			
			while ((line = in.readLine()) != null) {
				BigInteger lineNum = new BigInteger(line);
				total = total.add(lineNum);
			}
		}
		
		String totalString = total.toString().substring(0, 10);
		
		System.out.println(total);
		System.out.println(totalString);
	}

}
