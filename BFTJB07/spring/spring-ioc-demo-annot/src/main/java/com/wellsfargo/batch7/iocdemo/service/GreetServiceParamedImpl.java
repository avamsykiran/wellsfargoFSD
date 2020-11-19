package com.wellsfargo.batch7.iocdemo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("gspBean")
public class GreetServiceParamedImpl implements IGreetService{

	@Value("Namasthey!")
	private String greetNote;
	
	public GreetServiceParamedImpl() {
		
	}
	
	public GreetServiceParamedImpl(String greetNote) {
		super();
		this.greetNote = greetNote;
	}

	@Override
	public String getGreeting(String userName) {
		return greetNote + " " +userName;
	}

	public String getGreetNote() {
		return greetNote;
	}

	public void setGreetNote(String greetNote) {
		this.greetNote = greetNote;
	}

	
}
