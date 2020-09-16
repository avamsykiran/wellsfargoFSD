package com.wellsfargo.fsd.lms.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class LoanException extends Exception {

	public LoanException(String errMsg) {
		super(errMsg);
	}

}
