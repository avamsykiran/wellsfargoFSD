package com.wellsfargo.fsd.td.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.wellsfargo.fsd.td.exception.MyException;
import com.wellsfargo.fsd.td.service.NumericOperations;

public class NumericOperationsTest {
	
	NumericOperations nopt;
	
	@BeforeEach
	void init() {
		nopt = new NumericOperations();
	}
	
	@AfterEach
	void clean() {
		nopt=null;
	}
	
	@Test
	@DisplayName("isOdd method is being tested")
	@Disabled
	void isOddTest() {	
	
		assertTrue(nopt.isOdd(-9),"-9 expected be odd");
		assertFalse(nopt.isOdd(-18),"-18 expected to be even");
		
		assertFalse(nopt.isOdd(0),"0 expected to be even");
		
		assertTrue(nopt.isOdd(9),"9 expected to be odd");
		assertFalse(nopt.isOdd(18),"18 expected to be even");
	}
	
	@ParameterizedTest	
	@ValueSource(ints= {-9,9})
	@DisplayName("isOdd method is being tested for Odd by passing params")
	@Disabled
	void isOddTest2(int testData) {
		assertTrue(nopt.isOdd(testData), testData +" expected to be odd");		
	}
	
	@ParameterizedTest	
	@ValueSource(ints= {-8,0,8})
	@DisplayName("isOdd method is being tested for Evens by passing params")
	@Disabled
	void isOddTest3(int testData) {
		assertFalse(nopt.isOdd(testData), testData +" expected to be even");		
	}
	
	@ParameterizedTest
	@CsvSource({"-9,true","9,true","0,false","-8,false","8,false"})
	void isOddTest4(int testData,boolean expected) {
		assertEquals(expected,nopt.isOdd(testData));		
	}
	
	@ParameterizedTest
	@CsvSource({"1,1,1","8,2,4","7,2,3","-8,2,-4","0,4,0"})
	void qutTest(int testdata1,int testdata2,int expected) {
		try {
			assertEquals(expected, nopt.qut(testdata1, testdata2));
		} catch (MyException e) {
			fail("Exception not expected");
		}
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = {"/qutTestData.csv"})
	void qutTest2(int testdata1,int testdata2,int expected) {
		try {
			assertEquals(expected, nopt.qut(testdata1, testdata2));
		} catch (MyException e) {
			fail("Exception not expected");
		}
	}
	
	@Test
	void qutTestForException() {
		assertThrows(MyException.class,() ->{ nopt.qut(100, 0);});		
	}
	
	@ParameterizedTest
	@MethodSource
	void qutTest3(int testdata1,int testdata2,int expected) {
		try {
			assertEquals(expected, nopt.qut(testdata1, testdata2));
		} catch (MyException e) {
			fail("Exception not expected");
		}
	}
	
	static Stream<Arguments> qutTest3(){		
		return Stream.of(
				Arguments.of(1,1,1),
				Arguments.of(8,2,4),
				Arguments.of(-8,2,-4)
				);
	}
	
	@ParameterizedTest
	@MethodSource
	void getFactorsTest(int num,List<Integer> expected) {
		assertIterableEquals(expected, nopt.getFactors(num));
	}
	
	static Stream<Arguments> getFactorsTest(){
		return Stream.of(
				Arguments.of(10,Arrays.asList(new Integer[] {1,2,5,10})),
				Arguments.of(25,Arrays.asList(new Integer[] {1,5,25})),
				Arguments.of(0,Arrays.asList(new Integer[] {1,0}))
				);
	}
}
