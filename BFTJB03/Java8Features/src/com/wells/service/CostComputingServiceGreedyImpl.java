package com.wells.service;

public class CostComputingServiceGreedyImpl implements CostComputingService {

	@Override
	public double getSellingPrice(double costPrice) {
		return costPrice + (costPrice*0.12);		
	}

	@Override
	public double getTax(double sellingPrice) {	
		return CostComputingService.super.getTax(sellingPrice) * 0.05;
	}
	
}
