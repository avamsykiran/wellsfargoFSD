package com.wellsfargo.fsd.cms.service;

import java.util.List;

import com.wellsfargo.fsd.cms.entity.Contact;
import com.wellsfargo.fsd.cms.exception.ContactException;

public interface ContactService {

	Contact validateAndAdd(Contact contact) throws ContactException;
	Contact validateAndSave(Contact contact) throws ContactException;
	
	boolean deleteContact(int contactId) throws ContactException;
	
	Contact getContact(int contactId) throws ContactException;
	List<Contact> getAllContacts() throws ContactException;
}
