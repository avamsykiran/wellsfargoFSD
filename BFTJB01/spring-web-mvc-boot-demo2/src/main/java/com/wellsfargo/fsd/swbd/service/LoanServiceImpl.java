package com.wellsfargo.fsd.swbd.service;

import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.swbd.model.Loan;

@Service
public class LoanServiceImpl implements LoanService{

	@Override
	public void computeSI(Loan loan) {
		
		loan.setSimpleInterest(loan.getPrincipal()*loan.getInterestRate()*loan.getTime()/100);
		loan.setPayableAmount(loan.getPrincipal()+loan.getSimpleInterest());
		
	}
	
}
