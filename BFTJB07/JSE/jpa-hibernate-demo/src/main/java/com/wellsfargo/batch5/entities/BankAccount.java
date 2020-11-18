package com.wellsfargo.batch5.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bank_accounts")
public class BankAccount {

	@Id
	@Column(name="acno")
	private Long accNumber;
	
	@Column(name="ifsc")
	private String ifscCode;
	
	@OneToOne
	@JoinColumn(name="uid")
	private AdbEmployee accountHolder;
	
	public BankAccount() {
		
	}
	
	public BankAccount(Long accNumber, String ifscCode, AdbEmployee accountHolder) {
		super();
		this.accNumber = accNumber;
		this.ifscCode = ifscCode;
		this.accountHolder = accountHolder;
	}

	public Long getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(Long accNumber) {
		this.accNumber = accNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public AdbEmployee getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(AdbEmployee accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	
	
}
