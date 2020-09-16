package com.wellsfargo.fsd.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.fsd.lms.entity.Loan;
import com.wellsfargo.fsd.lms.exception.LoanException;
import com.wellsfargo.fsd.lms.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanRestController {

	@Autowired
	private LoanService loanService;
	
	@GetMapping
	public ResponseEntity<List<Loan>> getAllLoans(){
		return new ResponseEntity<List<Loan>>(loanService.getAllLoans(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Loan> getLoans(@PathVariable("id")int loanId){
		ResponseEntity<Loan> resp=null;
		
		Loan loan = loanService.getLoan(loanId);
		
		if(loan!=null) {
			resp =new ResponseEntity<>(loan,HttpStatus.OK);
		}else {
			resp =new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return resp;
	}
	
	@PostMapping
	public ResponseEntity<Loan> createLoan(@RequestBody @Valid Loan loan,BindingResult result) throws LoanException{
		if(result.hasErrors()) {
			throw new LoanException(GlobalExceptionController.errMsgFrom(result));
		}
		return new ResponseEntity<>(loanService.add(loan),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Loan> modifyLoan(@RequestBody @Valid Loan loan,BindingResult result) throws LoanException{
		if(result.hasErrors()) {
			throw new LoanException(GlobalExceptionController.errMsgFrom(result));
		}
		return new ResponseEntity<>(loanService.save(loan),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLoan(@PathVariable("id")int loanId) throws LoanException{
		loanService.deleteLoan(loanId);		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
