package com.wellsfargo.fsd.lms.entity;

import java.time.LocalDate;

public class Loan {

	private Integer loanId;
	private Double principal;
	private Double rateOfInterest;
	private Integer emiCount;
	private LocalDate dateOfDisbursment;
	private String status;
	
	public Loan() {
		//left unimplemented
	}

	public Loan(Integer loanId, Double principal, Double rateOfInterest, Integer emiCount, LocalDate dateOfDisbursment,
			String status) {
		super();
		this.loanId = loanId;
		this.principal = principal;
		this.rateOfInterest = rateOfInterest;
		this.emiCount = emiCount;
		this.dateOfDisbursment = dateOfDisbursment;
		this.status = status;
	}

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public Double getPrincipal() {
		return principal;
	}

	public void setPrincipal(Double principal) {
		this.principal = principal;
	}

	public Double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public Integer getEmiCount() {
		return emiCount;
	}

	public void setEmiCount(Integer emiCount) {
		this.emiCount = emiCount;
	}

	public LocalDate getDateOfDisbursment() {
		return dateOfDisbursment;
	}

	public void setDateOfDisbursment(LocalDate dateOfDisbursment) {
		this.dateOfDisbursment = dateOfDisbursment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", principal=" + principal + ", rateOfInterest=" + rateOfInterest
				+ ", emiCount=" + emiCount + ", dateOfDisbursment=" + dateOfDisbursment + ", status=" + status + "]";
	}
	
	
}
