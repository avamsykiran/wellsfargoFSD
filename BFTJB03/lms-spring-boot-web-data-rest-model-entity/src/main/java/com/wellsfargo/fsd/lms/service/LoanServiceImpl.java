package com.wellsfargo.fsd.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.lms.dao.LoanDao;
import com.wellsfargo.fsd.lms.entity.LoanEntity;
import com.wellsfargo.fsd.lms.exception.LoanException;
import com.wellsfargo.fsd.lms.model.LoanModel;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanDao loanRepo;
	
	
	private LoanEntity toEntity(LoanModel model) {
		return new LoanEntity(model.getLoanId(),model.getPrincipal(),
				model.getRateOfInterest(),model.getEmiCount(),model.getDateOfDisbursment(),
				model.getStatus());
	}
	
	private LoanModel toModel(LoanEntity entity) {
		return new LoanModel(entity.getLoanId(),entity.getPrincipal(),
				entity.getRateOfInterest(),entity.getEmiCount(),entity.getDateOfDisbursment(),
				entity.getStatus());
	}
	
	@Override
	@Transactional
	public LoanModel add(LoanModel loan) throws LoanException {
		if(loan!=null) {
			if(loanRepo.existsById(loan.getLoanId())) {
				throw new LoanException("Loan Id already used!");
			}
			
			loan = toModel(loanRepo.save(toEntity(loan)));
		}
		return loan;
	}

	@Override
	@Transactional
	public LoanModel save(LoanModel loan) throws LoanException {
		if(loan!=null) {
			if(!loanRepo.existsById(loan.getLoanId())) {
				throw new LoanException("Loan Not Found");
			}
			
			loan = toModel(loanRepo.save(toEntity(loan)));
		}
		return loan;
	}

	@Override
	@Transactional
	public boolean deleteLoan(int loanId) throws LoanException {
		if(!loanRepo.existsById(loanId)) {
			throw new LoanException("Loan Not Found");
		}
		
		loanRepo.deleteById(loanId);
		return true;
	}

	@Override
	public LoanModel getLoan(int loanId) {
		LoanEntity entity = loanRepo.findById(loanId).orElse(null);
		return entity!=null?toModel(entity):null;
	}

	@Override
	public List<LoanModel> getAllLoans() {
		List<LoanEntity> entities = loanRepo.findAll();
		List<LoanModel> models = null;
		if(entities!=null && !entities.isEmpty()) {
			models = entities.stream().map(e -> toModel(e)).collect(Collectors.toList());
			/*models = new ArrayList<>();
			for(LoanEntity e : entities) {
				models.add(toModel(e));
			}*/
		}
		return models;
	}
}
