package com.wellsfargo.fsd.scdx.service;

public class WelcomeServiceAdvancedImpl implements WelcomeService {

	private String welcomeMessage;

	public WelcomeServiceAdvancedImpl() {

	}

	public WelcomeServiceAdvancedImpl(String welcomeMessage) {
		this.welcomeMessage=welcomeMessage;
	}
	
	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	public String doWelcome(String userName) {
		return welcomeMessage + " " + userName;
	}
	
}
