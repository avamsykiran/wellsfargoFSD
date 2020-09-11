package com.wellsfargo.fsd.swbd.service;

import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.swbd.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void computeAllowences(Employee employee) {
		employee.setTa(employee.getBasic()*0.10);
		employee.setHra(employee.getBasic()*0.20);
	}

}
