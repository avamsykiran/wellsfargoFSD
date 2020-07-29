package com.wells.ui;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.wells.model.Item;

public class StreamDemo {

	public static void main(String[] args) {
		
		List<Item> items = Arrays.asList(new Item[] {
				new Item(101L, "A4 Laser Catridge", 523.25, LocalDate.now(), true),
				new Item(102L, "A Pack of 10 DVDs", 125.0, LocalDate.now(), true),
				new Item(103L, "A4 Sheets 150", 4500.0, LocalDate.now(), true),
				new Item(104L, "Display cable", 125.0, LocalDate.now(), false),
				new Item(105L, "HDMI cable", 1500.00, LocalDate.now(), false),
				new Item(106L, "Bluetooth Keyboard and Mouse", 2523.25, LocalDate.now(), true)
		});
		
		items.stream().forEach(System.out::println);
				
		items.stream().forEach((item) -> {item.setPrice(item.getPrice()+(item.getPrice()*0.18));});
		
		System.out.println("--------------------------------------------------------------");
		items.stream().forEach(System.out::println);
		
		System.out.println("--------------------------------------------------------------");
		Optional<Item> result = items.stream().reduce((i1,i2) -> i1.getPrice()<i2.getPrice()?i1:i2);
		if(result.isPresent()) {
			System.out.println(result.get());
		}
		
		System.out.println("--------------------------------------------------------------");
		items.stream().map(item -> item.getName()).forEach(System.out::println);
		
		System.out.println("--------------------------------------------------------------");
		List<String> names = items.stream().map(item -> item.getName()).collect(Collectors.toList());
		System.out.println(names);
		
		System.out.println("--------------------------------------------------------------");
		items.stream().filter(item -> item.getPrice()<=1000.0).forEach(System.out::println);
		
		System.out.println("--------------------------------------------------------------");
		items.stream().filter(item -> !item.getFragile()).forEach(System.out::println);
	}

}
