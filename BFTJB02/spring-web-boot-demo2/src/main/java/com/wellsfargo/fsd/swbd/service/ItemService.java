package com.wellsfargo.fsd.swbd.service;

import com.wellsfargo.fsd.swbd.model.Item;

public interface ItemService {
	void computeGSTandSellingPrice(Item item);
}
