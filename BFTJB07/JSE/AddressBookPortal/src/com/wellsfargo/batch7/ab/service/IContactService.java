package com.wellsfargo.batch7.ab.service;

import java.util.List;

import com.wellsfargo.batch7.ab.exception.AddressBookException;
import com.wellsfargo.batch7.ab.model.Contact;

public interface IContactService {

	Contact add(Contact contact) throws AddressBookException;
	Contact save(Contact contact) throws AddressBookException;
	void delete(int contactId) throws AddressBookException;
	Contact getById(int contactId) throws AddressBookException;
	List<Contact> getAll() throws AddressBookException;
}
