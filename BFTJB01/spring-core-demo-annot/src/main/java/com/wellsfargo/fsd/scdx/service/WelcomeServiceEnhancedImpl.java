package com.wellsfargo.fsd.scdx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wse")
public class WelcomeServiceEnhancedImpl implements WelcomeService {

	@Autowired
	private MessageProvider msgProvider;
	
	public String doWelcome(String userName) {	
		return msgProvider.getMessage() + " " + userName;
	}
	
	public WelcomeServiceEnhancedImpl() {
	
	}

	public WelcomeServiceEnhancedImpl(MessageProvider msgProvider) {
		super();
		this.msgProvider = msgProvider;
	}

	public MessageProvider getMsgProvider() {
		return msgProvider;
	}

	public void setMsgProvider(MessageProvider msgProvider) {
		this.msgProvider = msgProvider;
	}

	
}
