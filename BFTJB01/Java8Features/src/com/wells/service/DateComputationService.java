package com.wells.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateComputationService {
	
	public static final DateTimeFormatter dtFormatter 
		= DateTimeFormatter.ofPattern("dd-MMM-yyyy");
	
	public String today() {
		return LocalDate.now().format(dtFormatter);
	}
	
	public Period independentPeriod() {
		LocalDate today = LocalDate.now();
		LocalDate indpDate = LocalDate.of(1947, Month.AUGUST,15);
		return Period.between(indpDate, today);
	}
	
	public Period getPeriod(LocalDate date) {
		LocalDate today = LocalDate.now();		
		return Period.between(date, today);
	}
}
