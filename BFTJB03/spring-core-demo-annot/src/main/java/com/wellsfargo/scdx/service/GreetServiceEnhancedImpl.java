package com.wellsfargo.scdx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gseb")
public class GreetServiceEnhancedImpl implements GreetService {

	@Autowired
	private GreetingProvider greetingProvider;

	public String greet(String userName) {
		return greetingProvider.getGreeting() + " " + userName;
	}

}
