package com.wellsfargo.batch7.ab.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.batch7.ab.dao.ContactDaoImpl;
import com.wellsfargo.batch7.ab.dao.IContactDao;
import com.wellsfargo.batch7.ab.exception.AddressBookException;
import com.wellsfargo.batch7.ab.model.Contact;

public class ContactServiceImpl implements IContactService{
	
	private IContactDao contactDao;
	
	public ContactServiceImpl() {
		this.contactDao=new ContactDaoImpl();
	}

	private boolean isValidContact(Contact contact) throws AddressBookException {
		boolean isValid=true;
		List<String> errMsgs = new ArrayList<String>(); 
		
		if(contact.getContactId()<=0) {
			errMsgs.add("Contact Id can not be negative");
		}
		
		if(contact.getName()==null || contact.getName().length()<4 || contact.getName().length()>20) {
			errMsgs.add("Name is manditory and must be of 4 to 20 chars in lenght");
		}
		
		if(contact.getGroup()==null || contact.getGroup().length()<4 || contact.getGroup().length()>20) {
			errMsgs.add("Grou[ is manditory and must be of 4 to 20 chars in lenght");
		}
		
		if(contact.getMobile()==null || !contact.getMobile().matches("[1-9][0-9]{9}")) {
			errMsgs.add("Mobile is manditory and must be of 10 digits only");
		}
		
		if(LocalDate.now().isBefore(contact.getDateOfBirth())) {
			errMsgs.add("Date Of Birth must be a past date");
		}
		
		if(errMsgs.isEmpty()) {
			isValid=true;			
		}else {
			isValid=false;
			throw new AddressBookException(errMsgs.toString());
		}
		
		return isValid;
	}
	
	@Override
	public Contact add(Contact contact) throws AddressBookException {
		if(contact!=null) {
			if(isValidContact(contact)) {
				contactDao.add(contact);
			}
		}
		return contact;
	}

	@Override
	public Contact save(Contact contact) throws AddressBookException {
		if(contact!=null) {
			if(isValidContact(contact)) {
				contactDao.save(contact);
			}
		}
		return contact;
	}

	@Override
	public void delete(int contactId) throws AddressBookException {
		contactDao.delete(contactId);		
	}

	@Override
	public Contact getById(int contactId) throws AddressBookException {
		return contactDao.getById(contactId);
	}

	@Override
	public List<Contact> getAll() throws AddressBookException {
		return contactDao.getAll();
	}

}
