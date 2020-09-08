package com.wellsfargo.scdx.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("gsab")
public class GreetServiceAdvancedImpl implements GreetService {

	@Value("#{'${grt}'}")
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
