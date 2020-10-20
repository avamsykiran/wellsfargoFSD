package com.wellsfargo.batch5.basics.ui;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimeDemo {

	public static void main(String[] args) {
		
		LocalTime start = LocalTime.now();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		
		LocalDateTime today = LocalDateTime.now();
		System.out.println(today);
		System.out.println(today.format(dtf));

		ZonedDateTime zdToday = ZonedDateTime.now(ZoneId.of("GMT+1"));
		System.out.println(zdToday);
		System.out.println(zdToday.format(dtf));
		
		Period p = Period.between(LocalDate.of(1947, Month.AUGUST,15), LocalDate.now());
		System.out.println("Its been "+p.getYears()+"yrs that we are independent.");
		
		LocalTime end = LocalTime.now();
		Duration d = Duration.between(start, end);
		System.out.println("it took "+d.toMillis()+"ms to execute.");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("DOB(dd-MMM-yyyy): ");		
		String dobStr = scan.next();
		
		LocalDate dob = LocalDate.parse(dobStr, dtf);
		System.out.println("Age: "+Period.between(dob, LocalDate.now()));
	}

}
