package com.wellsfargo.fsd.jw2.model;

import java.time.LocalDate;

public class EmployeeModel {
	
	private String fullName;
	private LocalDate hiredate;
	private double basic;
	private double hra;
	private double ta;

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public LocalDate getHiredate() {
		return hiredate;
	}
	public void setHiredate(LocalDate hiredate) {
		this.hiredate = hiredate;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public double getTa() {
		return ta;
	}
	public void setTa(double ta) {
		this.ta = ta;
	}
	

}
