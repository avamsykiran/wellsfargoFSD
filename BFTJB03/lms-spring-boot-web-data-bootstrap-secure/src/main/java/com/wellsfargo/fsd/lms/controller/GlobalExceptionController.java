package com.wellsfargo.fsd.lms.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.lms.exception.LoanException;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(LoanException.class)
	public ModelAndView handlException(LoanException exp) {
		return new ModelAndView("errPage", "errMsg",exp.getMessage());
	}
}
