package com.wellsfargo.batch5.iocdemo.serivce;

public class GreetServiceImpl implements IGreetService {

	public String getGreeting(String userName) {
		return "Hello "+userName;
	}
	
}
