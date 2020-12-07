package com.wellsfargo.batch5.sbwdd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="librarians1")
public class Librarian extends LibraryUser{

	@Column(name="name")
	private String name;
	
	@Column(name="sal")
	private Double salary;
	
	public Librarian() {
		
	}

	public Librarian(Integer libUserId, String userName, String password, String role,String name,Double salary) {
		super(libUserId, userName, password, role);
		this.name=name;
		this.salary=salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	
}
