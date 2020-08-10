package com.wellsfargo.fsd.td.service;

import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.fsd.td.exception.MyException;

public class NumericOperations {

	public boolean isOdd(int num) {
		return num%2==1 || num%2==-1;
	}
	
	public int qut(int n1,int n2) throws MyException {
		
		if(n2==0) {
			throw new MyException("Zero can not be a divisor");
		}
		
		return n1/n2;
	}
	
	public List<Integer> getFactors(int num){
		List<Integer> factors = new ArrayList<>();
		
		factors.add(1);
		for(int i=2;i<=num/2;i++) {
			if(num%i==0) {
				factors.add(i);
			}
		}		
		factors.add(num);
		
		return factors;
	}
}
