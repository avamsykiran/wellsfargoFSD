package com.wellsfargo.batch7.basics.service;

import java.util.List;
import java.util.function.Predicate;

import com.wellsfargo.batch7.basics.model.Employee;

public class EmployeeService {

	/*public void payHike(List<Employee> emps, double raise, Selectable s) {
		for (Employee emp : emps) {
			if (s.selected(emp)) {
				emp.setBasic(emp.getBasic() + raise);
			}
		}
	}*/
	public void payHike(List<Employee> emps, double raise,Predicate<Employee> prd) {
		for (Employee emp : emps) {
			if (prd.test(emp)) {
				emp.setBasic(emp.getBasic() + raise);
			}
		}
	}
}
