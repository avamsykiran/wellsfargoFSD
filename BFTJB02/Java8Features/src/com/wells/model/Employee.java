package com.wells.model;

import java.time.LocalDate;

public class Employee {

	private Long empId;
	private String name;
	private Double basic;
	private LocalDate hireDate;
	
	public Employee() {
		//left blank
	}

	public Employee(Long empId, String name, Double basic, LocalDate hireDate) {
		super();
		this.empId = empId;
		this.name = name;
		this.basic = basic;
		this.hireDate = hireDate;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", basic=" + basic + ", hireDate=" + hireDate + "]";
	}
	
}
