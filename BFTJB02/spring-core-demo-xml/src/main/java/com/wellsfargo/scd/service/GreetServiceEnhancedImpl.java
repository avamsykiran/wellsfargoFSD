package com.wellsfargo.scd.service;

import com.wellsfargo.scd.util.GreetingProvider;

public class GreetServiceEnhancedImpl implements GreetService {

	private GreetingProvider greetingProvider;
	
	public String doGreet(String userName) {
		return greetingProvider.getGreeting() +  " " + userName;
	}

	public GreetServiceEnhancedImpl() {
		
	}
	
	public GreetServiceEnhancedImpl(GreetingProvider greetingProvider) {
		this.greetingProvider=greetingProvider;
	}

	public GreetingProvider getGreetingProvider() {
		return greetingProvider;
	}

	public void setGreetingProvider(GreetingProvider greetingProvider) {
		this.greetingProvider = greetingProvider;
	}

	

}
