package com.wellsfargo.batch5.td.service;

import com.wellsfargo.batch5.td.exception.TextException;

public class TextOperations {

	public boolean isPallendrome(String text) throws TextException {
		if(text==null) {
			throw new TextException("Nulls are not legal args");
		}
		text = text.toLowerCase();		
		String textRev = getReverse(text);		
		return textRev.equals(text);
	}
	
	public String getReverse(String text) {
		String result =null;
		if(text!=null) {
			result = new StringBuilder(text).reverse().toString();
		}
		return result;
	}
	
	public String[] getWords(String text) {
		return text.split(" "); 
	}
}
