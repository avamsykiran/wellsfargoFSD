package com.wellsfargo.batch5.sbwdd.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wellsfargo.batch5.sbwdd.exception.LibraryException;

@RestControllerAdvice
public class ExceptionApi {
	
	public static String toErrMsg(List<ObjectError> allErrors) {
		StringBuilder sb = new StringBuilder();
		for(ObjectError err:allErrors) {
			sb.append(err.getDefaultMessage() + ",");
		}
		return sb.toString();
	}

	@ExceptionHandler(LibraryException.class)
	public ResponseEntity<String> handleLibraryException(LibraryException exp){
		return new ResponseEntity(exp.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleOtherException(LibraryException exp){
		return new ResponseEntity(exp.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
