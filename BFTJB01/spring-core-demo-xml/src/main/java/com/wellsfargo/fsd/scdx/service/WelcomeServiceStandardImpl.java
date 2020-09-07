package com.wellsfargo.fsd.scdx.service;

public class WelcomeServiceStandardImpl implements WelcomeService {

	public String doWelcome(String userName) {
		return "Hello! Welcome! " + userName;
	}

}
