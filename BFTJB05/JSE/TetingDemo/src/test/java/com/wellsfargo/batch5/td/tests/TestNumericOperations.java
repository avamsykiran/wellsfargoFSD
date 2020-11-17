package com.wellsfargo.batch5.td.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.wellsfargo.batch5.td.service.NumericOperations;

public class TestNumericOperations {

	NumericOperations nobj;
	
	@BeforeEach
	void setUp() {
		nobj = new NumericOperations();
	}
	
	@AfterEach
	void tearDown() {
		nobj=null;
	}
	
	@Test
	void isOddPositiveCaseTest() {		
		int testData = 45;		
		Assertions.assertTrue(nobj.isOdd(testData));
	}
	
	@Test
	void isOddNegativeCaseTest() {		
		int testData = 44;		
		Assertions.assertFalse(nobj.isOdd(testData));
	}
	
	@Test
	void isOddGivenZeroTest() {		
		int testData = 0;		
		Assertions.assertThrows(ArithmeticException.class, 
				()->{nobj.isOdd(testData);}, 
				() -> "When Zero is given ArithmeticException is expected!");
	}
	
	@Test
	void getFactorsGivenANonPrimeTest() {
		int testData = 12;
		Integer[] expected = new Integer[] {1,2,3,4,6,12};
		Integer[] actual = nobj.getFactors(testData).toArray(new Integer[] {});
		Assertions.assertArrayEquals(expected, actual);
	}
	
	@Test
	void getFactorsGivenAPrimeTest() {
		int testData = 11;
		Integer[] expected = new Integer[] {1,11};
		Integer[] actual = nobj.getFactors(testData).toArray(new Integer[] {});
		Assertions.assertArrayEquals(expected, actual);
	}
}
