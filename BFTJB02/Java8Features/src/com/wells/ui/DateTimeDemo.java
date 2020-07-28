package com.wells.ui;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateTimeDemo {

	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		System.out.println(today.format(dtf));
		
		LocalDate indpDay = LocalDate.of(1947, Month.AUGUST,15);
		System.out.println(indpDay.format(dtf));
		
		Period indPeriod = Period.between(indpDay, today);
		System.out.println(indPeriod);
		System.out.println(indPeriod.getYears());
		System.out.println(indPeriod.toTotalMonths());
		
		String dobStr = "11-Jun-1985";
		//LocalDate dob = LocalDate.parse(dobStr);//ISO format is assumed
		LocalDate dob = LocalDate.parse(dobStr,dtf);
		System.out.println(dob.format(dtf));
		System.out.println("Age "+Period.between(dob,today).getYears());
	}

}
