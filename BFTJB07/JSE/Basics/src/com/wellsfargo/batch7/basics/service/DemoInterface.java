package com.wellsfargo.batch7.basics.service;

public interface DemoInterface {

	void abstractMethod();
	
	default void defaultMethod() {
		System.out.println("a default method");
	}
	
	static void staticMethod() {
		System.out.println("a static method");
	}
}
