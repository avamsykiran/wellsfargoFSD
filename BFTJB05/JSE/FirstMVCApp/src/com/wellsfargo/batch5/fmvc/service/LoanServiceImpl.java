package com.wellsfargo.batch5.fmvc.service;

import java.time.LocalDate;
import java.time.Period;

import com.wellsfargo.batch5.fmvc.model.Loan;

public class LoanServiceImpl implements ILoanService {

	@Override
	public Loan computeInterest(Loan loan) {
		if(loan!=null) {
			
			double timeInYears = Period.between(loan.getDisbursmentDate(), LocalDate.now())
					.toTotalMonths()/12.0;
			
			double interest = (loan.getLoanAmount()*timeInYears*loan.getRate());
			
			double amt = loan.getLoanAmount()+interest;
			
			loan.setPayableAmount(amt);
			loan.setInterest(interest);
			
		}
		return loan;
	}

}
