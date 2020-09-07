package com.wellsfargo.scdx.service;

public class GreetServiceEnhancedImpl implements GreetService {

	private GreetingProvider greetingProvider;

	public GreetServiceEnhancedImpl() {

	}
	
	public GreetServiceEnhancedImpl(GreetingProvider greetingProvider) {
		super();
		this.greetingProvider = greetingProvider;
	}

	public GreetingProvider getGreetingProvider() {
		return greetingProvider;
	}

	public void setGreetingProvider(GreetingProvider greetingProvider) {
		this.greetingProvider = greetingProvider;
	}

	public String greet(String userName) {
		return greetingProvider.getGreeting() + " " + userName;
	}

}
