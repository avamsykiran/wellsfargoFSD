package com.wellsfargo.batch5.sbwdd.exception;

import java.util.List;

import org.springframework.validation.ObjectError;

public class LibraryException extends Exception {
	public LibraryException(String message) {
		super(message);
	}	
}