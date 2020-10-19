package com.wellsfargo.batch5.basics.service;

import com.wellsfargo.batch5.basics.model.Item;

@FunctionalInterface
public interface IEligible {
	boolean isEligible(Item item);
}
