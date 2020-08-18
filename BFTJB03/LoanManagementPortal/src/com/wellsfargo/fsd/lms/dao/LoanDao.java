package com.wellsfargo.fsd.lms.dao;

import java.util.List;

import com.wellsfargo.fsd.lms.entity.Loan;
import com.wellsfargo.fsd.lms.exception.LoanException;

public interface LoanDao {

	Loan add(Loan loan) throws LoanException;
	Loan save(Loan loan) throws LoanException;
	boolean deleteById(int loandId) throws LoanException;
	
	List<Loan> getAll() throws LoanException;
	Loan getById(int loanId) throws LoanException;
}
