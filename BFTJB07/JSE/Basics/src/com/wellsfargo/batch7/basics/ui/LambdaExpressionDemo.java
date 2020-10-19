package com.wellsfargo.batch7.basics.ui;

import java.util.Arrays;
import java.util.List;

import com.wellsfargo.batch7.basics.model.Employee;
import com.wellsfargo.batch7.basics.service.EmployeeService;

public class LambdaExpressionDemo {

	public static void main(String[] args) {
		EmployeeService empService = new EmployeeService();
		
		List<Employee> emps = Arrays.asList(new Employee[] {
				new Employee(101,"Vamsy Kiran",45000.0,"Analyst"),
				new Employee(102,"Suseela",145000.0,"Sr. Analyst"),
				new Employee(103,"Indhikaa Valli",425000.0,"Sr. Analyst"),
				new Employee(104,"Sagar Guru ",50000.0,"Analyst"),
				new Employee(105,"Srinivas",35000.0,"Jr. Analyst"),
				new Employee(106,"Venkat",25000.0,"Jr. Analyst")
		});
		
		for(Employee emp : emps) {
			System.out.println(emp);
		}
		System.out.println("--------------------------------------");
		
		empService.payHike(emps, 10000, (e) -> e.getDesignation().equals("Analyst"));
		for(Employee emp : emps) {
			System.out.println(emp);
		}
		System.out.println("--------------------------------------");
		
		empService.payHike(emps, 5000, (e) -> e.getBasic()<=40000);
		for(Employee emp : emps) {
			System.out.println(emp);
		}
		System.out.println("--------------------------------------");
	}

}
