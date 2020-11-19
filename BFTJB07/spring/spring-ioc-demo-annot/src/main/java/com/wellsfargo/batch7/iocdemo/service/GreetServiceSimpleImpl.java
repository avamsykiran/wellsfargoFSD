package com.wellsfargo.batch7.iocdemo.service;

import org.springframework.stereotype.Service;

@Service("gsBean")
public class GreetServiceSimpleImpl implements IGreetService {

	@Override
	public String getGreeting(String userName) {
		return "Hello "+userName;
	}

}
