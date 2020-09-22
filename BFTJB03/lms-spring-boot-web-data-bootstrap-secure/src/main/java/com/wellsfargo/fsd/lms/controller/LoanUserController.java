package com.wellsfargo.fsd.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.lms.service.LoanService;

@Controller
@RequestMapping("/user")
public class LoanUserController {

	@Autowired
	private LoanService loanService;
	
	@GetMapping("/list")
	public ModelAndView doDisplayLoans() {
		return new ModelAndView("loanListPage","loans", loanService.getAllLoans());
	}
	
	
}
