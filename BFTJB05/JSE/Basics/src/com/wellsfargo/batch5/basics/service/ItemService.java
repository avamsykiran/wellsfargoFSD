package com.wellsfargo.batch5.basics.service;

import java.util.List;
import java.util.function.Predicate;

import com.wellsfargo.batch5.basics.model.Item;

public class ItemService {
/*	public void increaseCost(List<Item> items,double priceInc,IEligible elg) {
		for(Item item:items) {
			if(elg.isEligible(item)) {
				item.setPrice(item.getPrice()+priceInc);
			}
		}
	}*/
	
	public void increaseCost(List<Item> items,double priceInc,Predicate<Item> prd) {
		for(Item item:items) {
			if(prd.test(item)) {
				item.setPrice(item.getPrice()+priceInc);
			}
		}
	}
}
