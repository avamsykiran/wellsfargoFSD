package com.wellsfargo.fsd.td.service;

import java.util.ArrayList;
import java.util.List;

public class NumericOperations {

	public List<Integer> getFactors(int number){
		List<Integer> factors = new ArrayList<>();
		
		factors.add(1);
		
		for(int i=2;i<=number/2;i++) {
			if(number%i==0) {
				factors.add(i);
			}
		}
		
		factors.add(number);
		
		return factors;
	}
	
	public boolean isPrime(int number) {
		return getFactors(number).size() ==2;				
	}
	
	public boolean isOdd(int number) {
		int m = number%2;
		return m==1 || m==-1;
	}
}
