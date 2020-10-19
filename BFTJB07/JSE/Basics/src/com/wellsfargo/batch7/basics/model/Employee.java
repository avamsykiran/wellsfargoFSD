package com.wellsfargo.batch7.basics.model;

public class Employee {
	
	private Integer empId;
	private String fullName;
	private Double basic;
	private String designation;

	public Employee() {
	}

	public Employee(Integer empId, String fullName, Double basic, String designation) {
		super();
		this.empId = empId;
		this.fullName = fullName;
		this.basic = basic;
		this.designation = designation;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", fullName=" + fullName + ", basic=" + basic + ", designation="
				+ designation + "]";
	}
	
}
