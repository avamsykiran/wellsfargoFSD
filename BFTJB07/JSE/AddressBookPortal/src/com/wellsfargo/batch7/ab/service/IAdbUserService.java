package com.wellsfargo.batch7.ab.service;

import com.wellsfargo.batch7.ab.exception.AddressBookException;
import com.wellsfargo.batch7.ab.model.AdbUser;

public interface IAdbUserService {

	AdbUser authenticate(String userName,String password) throws AddressBookException;
	AdbUser createUser(AdbUser user)throws AddressBookException;
}
