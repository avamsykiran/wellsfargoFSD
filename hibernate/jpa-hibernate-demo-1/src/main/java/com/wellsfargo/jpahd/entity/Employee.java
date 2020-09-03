package com.wellsfargo.jpahd.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name = "listEmpsInBasicRange",
			query="SELECT e FROM Employee e WHERE e.basic between :limit1 and :limit2"),
	@NamedQuery(name = "listEmpsWithLastName",
		query="SELECT e FROM Employee e WHERE e.lastName = :lnm")
})

@Entity
@Table(name="emps1") 
public class Employee implements Serializable{

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
	
	
}
