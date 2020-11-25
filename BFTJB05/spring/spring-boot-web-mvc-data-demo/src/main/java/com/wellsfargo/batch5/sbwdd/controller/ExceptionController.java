package com.wellsfargo.batch5.sbwdd.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch5.sbwdd.exception.LibraryException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(LibraryException.class)
	public ModelAndView libraryExceptionAction(LibraryException exp) {
		return new ModelAndView("error-page","errMsg",exp.getMessage());
	}
}
