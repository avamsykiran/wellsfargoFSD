package com.wellsfargo.scd.service;

public class GreetServiceAdvancedImpl implements GreetService {

	private String greeting;
	
	public String doGreet(String userName) {
		return greeting +  " " + userName;
	}

	public GreetServiceAdvancedImpl() {
		
	}
	
	public GreetServiceAdvancedImpl(String greeting) {
		this.greeting=greeting;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

}
