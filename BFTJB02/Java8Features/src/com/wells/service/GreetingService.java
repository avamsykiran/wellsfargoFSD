package com.wells.service;

public interface GreetingService {

	public abstract String getGreetNote();
	
	public default String doGreet(String username) {
		return getGreetNote() + " " + username;
	}
	
	public static String sayHello(String username) {
		return "Hello " + username;
	}
}
