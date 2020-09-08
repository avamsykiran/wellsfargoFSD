package com.wellsfargo.fsd.scdx.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("wsa")
public class WelcomeServiceAdvancedImpl implements WelcomeService {

	@Value("#{'${w.msg}'}")
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
