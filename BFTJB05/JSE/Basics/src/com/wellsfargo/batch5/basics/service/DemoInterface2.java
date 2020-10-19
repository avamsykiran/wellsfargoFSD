package com.wellsfargo.batch5.basics.service;

public interface DemoInterface2 {
	void abstractMethod();
	default void defaultMethod() {
		System.out.println("A default method2");		
	} 
	static void staticMethod() {
		System.out.println("A static method2");
	}
}
