package com.wellsfargo.fsd.cms.dao;

import java.util.List;

import com.wellsfargo.fsd.cms.entity.Contact;
import com.wellsfargo.fsd.cms.exception.ContactException;

public interface ContactDao {

	Contact add(Contact contact) throws ContactException;

	Contact save(Contact contact) throws ContactException;

	boolean deleteById(int contactId) throws ContactException;

	Contact getById(int contactId) throws ContactException;

	List<Contact> getAll() throws ContactException;
}
