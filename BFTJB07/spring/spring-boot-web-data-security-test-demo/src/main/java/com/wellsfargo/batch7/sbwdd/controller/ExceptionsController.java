package com.wellsfargo.batch7.sbwdd.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch7.sbwdd.exception.AddressBookException;

@ControllerAdvice
public class ExceptionsController {

	@ExceptionHandler(AddressBookException.class)
	public ModelAndView handleException(AddressBookException exp) {
		return new ModelAndView("error-page", "errMsg",exp.getMessage());
	}
}
