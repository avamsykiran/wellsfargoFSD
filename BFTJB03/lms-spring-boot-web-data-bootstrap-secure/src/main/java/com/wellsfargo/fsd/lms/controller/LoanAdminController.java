package com.wellsfargo.fsd.lms.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.lms.entity.Loan;
import com.wellsfargo.fsd.lms.exception.LoanException;
import com.wellsfargo.fsd.lms.service.LoanService;

@Controller
@RequestMapping("/admin")
public class LoanAdminController {

	@Autowired
	private LoanService loanService;
	
	@GetMapping("/list")
	public ModelAndView doDisplayLoans() {
		return new ModelAndView("loanListPage","loans", loanService.getAllLoans());
	}
	
	
	@ModelAttribute("allStatus")
	public List<String> getAllStatus(){
		return Arrays.asList(new String[] {"PENDING","REJECTED","APPROVED","SANCTIONED"});
	}
	
	@GetMapping("/newLoan")
	public ModelAndView showLoanFormToAdd() {
		ModelAndView mv = new ModelAndView("loanFormPage","loan",new Loan());
		mv.addObject("isNew",true);
		return mv;
	}
	
	@GetMapping("/editLoan")
	public ModelAndView showLoanFormToEdit(@RequestParam("id") int loanId) {
		Loan loan = loanService.getLoan(loanId);
		ModelAndView mv = new ModelAndView("loanFormPage","loan",loan);
		mv.addObject("isNew",false);
		return mv;
	}
	
	@PostMapping("/addLoan")
	public ModelAndView doAddLoan(@ModelAttribute("loan") @Valid Loan loan,BindingResult result) throws LoanException {
		ModelAndView mv = null;
		
		if(result.hasErrors()) {
			mv = new ModelAndView("loanFormPage","loan",loan);
			mv.addObject("isNew",true);
		}else {
			loanService.add(loan);
			mv = new ModelAndView("index","msg","Loan is saved successfully");
		}
		
		return mv;
	}
	
	@PostMapping("/saveLoan")
	public ModelAndView doSaveLoan(@ModelAttribute("loan") @Valid Loan loan,BindingResult result) throws LoanException {
		ModelAndView mv = null;
		
		if(result.hasErrors()) {
			mv = new ModelAndView("loanFormPage","loan",loan);
			mv.addObject("isNew",false);
		}else {
			loanService.save(loan);
			mv = new ModelAndView("index","msg","Loan is saved successfully");
		}
		
		return mv;
	}
	
	@GetMapping("/deleteLoan")
	public ModelAndView doDelte(@RequestParam("id") int loanId) throws LoanException {
		loanService.deleteLoan(loanId);
		return new ModelAndView("index","msg","Loan is deleted successfully");
	}
	
}
