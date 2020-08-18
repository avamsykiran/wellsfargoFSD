package com.wellsfargo.fsd.cms.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.cms.dao.ContactDao;
import com.wellsfargo.fsd.cms.dao.ContactDaoJdbcImpl;
import com.wellsfargo.fsd.cms.entity.Contact;
import com.wellsfargo.fsd.cms.exception.ContactException;

public class ContactServiceImpl implements ContactService {

	private ContactDao contactDao;
	
	public ContactServiceImpl() {
		contactDao = new ContactDaoJdbcImpl();
	}
	
	private boolean isValidContactID(Integer contactId) {
		return contactId!=null && contactId>0; 
	}
	
	private boolean isValidFullName(String fullName) {
		return fullName!=null && (fullName.length()>=3 || fullName.length()<=20);
	}
	
	private boolean isValidDateOfBirth(LocalDate dob) {
		return dob!=null && (!dob.isAfter(LocalDate.now()));
	} 
	
	private boolean isValidMobile(String mobile) {				
		return mobile!=null && mobile.matches("[1-9][0-9]{9}");
	}
	
	public boolean isValidContact(Contact contact) throws ContactException {
		List<String> errMsgs = new ArrayList<>();
		boolean isValid=true;
		
		if(contact!=null) {
			if(!isValidContactID(contact.getContactId())) {
				isValid=false;
				errMsgs.add("Contact id can not left blank and must be a positive number, Duplicates are not allowed");
			}
			if(!isValidFullName(contact.getFullName())) {
				isValid=false;
				errMsgs.add("Full name can not left blank and must be of 3 to 20 in length");
			}
			if(!isValidDateOfBirth(contact.getDateOfBirth())) {
				isValid=false;
				errMsgs.add("Date Of Birth can not be left blank and must be a past date");
			}
			if(!isValidMobile(contact.getMobile())) {
				isValid=false;
				errMsgs.add("Mobiel Number can not be left blank and must be of 10 digits only");
			}
			
			if(!errMsgs.isEmpty()) {
				throw new ContactException("Invalid Contact: "+errMsgs);
			}
		}else {
			isValid=false;
			throw new ContactException("Contact details are not supplied");
		}
		
		return isValid;
	}
	
	@Override
	public Contact validateAndAdd(Contact contact) throws ContactException {
		if(isValidContact(contact)) {
			contactDao.add(contact);
		}
		return contact;
	}

	@Override
	public Contact validateAndSave(Contact contact) throws ContactException {
		if(isValidContact(contact)) {
			contactDao.save(contact);
		}
		return contact;
	}

	@Override
	public boolean deleteContact(int contactId) throws ContactException {
		return contactDao.deleteById(contactId);
	}

	@Override
	public Contact getContact(int contactId) throws ContactException {
		return contactDao.getById(contactId);
	}

	@Override
	public List<Contact> getAllContacts() throws ContactException {
		return contactDao.getAll();
	}

}
