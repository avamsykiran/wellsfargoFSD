package com.wellsfargo.batch7.sbwdd.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wellsfargo.batch7.sbwdd.exception.AddressBookException;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(AddressBookException.class)
	public ResponseEntity<String> handle(AddressBookException exp){
		return new ResponseEntity<>(exp.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handle(Exception exp){
		return new ResponseEntity<>(exp.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static String from(BindingResult result) {
		StringBuilder sb = new StringBuilder();
		
		for(ObjectError err : result.getAllErrors()) {
			sb.append(err.getDefaultMessage()+",");
		}
		
		return sb.toString();
	} 
}
