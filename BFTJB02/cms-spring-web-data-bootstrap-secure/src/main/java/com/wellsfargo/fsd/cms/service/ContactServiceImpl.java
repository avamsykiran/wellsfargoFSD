package com.wellsfargo.fsd.cms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.cms.dao.ContactRepository;
import com.wellsfargo.fsd.cms.entity.Contact;
import com.wellsfargo.fsd.cms.exception.ContactException;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;

	@Override
	@Transactional
	public Contact add(Contact contact) throws ContactException {
		if (contact != null) {
			if (contactRepo.existsById(contact.getContactId())) {
				throw new ContactException("Contact Id is already in use");
			}
			
			if (contactRepo.existsByMobile(contact.getMobile())) {
				throw new ContactException("Mobile is already in use");
			}

			contactRepo.save(contact);
		}
		return contact;
	}

	@Override
	@Transactional
	public Contact save(Contact contact) throws ContactException {
		if (contact != null) {
			if (!contactRepo.existsById(contact.getContactId())) {
				throw new ContactException("Contact Id is not found");
			}

			contactRepo.save(contact);
		}
		return contact;
	}

	@Override
	@Transactional
	public boolean deleteContact(int contactId) throws ContactException {
		if (!contactRepo.existsById(contactId)) {
			throw new ContactException("Contact Id is not found");
		}
		
		contactRepo.deleteById(contactId);
		return true;
	}

	@Override
	public Contact getContact(int contactId) throws ContactException {
		return contactRepo.findById(contactId).orElse(null);
	}

	@Override
	public List<Contact> getAllContacts() throws ContactException {
		return contactRepo.findAll();
	}

}
