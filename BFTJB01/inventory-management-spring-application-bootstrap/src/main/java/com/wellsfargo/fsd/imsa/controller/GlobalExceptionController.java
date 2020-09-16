package com.wellsfargo.fsd.imsa.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.fsd.imsa.exception.ImsException;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(ImsException.class)
	public ModelAndView handleImsException(ImsException exception) {
		return new ModelAndView("errPage","errMsg",exception.getMessage());
	}
}
