package com.wellsfargo.scd.service;

public class GreetServiceImpl implements GreetService {

	public String doGreet(String userName) {
		return "Hello! " + userName;
	}

}
