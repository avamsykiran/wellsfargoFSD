package com.wellsfargo.batch5.iocdemo.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gsa")
public class GreetServiceAdvancedImpl implements IGreetService{

	@Autowired
	private IGreetNoteProvider greetNoteProvider;
	
	public String getGreeting(String userName) {
		return greetNoteProvider.getGreetNote() + " " + userName;
	}
}
