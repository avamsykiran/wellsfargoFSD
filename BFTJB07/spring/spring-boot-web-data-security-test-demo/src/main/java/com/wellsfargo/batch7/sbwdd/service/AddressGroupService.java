package com.wellsfargo.batch7.sbwdd.service;

import java.util.List;

import com.wellsfargo.batch7.sbwdd.exception.AddressBookException;
import com.wellsfargo.batch7.sbwdd.model.AddressGroupModel;

public interface AddressGroupService {

	AddressGroupModel add(AddressGroupModel addressGroup) throws AddressBookException;
	void delete(int groupId) throws AddressBookException;
	AddressGroupModel get(int groupId) throws AddressBookException;	
	List<AddressGroupModel> getAll() throws AddressBookException;	
	
}
