package com.wellsfargo.scdx.service;

public class GreetServiceImpl implements GreetService{

	public String greet(String userName) {
		return "Hello! " + userName;
	}

}
