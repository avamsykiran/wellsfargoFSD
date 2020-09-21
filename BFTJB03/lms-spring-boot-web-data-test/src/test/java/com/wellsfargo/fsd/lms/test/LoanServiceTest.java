package com.wellsfargo.fsd.lms.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoanServiceTest {

	@TestConfiguration
	static class MyConfig{
		@Bean
		public LoanService loanService() {
			return new LoanServiceImpl();
		}
	}
	
	@MockBean
	private LoanDao loanDao;
	
	@Autowired
	private LoanService loanService;
	
	@Test
	public void whenAdd_givenNonExistingRecord_thenReturnThatRecord() throws LoanException {

		Loan loan = new Loan(201, 50000.0, 0.12, 3, LocalDate.now(), "APPROVED");
		
		Mockito.when(loanDao.existsById(loan.getLoanId())).thenReturn(false);
		Mockito.when(loanDao.save(loan)).thenReturn(loan);
		
		assertEquals(loan,loanService.add(loan));
	}

	@Test
	public void whenAdd_givenExistingRecord_thenThrowLoanException() {

		Loan loan = new Loan(201, 50000.0, 0.12, 3, LocalDate.now(), "APPROVED");
		
		Mockito.when(loanDao.existsById(loan.getLoanId())).thenReturn(true);
				
		assertThrows(LoanException.class, ()->{loanService.add(loan);});
	}

}
