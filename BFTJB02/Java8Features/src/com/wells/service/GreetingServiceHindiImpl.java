package com.wells.service;

public class GreetingServiceHindiImpl implements GreetingService {

	@Override
	public String getGreetNote() {
		return "Namsakar! ";
	}

	@Override
	public String doGreet(String username) {
		return "Apse Milkar Acha Laga! "+username;
	}
	
}
