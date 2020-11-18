package com.wellsfargo.batch5.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("emp")
@Table(name="adb_emps")
public class AdbEmployee extends AdbUser {

	@Column(name="emp_name")
	private String name;
	
	@Column(name="emp_basic")
	private Double basic;
	
	@OneToOne(mappedBy="accountHolder",cascade=CascadeType.ALL)
	private BankAccount salAccount;
	
	public AdbEmployee() {
		
	}

	public AdbEmployee(Integer userId, String userName, String password, String role,String name,Double basic) {
		super(userId, userName, password, role);
		this.name=name;
		this.basic=basic;
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

	public BankAccount getSalAccount() {
		return salAccount;
	}

	public void setSalAccount(BankAccount salAccount) {
		this.salAccount = salAccount;
	}
	
	
}
