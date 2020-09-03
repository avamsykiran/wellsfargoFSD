package com.wellsfargo.jpahd.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="emps4") 
public class Employee implements Serializable,Comparable<Employee>{

	@Id
	@Column(name="eno")
	private Long empNo;
	
	@Column(name="fnm",nullable = false)
	private String firstName;
	
	@Column(name="lnm",nullable = false)
	private String lastName;
	
	@Column(name="basic",nullable = false)
	private Double basic;
	
	@Column(name="doj",nullable = false)
	private LocalDate joinDate;
		
	@Embedded
	private Address address;
	
	@OneToOne(mappedBy = "accountHolder",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private BankAccount salAccount;
	
	@ManyToOne
	@JoinColumn(name="dept")
	private Department department;
	
	public Employee() {
		//left unimplemented.
	}
	
	public Employee(Long empNo, String firstName, String lastName, Double basic, LocalDate joinDate) {
		super();
		this.empNo = empNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.basic = basic;
		this.joinDate = joinDate;
	}
		
	public Employee(Long empNo, String firstName, String lastName, Double basic, LocalDate joinDate, Address address,
			BankAccount salAccount, Department department) {
		super();
		this.empNo = empNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.basic = basic;
		this.joinDate = joinDate;
		this.address = address;
		this.salAccount = salAccount;
		this.department = department;
	}

	public Long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getBasic() {
		return basic;
	}

	public void setBasic(Double basic) {
		this.basic = basic;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public BankAccount getSalAccount() {
		return salAccount;
	}

	public void setSalAccount(BankAccount salAccount) {
		this.salAccount = salAccount;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int compareTo(Employee o) {
		return this.empNo.compareTo(o.empNo);
	}
			
}
