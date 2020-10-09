package com.wellsfargo.fsd.lms.service;

import java.util.List;

import com.wellsfargo.fsd.lms.exception.LoanException;
import com.wellsfargo.fsd.lms.model.LoanModel;

public interface LoanService {

	LoanModel add(LoanModel loan) throws LoanException;
	LoanModel save(LoanModel loan) throws LoanException;
	
	boolean deleteLoan(int loanId) throws LoanException;
	
	LoanModel getLoan(int loanId);
	List<LoanModel> getAllLoans();
}
