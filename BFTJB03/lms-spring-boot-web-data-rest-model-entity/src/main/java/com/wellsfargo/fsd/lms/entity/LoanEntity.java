package com.wellsfargo.fsd.lms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="loans")
public class LoanEntity {

	@Id
	@Column(name="lid")
	private Integer loanId;
	
	@Column(name="p")
	private Double principal;
	
	@Column(name="r")
	private Double rateOfInterest;
	
	@Column(name="ec")
	private Integer emiCount;
	
	@Column(name="dob")
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate dateOfDisbursment;
	
	@Column(name="status")
	private String status;
	
	public LoanEntity() {
		//left unimplemented
	}

	public LoanEntity(Integer loanId, Double principal, Double rateOfInterest, Integer emiCount, LocalDate dateOfDisbursment,
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
