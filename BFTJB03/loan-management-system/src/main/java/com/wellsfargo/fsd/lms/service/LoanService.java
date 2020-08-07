package com.wellsfargo.fsd.lms.service;

import java.util.List;

import com.wellsfargo.fsd.lms.entity.Loan;
import com.wellsfargo.fsd.lms.exception.LoanException;

public interface LoanService {

	Loan validateAndAdd(Loan loan) throws LoanException;
	Loan validateAndSave(Loan loan) throws LoanException;
	
	boolean deleteLoan(int loanId) throws LoanException;
	
	Loan getLoan(int loanId) throws LoanException;
	List<Loan> getAllLoans() throws LoanException;
}
