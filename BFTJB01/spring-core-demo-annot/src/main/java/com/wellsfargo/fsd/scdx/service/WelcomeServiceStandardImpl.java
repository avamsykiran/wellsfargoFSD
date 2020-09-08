package com.wellsfargo.fsd.scdx.service;

import org.springframework.stereotype.Service;

@Service("ws")
public class WelcomeServiceStandardImpl implements WelcomeService {

	public String doWelcome(String userName) {
		return "Hello! Welcome! " + userName;
	}

}
