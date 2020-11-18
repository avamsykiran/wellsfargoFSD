package com.wellsfargo.batch5.lms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("lbrn")
@Table(name="librarians1")
public class Librarian extends LibraryUser{

	@Column(name="name")
	private String name;
	
	@Column(name="sal")
	private Double salary;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="acno")
	private BankAccount salAccount;
	
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

	@Override
	public String toString() {
		return "Librarian [name=" + name + ", salary=" + salary + "]";
	}

	public BankAccount getSalAccount() {
		return salAccount;
	}

	public void setSalAccount(BankAccount salAccount) {
		this.salAccount = salAccount;
	}
	
	
	
}
