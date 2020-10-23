package com.wellsfargo.batch7.ab.dao;

import java.util.List;

import com.wellsfargo.batch7.ab.dto.Contact;
import com.wellsfargo.batch7.ab.exception.AddressBookException;

public interface IContactDao {

	Contact add(Contact contact) throws AddressBookException;
	Contact save(Contact contact) throws AddressBookException;
	void delete(int contactId) throws AddressBookException;
	Contact getById(int contactId) throws AddressBookException;
	List<Contact> getAll() throws AddressBookException;
}
