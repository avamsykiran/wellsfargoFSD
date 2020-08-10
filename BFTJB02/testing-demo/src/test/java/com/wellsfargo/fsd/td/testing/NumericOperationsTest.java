package com.wellsfargo.fsd.td.testing;

import static org.junit.jupiter.api.Assertions.*;

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
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.wellsfargo.fsd.td.service.NumericOperations;

public class NumericOperationsTest {

	NumericOperations numOpt;

	@BeforeEach
	void init() {
		numOpt = new NumericOperations();
	}

	@AfterEach
	void clean() {
		numOpt = null;
	}

	@Test
	@DisplayName("testing isOdd method")
	@Disabled
	void isOddTest() {
		assertTrue(numOpt.isOdd(-9), "-9 is expected to be odd but failed");
		assertFalse(numOpt.isOdd(-8), "-8 is expected to be even but failed");

		assertFalse(numOpt.isOdd(0), "0 is expected to be even but failed");

		assertTrue(numOpt.isOdd(9), "9 is expected to be odd but failed");
		assertFalse(numOpt.isOdd(8), "8 is expected to be even but failed");

	}

	@ParameterizedTest
	@ValueSource(ints = { -9, 9 })
	@DisplayName("testing isOdd method using params for ODDS")
	void isOddTest2(int testdata) {
		assertTrue(numOpt.isOdd(testdata), testdata + " is expected to be odd but failed");
	}

	@ParameterizedTest
	@ValueSource(ints = { -8, 0, 8 })
	@DisplayName("testing isOdd method using params for EVENS")
	void isOddTest3(int testdata) {
		assertFalse(numOpt.isOdd(testdata), testdata + " is expected to be even but failed");
	}

	@ParameterizedTest
	@CsvSource(value = { "-9,-9,-9", "-9,0,0", "-9,9,9", "9,-9,9", "0,9,9", "9,0,9" })
	void maxTest(int testdata1, int testdata2, int expected) {
		assertEquals(expected, numOpt.max(testdata1, testdata2));
	}
	
	@ParameterizedTest
	@MethodSource
	void maxTest2(int testdata1, int testdata2, int expected) {
		assertEquals(expected, numOpt.max(testdata1, testdata2));
	}

	static Stream<Arguments> maxTest2() {
		return Stream.of(
				Arguments.of(-9,-9,-9),
				Arguments.of(-9,0,0),
				Arguments.of(-9,9,9),
				Arguments.of(9,-9,9),
				Arguments.of(0,9,9)
				);
	}
	
	@ParameterizedTest
	@MethodSource	
	void getFactorsTest(int number, List<Integer> expected) {
		List<Integer> actual = numOpt.getFactors(number);
		assertIterableEquals(expected, actual);
	}

	static Stream<Arguments> getFactorsTest() {
		return Stream.of(
				Arguments.of(25, Arrays.asList(new Integer[] { 1, 5, 25 })),
				Arguments.of(0, Arrays.asList(new Integer[] { 1, 0 })),
				Arguments.of(11, Arrays.asList(new Integer[] { 1, 11 }))
		);
	}
}
