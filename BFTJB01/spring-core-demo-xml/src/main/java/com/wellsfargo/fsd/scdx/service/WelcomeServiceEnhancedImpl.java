package com.wellsfargo.fsd.scdx.service;

public class WelcomeServiceEnhancedImpl implements WelcomeService {

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
