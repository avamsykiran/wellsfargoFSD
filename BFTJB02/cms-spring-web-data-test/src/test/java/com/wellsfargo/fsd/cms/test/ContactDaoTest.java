package com.wellsfargo.fsd.cms.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.wellsfargo.fsd.cms.dao.ContactRepository;
import com.wellsfargo.fsd.cms.entity.Contact;

@DataJpaTest
public class ContactDaoTest {

	@Autowired
	private ContactRepository contactRepo;
	
	@Autowired
	private TestEntityManager entityManager;	
	
	private Contact[] testData;
	
	@BeforeEach
	public void setUp() {
		testData = new Contact[] {
				new Contact(101,"Vamsy",LocalDate.of(1985, Month.JUNE, 11),"9052224753","FAMILY",true),
				new Contact(102,"Kiran",LocalDate.of(1985, Month.JUNE, 12),"9052224754","FAMILY",true),
				new Contact(103,"Vamsy Kiran",LocalDate.of(1985, Month.JUNE, 13),"9052224755","FAMILY",true)
		};
		
		for(Contact c : testData) {
			entityManager.persistAndFlush(c);
		}
	}
	
	@AfterEach
	public void tearDown() {
		for(Contact c : testData) {
			entityManager.remove(c);
		}
		entityManager.flush();
		testData=null;
	}
	
	@Test
	public void whenExistsByMobile_givenExisitngMobileNumber_shouldReturnTrue() {
		assertTrue(contactRepo.existsByMobile(testData[0].getMobile()));
	}
}
