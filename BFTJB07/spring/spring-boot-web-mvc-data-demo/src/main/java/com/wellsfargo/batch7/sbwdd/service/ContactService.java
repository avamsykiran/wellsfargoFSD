package com.wellsfargo.batch7.sbwdd.service;

import java.util.List;

import com.wellsfargo.batch7.sbwdd.exception.AddressBookException;
import com.wellsfargo.batch7.sbwdd.model.AddressGroupModel;
import com.wellsfargo.batch7.sbwdd.model.ContactModel;

public interface ContactService {

	ContactModel add(ContactModel contact) throws AddressBookException;
	ContactModel update(ContactModel contact) throws AddressBookException;
	void delete(long cId) throws AddressBookException;
	ContactModel get(long cId) throws AddressBookException;	
	List<ContactModel> getAll() throws AddressBookException;
	List<ContactModel> getAllByGroup(AddressGroupModel group) throws AddressBookException;
	
}
