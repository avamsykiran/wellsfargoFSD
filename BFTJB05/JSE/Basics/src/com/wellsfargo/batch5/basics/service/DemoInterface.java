package com.wellsfargo.batch5.basics.service;

public interface DemoInterface {
	void abstractMethod();
	default void defaultMethod() {
		System.out.println("A default method");		
	} 
	static void staticMethod() {
		System.out.println("A static method");
	}
}
