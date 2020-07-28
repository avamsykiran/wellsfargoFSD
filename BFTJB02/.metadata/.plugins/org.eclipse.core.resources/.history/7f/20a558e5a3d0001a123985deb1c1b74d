package com.wells.ui;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.wells.model.Employee;

public class EmployeeSortingApp {

	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(new Employee[] {
				new Employee(109L, "Zamal", 85000.0, LocalDate.of(1990, Month.JANUARY, 1)),
				new Employee(103L, "Vamsy", 91000.0, LocalDate.of(1990, Month.JANUARY, 11)),
				new Employee(102L, "Uma", 89000.0, LocalDate.of(1990, Month.JANUARY, 21)),
				new Employee(110L, "Raghav", 80010.0, LocalDate.of(1990, Month.JANUARY, 16)),
				new Employee(101L, "Sameer", 87000.0, LocalDate.of(1990, Month.JANUARY, 10)),
				new Employee(119L, "Athul", 86000.0, LocalDate.of(1990, Month.JANUARY, 5))
		});
		
		display(emps);
		
		Collections.sort(emps, (e1,e2) -> e1.getEmpId().compareTo(e2.getEmpId()));
		display(emps);
		
		Collections.sort(emps, (e1,e2) -> e1.getBasic().compareTo(e2.getBasic()));
		display(emps);
	}
	
	private static void display(List<Employee> emps) {
		System.out.println("--------------------");
		for(Employee e:emps) {
			System.out.println(e);
		}
		System.out.println("--------------------");
	}

}
