package com.wellsfargo.batch5.basics.ui;

import java.util.Arrays;
import java.util.List;

import com.wellsfargo.batch5.basics.model.Item;
import com.wellsfargo.batch5.basics.service.ItemService;

public class LambdaExpressionDemo {

	public static void main(String[] args) {
		List<Item> items = Arrays.asList(new Item[] {
				new Item(101, "VGA Cable", 2541.0, "CABLES"),
				new Item(102, "USB 3.0 Cable", 541.0, "CABLES"),
				new Item(103, "150V Power Adapter", 1541.0, "ADAPTERS"),
				new Item(104, "240v Laptop Adapter", 3541.0, "ADAPTERS")
		});
		
		for(Item item : items) {
			System.out.println(item);
		}

		System.out.println("---------------------------");
		
		ItemService itemService = new ItemService();
		
		itemService.increaseCost(items, 200, (item)->item.getPrice()<=2000);
		for(Item item : items) {
			System.out.println(item);
		}

		System.out.println("---------------------------");
		
		itemService.increaseCost(items, -100, (item)->item.getCategory().equals("CABLES"));
		for(Item item : items) {
			System.out.println(item);
		}
	}

}
