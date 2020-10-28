package com.wellsfargo.batch5.fmvc.service;

import com.wellsfargo.batch5.fmvc.model.Loan;

public interface ILoanService {
	
	Loan computeInterest(Loan loan);

}
