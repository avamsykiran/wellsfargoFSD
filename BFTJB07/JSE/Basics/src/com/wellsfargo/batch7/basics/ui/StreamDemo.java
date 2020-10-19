package com.wellsfargo.batch7.basics.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.wellsfargo.batch7.basics.model.Employee;

public class StreamDemo {

	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(new Employee[] {
				new Employee(101,"Vamsy Kiran",45000.0,"Analyst"),
				new Employee(102,"Suseela",145000.0,"Sr. Analyst"),
				new Employee(103,"Indhikaa Valli",425000.0,"Sr. Analyst"),
				new Employee(104,"Sagar Guru ",50000.0,"Analyst"),
				new Employee(105,"Srinivas",35000.0,"Jr. Analyst"),
				new Employee(106,"Venkat",25000.0,"Jr. Analyst")
		});
		
		emps.stream().forEach(System.out::println);
		System.out.println("----------------------------------");

		Optional<Employee> result =emps.stream().reduce((e1,e2) -> (e1.getBasic()<=e2.getBasic()?e1:e2));
		System.out.println(result.get());
		System.out.println("----------------------------------");
		
		Optional<Employee> result2 =emps.stream().reduce((e1,e2) -> (e1.getBasic()>=e2.getBasic()?e1:e2));
		System.out.println(result2.get());
		System.out.println("----------------------------------");
		
		emps.stream().filter(e -> e.getDesignation().equals("Analyst")).forEach(System.out::println);
		System.out.println("----------------------------------");
		
		List<String> empNames = emps.stream().map(e -> e.getFullName()).collect(Collectors.toList());
		System.out.println(empNames);
		
		Set<String> desgs = emps.stream().map(e -> e.getDesignation()).collect(Collectors.toSet());
		System.out.println(desgs);
		
	}

}
