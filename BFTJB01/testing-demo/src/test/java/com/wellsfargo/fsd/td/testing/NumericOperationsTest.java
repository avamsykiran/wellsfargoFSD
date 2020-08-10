package com.wellsfargo.fsd.td.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.rules.ExpectedException;

import com.wellsfargo.fsd.td.service.NumericOperations;

public class NumericOperationsTest {
	
	NumericOperations numOpt;
			
	@BeforeEach
	void init() {
		numOpt = new NumericOperations();
	}
	
	@AfterEach
	void cleanUp() {
		numOpt=null;		
	}
	
	@Test
	@DisplayName("Testing isPrime method for prime numbers to return true")
	@Disabled
	void isPrimTest_forPrimes() {
		assertTrue(numOpt.isPrime(7));
		assertTrue(numOpt.isPrime(11));
		assertTrue(numOpt.isPrime(13));		
	}
	
	@Test
	@DisplayName("Testing isPrime method for non prime numbers to return false")
	@Disabled
	void isPrimTest_forNonPrimes() {		
		assertFalse(numOpt.isPrime(8));
		assertFalse(numOpt.isPrime(10));
		assertFalse(numOpt.isPrime(1024));
	}
		
	@ParameterizedTest
	@ValueSource(ints = {7,11,13,107,97})
	@DisplayName("Testing isPrime method for prime numbers to return true (PARAMED)")
	@Disabled
	void isPrimTest_forPrimes2(int number) {
		assertTrue(numOpt.isPrime(number));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {8,10,20,22,32,42})
	@DisplayName("Testing isPrime method for non prime numbers to return false (PARAMED)")
	@Disabled
	void isPrimTest_forNonPrimes2(int number) {
		assertFalse(numOpt.isPrime(number));
	}
	
	@ParameterizedTest
	@CsvSource(value = {"7:true","8:false","11:true","12:false"},delimiter =':')
	void isPrimeTest(int number,boolean expected) {
		assertEquals(expected, numOpt.isPrime(number));
	}
	
	@ParameterizedTest    
    @CsvSource(value= {"2:false","3:true","7:true","-7:true","-2:false","-3:true"},delimiter=':')
    void isOddTest(int number , boolean expected ) {
        assertEquals(expected, numOpt.isOdd(number));
    }
	
	@Test
	void getFactorsTest() {
		int testData = 25;
		List<Integer> expected = Arrays.asList(new Integer[] {1,5,25});
		List<Integer> actual = numOpt.getFactors(testData);		
		//assertEquals(expected, actual);
		assertIterableEquals(expected, actual);
	}
}
