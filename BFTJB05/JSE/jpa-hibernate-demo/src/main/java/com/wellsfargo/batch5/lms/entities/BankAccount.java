package com.wellsfargo.batch5.lms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bank_accounts")
public class BankAccount {

	@Id
	@Column(name="acno")
	private Long accNumber;
	
	@Column(name="ifsc")
	private String IfscCode;
	
	@OneToOne(mappedBy="salAccount")
	private Librarian accountHolder;
	
	public BankAccount() {
		
	}

	public BankAccount(Long accNumber, String ifscCode, Librarian accountHolder) {
		super();
		this.accNumber = accNumber;
		IfscCode = ifscCode;
		this.accountHolder = accountHolder;
	}

	public Long getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(Long accNumber) {
		this.accNumber = accNumber;
	}

	public String getIfscCode() {
		return IfscCode;
	}

	public void setIfscCode(String ifscCode) {
		IfscCode = ifscCode;
	}

	public Librarian getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(Librarian accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	
}
