package com.wellsfargo.batch7.iocdemo.util;

public class GreetNoteProviderSimpleImpl implements IGreetNoteProvider{

	@Override
	public String getGreetNote() {
		return "Hello! Welcome!";
	}

}
