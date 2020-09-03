package com.wellsfargo.jpahd.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="depts")
public class Department implements Serializable{

	@Id
	@GeneratedValue
	@Column(name="deptno")
	private Long departmentNo;
	
	@Column(name="dname")
	private String deptName;
	
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL )
	private Set<Employee> employees;
	
	public Department() {
		//unimplemented
	}

	public Department(Long departmentNo, String deptName) {
		super();
		this.departmentNo = departmentNo;
		this.deptName = deptName;
	}

	public Long getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(Long departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}	
	
}
