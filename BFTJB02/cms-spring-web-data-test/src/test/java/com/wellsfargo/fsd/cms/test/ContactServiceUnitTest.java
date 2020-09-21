package com.wellsfargo.fsd.cms.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

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
public class ContactServiceUnitTest {

	@TestConfiguration
	static class MyTestConfig{
		@Bean
		public ContactService contactService() {
			return new ContactServiceImpl();
		}
	}
	
	@MockBean
	private ContactRepository contactRepo;
	
	@Autowired
	private ContactService contactService;
	
	@Test
	public void whenAdd_givenNewContact_shouldReturnThatContact() throws ContactException {
		Contact contact = new Contact(201,"Vamsy",LocalDate.now(),"905222477","FAMILY",true);
		
		Mockito.when(contactRepo.existsById(contact.getContactId())).thenReturn(false);
		Mockito.when(contactRepo.existsByMobile(contact.getMobile())).thenReturn(false);
		Mockito.when(contactRepo.save(contact)).thenReturn(contact);
		
		assertEquals(contactService.add(contact), contact);
	}
	
	@Test
	public void whenAdd_givenExistingContact_shouldReturnThatContact() {
		Contact contact = new Contact(201,"Vamsy",LocalDate.now(),"905222477","FAMILY",true);
		
		Mockito.when(contactRepo.existsById(contact.getContactId())).thenReturn(true);
		Mockito.when(contactRepo.existsByMobile(contact.getMobile())).thenReturn(true);
				
		assertThrows(ContactException.class,()->{contactService.add(contact);});
	}
}
