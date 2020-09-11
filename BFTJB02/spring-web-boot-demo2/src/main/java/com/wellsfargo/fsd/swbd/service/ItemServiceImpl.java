package com.wellsfargo.fsd.swbd.service;

import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.swbd.model.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Override
	public void computeGSTandSellingPrice(Item item) {
		switch(item.getCategory()) {
		case "ORNIMENT":item.setGst(0.20);break;
		case "AGRO":item.setGst(0);break;
		case "DAIRY":item.setGst(0);break;
		case "CLOTHS":item.setGst(0.13);break;
		case "OTHERS":item.setGst(0.25);break;
		}
		
		item.setSellingPrice(item.getCostPrice() + (item.getCostPrice()*item.getGst()));
	}

}
