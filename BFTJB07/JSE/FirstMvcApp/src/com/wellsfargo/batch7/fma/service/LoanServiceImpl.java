package com.wellsfargo.batch7.fma.service;

import java.time.Period;

import com.wellsfargo.batch7.fma.model.Loan;

public class LoanServiceImpl implements ILoanService {

	@Override
	public Loan computeInterest(Loan loan) {
		if(loan!=null) {
			double time = Period.between(loan.getDisbursementDate(),loan.getDueDate())
					.toTotalMonths()/12.0;
			double interest = time*loan.getLoanAmount()*loan.getRate();
			double pamt = loan.getLoanAmount()+interest;
			
			loan.setTimeInYears(time);
			loan.setInterest(interest);
			loan.setPayableAmount(pamt);
		}
		return loan;
	}

}
