package com.wellsfargo.batch7.basics.ui;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeDateDemo {

	public static void main(String[] args) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy/hh:mm:ss a");
		
		LocalDateTime today = LocalDateTime.now();
		System.out.println(today);
		System.out.println(today.format(dtf));
		
		ZonedDateTime britanToday = ZonedDateTime.now(ZoneId.of("GMT+1"));
		System.out.println(britanToday);		
		System.out.println(britanToday.format(dtf));
		
		LocalDateTime indDay = LocalDateTime.of(1947,Month.AUGUST,15,0,0);
		
		Duration d = Duration.between(indDay, today);
		System.out.println(d);
		System.out.println(d.toDays() +" days");
		
		Period p = Period.between(LocalDate.from(indDay), LocalDate.now());
		System.out.println(p);
		System.out.println(p.getYears() + "yrs");
	}

}
