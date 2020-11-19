package com.wellsfargo.batch5.iocdemo.serivce;

public class GreetServiceArgumentedImpl implements IGreetService{

	private String greetNote;
	
	public GreetServiceArgumentedImpl() {
		
	}
	
	public GreetServiceArgumentedImpl(String greetNote) {
		super();
		this.greetNote = greetNote;
	}

	public String getGreeting(String userName) {
		return greetNote + " " + userName;
	}

	public String getGreetNote() {
		return greetNote;
	}

	public void setGreetNote(String greetNote) {
		this.greetNote = greetNote;
	}
	
}
