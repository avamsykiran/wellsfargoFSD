package com.wellsfargo.fsd.swbd.service;

import com.wellsfargo.fsd.swbd.model.Loan;

public interface LoanService {
	void computeSI(Loan loan);
}
