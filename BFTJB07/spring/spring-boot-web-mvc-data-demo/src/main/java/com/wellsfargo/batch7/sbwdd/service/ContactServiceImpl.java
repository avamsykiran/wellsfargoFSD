package com.wellsfargo.batch7.sbwdd.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch7.sbwdd.exception.AddressBookException;
import com.wellsfargo.batch7.sbwdd.model.AddressGroupModel;
import com.wellsfargo.batch7.sbwdd.model.ContactModel;
import com.wellsfargo.batch7.sbwdd.repo.ContactRepo;
import com.wellsfargo.batch7.sbwdd.util.EMParser;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepo contactRepo;
	
	@Transactional
	@Override
	public ContactModel add(ContactModel contact) throws AddressBookException {
		if(contact!=null) {
			if(contactRepo.existsById(contact.getContactId())) {
				throw new AddressBookException("Contact#"+contact.getContactId()+" already exists");
			}
			contact = EMParser.parse(contactRepo.save(EMParser.parse(contact)));
		}
		return contact;
	}

	@Transactional
	@Override
	public ContactModel update(ContactModel contact) throws AddressBookException {
		if(contact!=null) {
			if(!contactRepo.existsById(contact.getContactId())) {
				throw new AddressBookException("Contact#"+contact.getContactId()+" does not exists");
			}
			contact = EMParser.parse(contactRepo.save(EMParser.parse(contact)));
		}
		return contact;
	}
	
	@Transactional
	@Override
	public void delete(long cId) throws AddressBookException {
		if(!contactRepo.existsById(cId)) {
			throw new AddressBookException("Contact#"+cId+" does not exists");
		}
		contactRepo.deleteById(cId);
	}

	@Override
	public ContactModel get(long cId) throws AddressBookException {
		if(!contactRepo.existsById(cId)) {
			throw new AddressBookException("Contact#"+cId+" does not exists");
		}

		return EMParser.parse(contactRepo.findById(cId).get());
	}

	@Override
	public List<ContactModel> getAll() throws AddressBookException {
		return contactRepo.findAll().stream().map(e->EMParser.parse(e)).collect(Collectors.toList());
	}

	@Override
	public List<ContactModel> getAllByGroup(AddressGroupModel group) throws AddressBookException {
		return contactRepo.findAllByAdbGroup(EMParser.parse(group))
				.stream().map(e->EMParser.parse(e)).collect(Collectors.toList());
	}

}
