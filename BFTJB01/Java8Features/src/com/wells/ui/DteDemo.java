package com.wells.ui;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

import com.wells.service.DateComputationService;

public class DteDemo {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		DateComputationService dcs=new DateComputationService();
		
		System.out.println(dcs.today());
		
		Period p = dcs.independentPeriod();
		
		System.out.println(p);
		System.out.println(p.toTotalMonths());
		System.out.println(p.getYears());
		
		System.out.print("DOB(dd-MMM-yyyy): ");
		String dobStr = scan.next();
		
		LocalDate dob = LocalDate.parse(dobStr,DateComputationService.dtFormatter);

		Period age = dcs.getPeriod(dob);
		System.out.println("you are "+age.getYears()+"yrs old approx.");
	}

}
