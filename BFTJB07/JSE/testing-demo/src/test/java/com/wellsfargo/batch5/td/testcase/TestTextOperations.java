package com.wellsfargo.batch5.td.testcase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.wellsfargo.batch5.td.exception.TextException;
import com.wellsfargo.batch5.td.service.TextOperations;

public class TestTextOperations {
	TextOperations tObj;
	
	@BeforeEach
	void setUp(){
		tObj = new TextOperations();
	}
	
	@AfterEach
	void tearDown() {
		tObj=null;
	}
	
	@Test
	void testIsPallendromeGivenAPallendromeInput() throws TextException {		
		String testData = "malayalam";
		Assertions.assertTrue(tObj.isPallendrome(testData));
	}
	
	@Test
	void testIsPallendromeGivenANonPallendromeInput() throws TextException {		
		String testData = "marathi";
		Assertions.assertFalse(tObj.isPallendrome(testData));
	}

	@Test
	void testIsPallendromeGivenNullInput() {		
		String testData = null;
		Assertions.assertThrows(
				TextException.class,
				()->{tObj.isPallendrome(testData);});
	}

	@Test
	void testGetReverse() {
		String testData = "PEN";
		String expected = "NEP";
		String actual = tObj.getReverse(testData);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void testGetReverseGivenNull() {
		String testData = null;		
		String actual = tObj.getReverse(testData);
		Assertions.assertNull(actual);
	}
	
	@Test
	void testGetWords() {
		String testData = "this is a sentence";
		String expected[] = new String[] {"this","is","a","sentence"};
		String actual[] = tObj.getWords(testData);
		Assertions.assertArrayEquals(expected, actual);
	}
	
	
}
