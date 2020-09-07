package com.wellsfargo.scdx.service;

public class GreetServiceAdvancedImpl implements GreetService {

	private String greeting;

	public GreetServiceAdvancedImpl() {

	}

	public GreetServiceAdvancedImpl(String greeting) {
		this.greeting = greeting;
	}
	
	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String greet(String userName) {
		return greeting + " " + userName;
	}

}
