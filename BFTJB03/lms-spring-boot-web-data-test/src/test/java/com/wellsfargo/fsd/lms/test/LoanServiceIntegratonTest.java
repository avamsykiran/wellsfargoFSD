package com.wellsfargo.fsd.lms.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.wellsfargo.fsd.lms.dao.LoanDao;
import com.wellsfargo.fsd.lms.entity.Loan;
import com.wellsfargo.fsd.lms.exception.LoanException;
import com.wellsfargo.fsd.lms.service.LoanService;
import com.wellsfargo.fsd.lms.service.LoanServiceImpl;

@SpringJUnitConfig
@SpringBootTest
public class LoanServiceIntegratonTest {
	
	@Autowired
	private LoanDao loanDao;
	
	@Autowired
	private LoanService loanService;
	
	private Loan[] testData;
	
	@BeforeEach
	public void setUp(){
		testData = new Loan[] {
				new Loan(101, 15000.0, 0.1, 2, LocalDate.now(), "APPROVED"),
				new Loan(102, 15000.0, 0.1, 2, LocalDate.now(), "CLOSED"),
		};
		
		for(Loan l : testData) {
			loanDao.saveAndFlush(l);
		}
	}
	
	@AfterEach
	public void tearDown(){
		loanDao.deleteAll();
		testData=null;
	}
	
	@Test
	public void whenAdd_givenNonExistingRecord_thenReturnThatRecord() throws LoanException {
		Loan loan = new Loan(201, 50000.0, 0.12, 3, LocalDate.now(), "APPROVED");
		assertEquals(loan,loanService.add(loan));
	}

	@Test
	public void whenAdd_givenExistingRecord_thenThrowLoanException() {
		Loan loan = testData[0];		
		assertThrows(LoanException.class, ()->{loanService.add(loan);});
	}

}
