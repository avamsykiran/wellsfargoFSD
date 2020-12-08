package com.wellsfargo.batch7.sbwdd.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch7.sbwdd.exception.AddressBookException;
import com.wellsfargo.batch7.sbwdd.model.AddressGroupModel;
import com.wellsfargo.batch7.sbwdd.repo.AddressGroupRepo;
import com.wellsfargo.batch7.sbwdd.util.EMParser;

@Service
public class AddressGroupServiceImpl implements AddressGroupService{
	
	@Autowired
	private AddressGroupRepo agRepo;

	@Transactional
	@Override
	public AddressGroupModel add(AddressGroupModel addressGroup) throws AddressBookException {
		if(addressGroup!=null) {
			if(agRepo.existsById(addressGroup.getGroupId())) {
				throw new AddressBookException("AddressGroup#"+addressGroup.getGroupId()+" already exists");
			}
			addressGroup = EMParser.parse(agRepo.save(EMParser.parse(addressGroup)));
		}
		return addressGroup;
	}

	@Transactional
	@Override
	public void delete(int groupId) throws AddressBookException {
		if(!agRepo.existsById(groupId)) {
			throw new AddressBookException("AddressGroup#"+groupId+" does not exists");
		}
		agRepo.deleteById(groupId);		
	}

	@Override
	public AddressGroupModel get(int groupId) throws AddressBookException {
		if(!agRepo.existsById(groupId)) {
			throw new AddressBookException("AddressGroup#"+groupId+" does not exists");
		}
		return EMParser.parse(agRepo.findById(groupId).get());
	}

	@Override
	public List<AddressGroupModel> getAll() throws AddressBookException {
		return agRepo.findAll().stream().map(e -> EMParser.parse(e)).collect(Collectors.toList());
	}

}
