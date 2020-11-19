package com.wellsfargo.batch7.iocdemo.service;

public class GreetServiceSimpleImpl implements IGreetService {

	@Override
	public String getGreeting(String userName) {
		return "Hello "+userName;
	}

}
