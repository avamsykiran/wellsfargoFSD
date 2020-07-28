package com.wells.service;

public interface DemoInterface {
	public abstract String anAbstractMethod();
	
	public default String aDefaultMethod() {
		return "This is a default method.";
	}
	
	public static String aStaticMethod() {
		return "a static method";
	}
}
