package com.wellsfargo.batch5.fmvc.model;

import java.time.LocalDate;

public class Loan {

	private Double loanAmount;
	private Double rate;
	private LocalDate disbursmentDate;
	private Double interest;
	private Double payableAmount;
	
	public Loan() {
		
	}

	public Loan(Double loanAmount, Double rate, LocalDate disbursmentDate, Double interest, Double payableAmount) {
		super();
		this.loanAmount = loanAmount;
		this.rate = rate;
		this.disbursmentDate = disbursmentDate;
		this.interest = interest;
		this.payableAmount = payableAmount;
	}

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public LocalDate getDisbursmentDate() {
		return disbursmentDate;
	}

	public void setDisbursmentDate(LocalDate disbursmentDate) {
		this.disbursmentDate = disbursmentDate;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public Double getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(Double payableAmount) {
		this.payableAmount = payableAmount;
	}
	
	
}
