package com.wellsfargo.batch5.basics.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.wellsfargo.batch5.basics.model.Item;

public class StreamsDemo {

	public static void main(String[] args) {
		List<Item> items = Arrays.asList(new Item[] {
				new Item(101, "VGA Cable", 2541.0, "CABLES"),
				new Item(102, "USB 3.0 Cable", 541.0, "CABLES"),
				new Item(103, "150V Power Adapter", 1541.0, "ADAPTERS"),
				new Item(104, "240v Laptop Adapter", 3541.0, "ADAPTERS")
		});
		
		items.stream().forEach(System.out::println);
		System.out.println("----------------------------------");
		
		Optional<Item> result = items.stream().reduce((i1,i2) -> i1.getPrice()<=i2.getPrice()?i1:i2);
		System.out.println(result.get());
		System.out.println("----------------------------------");
		
		List<Item> incrementedItems = items.stream()
				.map(item ->{ item.setPrice(item.getPrice()+100); return item;})
				.collect(Collectors.toList());
		incrementedItems.stream().forEach(System.out::println);
		System.out.println("----------------------------------");
		
		List<String> itemNames = items.stream().map(item->item.getItemName()).collect(Collectors.toList());
		itemNames.stream().forEach(System.out::println);
		System.out.println("----------------------------------");
		
		List<Item> cables = items.stream()
				.filter(item -> item.getCategory().equals("CABLES"))
				.collect(Collectors.toList());
		cables.stream().forEach(System.out::println);
		System.out.println("----------------------------------");
		
	}

}
