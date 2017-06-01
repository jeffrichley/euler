package com.infinity.euler.num010;

import java.util.Calendar;

public class Answer019 {

	public static void main(String[] args) {
		
		int numSundays = 0;
		
		for (int year = 1901; year <= 2000; year++) {
			for (int month = 0; month <= 11; month++) {
				Calendar date = Calendar.getInstance();
				date.set(year, month, 1);

				int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
				if (dayOfWeek == 1) {
					numSundays++;
				}
			}
		}
		
		System.out.println("There were " + numSundays + " sundays");
		
	}

}
