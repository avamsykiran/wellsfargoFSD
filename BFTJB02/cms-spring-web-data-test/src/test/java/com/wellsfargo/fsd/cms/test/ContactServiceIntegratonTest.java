package com.wellsfargo.fsd.cms.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.Month;

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

import com.wellsfargo.fsd.cms.dao.ContactRepository;
import com.wellsfargo.fsd.cms.entity.Contact;
import com.wellsfargo.fsd.cms.exception.ContactException;
import com.wellsfargo.fsd.cms.service.ContactService;
import com.wellsfargo.fsd.cms.service.ContactServiceImpl;

@SpringJUnitConfig
@SpringBootTest
public class ContactServiceIntegratonTest {

	@Autowired
	private ContactRepository contactRepo;
	
	@Autowired
	private ContactService contactService;
	
	private Contact[] testData;
	
	@BeforeEach
	public void setUp() {
		testData = new Contact[] {
				new Contact(101,"Vamsy",LocalDate.of(1985, Month.JUNE, 11),"9052224753","FAMILY",true),
				new Contact(102,"Kiran",LocalDate.of(1985, Month.JUNE, 12),"9052224754","FAMILY",true),
				new Contact(103,"Vamsy Kiran",LocalDate.of(1985, Month.JUNE, 13),"9052224755","FAMILY",true)
		};
		
		for(Contact c : testData) {
			contactRepo.saveAndFlush(c);
		}
	}
	
	@AfterEach
	public void tearDown() {
		contactRepo.deleteAll();		
		testData=null;
	}
	
	@Test
	public void whenAdd_givenNewContact_shouldReturnThatContact() throws ContactException {
		Contact contact = new Contact(201,"Vamsy",LocalDate.now(),"9052224770","FAMILY",true);
		
		assertEquals(contactService.add(contact), contact);
	}
	
	@Test
	public void whenAdd_givenExistingContact_shouldReturnThatContact() {
		Contact contact = testData[0];						
		assertThrows(ContactException.class,()->{contactService.add(contact);});
	}
}
