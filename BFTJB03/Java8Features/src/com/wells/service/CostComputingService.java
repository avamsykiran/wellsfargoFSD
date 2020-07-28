package com.wells.service;

public interface CostComputingService {

	public abstract double getSellingPrice(double costPrice);
	
	public default double getTax(double sellingPrice) {
		return sellingPrice*0.12;
	}
	
	public static String aStaticMethod() {
		return "a static method";
	}
}
