package com.wellsfargo.batch7.fma.service;

import com.wellsfargo.batch7.fma.model.Loan;

public interface ILoanService {
 Loan computeInterest(Loan loan);
}
