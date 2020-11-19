package com.wellsfargo.batch7.iocdemo.service;

import com.wellsfargo.batch7.iocdemo.util.IGreetNoteProvider;

public class GreetServiceAdvancedImpl implements IGreetService{

	private IGreetNoteProvider greetNoteProvider;
	
	@Override
	public String getGreeting(String userName) {
		return greetNoteProvider.getGreetNote() + " " +userName;
	}

	public IGreetNoteProvider getGreetNoteProvider() {
		return greetNoteProvider;
	}

	public void setGreetNoteProvider(IGreetNoteProvider greetNoteProvider) {
		this.greetNoteProvider = greetNoteProvider;
	}

	
}
