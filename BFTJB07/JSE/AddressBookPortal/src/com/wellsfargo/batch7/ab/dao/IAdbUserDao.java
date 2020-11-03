package com.wellsfargo.batch7.ab.dao;

import com.wellsfargo.batch7.ab.exception.AddressBookException;
import com.wellsfargo.batch7.ab.model.AdbUser;

public interface IAdbUserDao {

	AdbUser getUser(String userName) throws AddressBookException;
	AdbUser addUser(AdbUser user) throws AddressBookException;
}
