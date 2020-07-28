package com.wells.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateDemo {

	public static void main(String[] args) {

		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		System.out.println(today.format(dtf));
		
		LocalDate indpDay = LocalDate.of(1947,Month.AUGUST,15);
		System.out.println(indpDay.format(dtf));
		
		Period p = Period.between(indpDay, today);
		System.out.println(p);
		System.out.println(p.getYears());
		System.out.println(p.toTotalMonths());
		
		String dobStr = "11-Jun-1985";
		LocalDate dob = LocalDate.parse(dobStr, dtf);
		System.out.println(Period.between(dob, today));
		
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		System.out.println(dt.atZone(ZoneId.of("GMT+01:00")));
		
		ZonedDateTime zdt1 = ZonedDateTime.now(ZoneId.of("GMT+01:00"));
		ZonedDateTime zdt2 = ZonedDateTime.now(ZoneId.of("GMT+01:30"));
		ZonedDateTime zdt3 = ZonedDateTime.now(ZoneId.of("GMT+02:00"));
		ZonedDateTime zdt4 = ZonedDateTime.now(ZoneId.of("GMT+05:30"));
				
		System.out.println(zdt1);
		System.out.println(zdt2);
		System.out.println(zdt3);
		System.out.println(zdt4);
		
	}

}
