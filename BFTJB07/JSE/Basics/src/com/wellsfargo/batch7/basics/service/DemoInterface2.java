package com.wellsfargo.batch7.basics.service;

public interface DemoInterface2 {

	void abstractMethod();
	
	default void defaultMethod() {
		System.out.println("a default method2");
	}
	
	static void staticMethod() {
		System.out.println("a static method2");
	}
}
