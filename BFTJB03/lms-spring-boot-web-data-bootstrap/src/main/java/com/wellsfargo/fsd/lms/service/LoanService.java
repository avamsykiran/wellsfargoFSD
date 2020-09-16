package com.wellsfargo.fsd.lms.service;

import java.util.List;

import com.wellsfargo.fsd.lms.entity.Loan;
import com.wellsfargo.fsd.lms.exception.LoanException;

public interface LoanService {

	Loan add(Loan loan) throws LoanException;
	Loan save(Loan loan) throws LoanException;
	
	boolean deleteLoan(int loanId) throws LoanException;
	
	Loan getLoan(int loanId);
	List<Loan> getAllLoans();
}
