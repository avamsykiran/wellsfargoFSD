package com.wells.ui;

import java.time.LocalDate;

import java.util.function.Consumer;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.wells.model.Employee;

public class StreamDemo {

	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(new Employee[] {
				new Employee(109L, "Zamal", 85000.0, LocalDate.of(1990, Month.JANUARY, 1)),
				new Employee(103L, "Vamsy", 91000.0, LocalDate.of(1990, Month.JANUARY, 11)),
				new Employee(102L, "Uma", 89000.0, LocalDate.of(1990, Month.JANUARY, 21)),
				new Employee(110L, "Raghav", 80010.0, LocalDate.of(1990, Month.JANUARY, 16)),
				new Employee(101L, "Sameer", 87000.0, LocalDate.of(1990, Month.JANUARY, 10)),
				new Employee(119L, "Athul", 86000.0, LocalDate.of(1990, Month.JANUARY, 5))
		});
		
		Consumer consumer = System.out::println;
		
		emps.stream().forEach(consumer);
		emps.stream().forEach((emp) -> {emp.setBasic(emp.getBasic()+5000);});
		System.out.println("--------------------------------------");
		emps.stream().forEach(System.out::println);
		
		System.out.println("--------------------------------------");
		Optional<Employee> result =emps.stream().reduce((e1,e2) -> e1.getHireDate().isBefore(e2.getHireDate())?e1:e2);
		if(result.isPresent()) {
			System.out.println(result.get());
		}
		
		System.out.println("--------------------------------------");
		Employee junior = emps.stream().reduce((e1,e2) -> e1.getHireDate().isAfter(e2.getHireDate())?e1:e2).orElse(null);
		System.out.println(junior);
		
		System.out.println("--------------------------------------");
		emps.stream().filter((emp) -> emp.getBasic()<=95000).forEach(System.out::println);
		
		System.out.println("--------------------------------------");
		List<Employee> emps2 = emps.stream().filter((emp) -> emp.getBasic()<=95000).collect(Collectors.toList());
		System.out.println(emps2);
		
		System.out.println("--------------------------------------");
		emps.stream().map((emp)->emp.getName()).forEach(System.out::println);
		
		f1(System.out::println,Arrays.asList(new String[] {"a","b","c"}));
	}
	
	private static void f1(Consumer consumer,List<String> data) {
		for(String s : data) {
			consumer.accept(s);
		}
	}
}
