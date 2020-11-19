package com.wellsfargo.batch5.iocdemo.serivce;

public class GreetServiceAdvancedImpl implements IGreetService{

	private IGreetNoteProvider greetNoteProvider;
	
	public String getGreeting(String userName) {
		return greetNoteProvider.getGreetNote() + " " + userName;
	}

	public IGreetNoteProvider getGreetNoteProvider() {
		return greetNoteProvider;
	}

	public void setGreetNoteProvider(IGreetNoteProvider greetNoteProvider) {
		this.greetNoteProvider = greetNoteProvider;
	}
}
