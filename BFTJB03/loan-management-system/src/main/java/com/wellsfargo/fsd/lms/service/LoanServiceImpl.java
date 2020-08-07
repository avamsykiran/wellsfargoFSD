package com.wellsfargo.fsd.lms.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.lms.dao.LoanDao;
import com.wellsfargo.fsd.lms.dao.LoanDaoJdbcImpl;
import com.wellsfargo.fsd.lms.entity.Loan;
import com.wellsfargo.fsd.lms.exception.LoanException;

public class LoanServiceImpl implements LoanService {
	
	LoanDao loanDao;
	
	public LoanServiceImpl() {
		loanDao=new LoanDaoJdbcImpl();
	}

	private boolean isValidLoanId(Integer loanId) {
		return loanId!=null && loanId>0;
	}
	
	private boolean isValidPrincipal(Double p) {
		return p!=null && p>0;
	}
	
	private boolean isValidRate(Double r) {
		return r!=null && (r>=0 || r<=1);
	}
	
	private boolean isValidEmiCount(Integer ec) {
		return ec!=null && ec>0;
	}
	
	private boolean isValidDob(LocalDate dob) {
		return dob==null || !dob.isAfter(LocalDate.now());
	}
	
	private boolean isValidStatus(String status) {
		return status!=null && (status.length()>3 && status.length()<10);
	}
	
	private boolean isValidLoan(Loan loan) throws LoanException{
		boolean isValid=true;
		
		List<String> errMsgs = new ArrayList<>();
		
		if(loan!=null) {
			if(!isValidLoanId(loan.getLoanId())) {
				isValid=false;
				errMsgs.add("Loan Id must be a positive non-repetative number");
			}
			if(!isValidPrincipal(loan.getPrincipal())) {
				isValid=false;
				errMsgs.add("Principal must be a positive non-repetative number");
			}
			if(!isValidRate(loan.getRateOfInterest())) {
				isValid=false;
				errMsgs.add("Rate of Interest must be between 0 and 1");
			}
			if(!isValidDob(loan.getDateOfDisbursment())) {
				isValid=false;
				errMsgs.add("Disbursment Date must be a past date");
			}
			if(!isValidStatus(loan.getStatus())) {
				isValid=false;
				errMsgs.add("Status must be of 3 to 10 chars in length");
			}
			if(!isValidEmiCount(loan.getEmiCount())) {
				isValid=false;
				errMsgs.add("EMI Count must be a postive non-zero number");
			}
			if(!errMsgs.isEmpty()) {
				throw new LoanException(errMsgs.toString());
			}
		}else {
			isValid=false;
		}
		
		return isValid;
	}
	
	@Override
	public Loan validateAndAdd(Loan loan) throws LoanException {
		if(isValidLoan(loan)) {
			loanDao.add(loan);
		}
		return loan;
	}

	@Override
	public Loan validateAndSave(Loan loan) throws LoanException {
		if(isValidLoan(loan)) {
			loanDao.save(loan);
		}
		return loan;
	}

	@Override
	public boolean deleteLoan(int loanId) throws LoanException {
		return loanDao.deleteById(loanId);
	}

	@Override
	public Loan getLoan(int loanId) throws LoanException {
		return loanDao.getById(loanId);
	}

	@Override
	public List<Loan> getAllLoans() throws LoanException {
		return loanDao.getAll();
	}

}
