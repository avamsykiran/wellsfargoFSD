package com.wellsfargo.fsd.lms.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.wellsfargo.fsd.lms.dao.LoanDao;
import com.wellsfargo.fsd.lms.entity.Loan;

@DataJpaTest
public class LoanRepoTest {

	@Autowired
	private LoanDao loanRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	private Loan[] testData;
	
	@BeforeEach
	public void setUp(){
		testData = new Loan[] {
				new Loan(101, 15000.0, 0.1, 2, LocalDate.now(), "APPROVED"),
				new Loan(102, 15000.0, 0.1, 2, LocalDate.now(), "CLOSED"),
		};
		
		for(Loan l : testData) {
			entityManager.persistAndFlush(l);
		}
	}
	
	@AfterEach
	public void tearDown(){
		for(Loan l : testData) {
			entityManager.remove(l);
		}
		entityManager.flush();
		testData=null;
	}
	
	@Test
	public void whenFindAllByStatus_givenExistingStatus_thenReturnListOfMAtchingLoans() {
		List<Loan> actual = loanRepo.findAllByStatus(testData[0].getStatus());
		Loan expected = testData[0];
		assertEquals(expected.getLoanId(), actual.get(0).getLoanId());
	}
}
