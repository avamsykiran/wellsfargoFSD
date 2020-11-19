package com.wellsfargo.batch7.iocdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.batch7.iocdemo.util.IGreetNoteProvider;

@Service("gsaBean")
public class GreetServiceAdvancedImpl implements IGreetService{

	@Autowired
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
