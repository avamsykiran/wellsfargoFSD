package com.wellsfargo.batch7.fma.model;

import java.time.LocalDate;

public class Loan {
	
	private Double loanAmount;
	private Double rate;
	private LocalDate disbursementDate;
	private LocalDate dueDate;
	private Double interest;
	private Double timeInYears;
	private Double payableAmount;
	
	public Loan() {
		
	}

	public Loan(Double loanAmount, Double rate, LocalDate disbursementDate, LocalDate dueDate, Double interest,
			Double timeInYears, Double payableAmount) {
		super();
		this.loanAmount = loanAmount;
		this.rate = rate;
		this.disbursementDate = disbursementDate;
		this.dueDate = dueDate;
		this.interest = interest;
		this.timeInYears = timeInYears;
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

	public LocalDate getDisbursementDate() {
		return disbursementDate;
	}

	public void setDisbursementDate(LocalDate disbursementDate) {
		this.disbursementDate = disbursementDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public Double getTimeInYears() {
		return timeInYears;
	}

	public void setTimeInYears(Double timeInYears) {
		this.timeInYears = timeInYears;
	}

	public Double getPayableAmount() {
		return payableAmount;
	}

	public void setPayableAmount(Double payableAmount) {
		this.payableAmount = payableAmount;
	}
	
	
}
