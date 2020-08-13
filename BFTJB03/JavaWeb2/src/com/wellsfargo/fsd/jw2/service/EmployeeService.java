package com.wellsfargo.fsd.jw2.service;

import com.wellsfargo.fsd.jw2.model.EmployeeModel;

public class EmployeeService {

	public void computeAll(EmployeeModel empModel) {
		empModel.setHra(empModel.getBasic()*0.15);
		empModel.setTa(empModel.getBasic()*0.20);
	}
}
