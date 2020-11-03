package com.wellsfargo.batch7.ab.service;

import com.wellsfargo.batch7.ab.dao.AdbUserDaoImpl;
import com.wellsfargo.batch7.ab.dao.IAdbUserDao;
import com.wellsfargo.batch7.ab.exception.AddressBookException;
import com.wellsfargo.batch7.ab.model.AdbUser;

public class AdbUserServiceImpl implements IAdbUserService{

	private IAdbUserDao adbUserDao;
	
	public AdbUserServiceImpl() {
		this.adbUserDao=new AdbUserDaoImpl();
	}
	
	@Override
	public AdbUser authenticate(String userName, String password) throws AddressBookException {
		AdbUser user = adbUserDao.getUser(userName);
		if(user==null || !password.equals(user.getPassword())) {
			throw new AddressBookException("Invalid User Credits");
		}
		return user;
	}

	@Override
	public AdbUser createUser(AdbUser user) throws AddressBookException {
		if(user!=null) {
			adbUserDao.addUser(user);
		}
		return user;
	}

}
