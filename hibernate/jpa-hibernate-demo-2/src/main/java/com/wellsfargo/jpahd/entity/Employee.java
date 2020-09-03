package com.wellsfargo.jpahd.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
/*
@Table(name="ALL_EMPS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "etype",discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("E")
*/

/*
 * @Table(name="emps_main")
 * 
 * @Inheritance(strategy = InheritanceType.JOINED)
 */

@Table(name="emps_only")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
