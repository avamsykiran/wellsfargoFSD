package com.wells.ui;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.wells.model.Book;

public class StreamDemo {

	public static void main(String[] args) {
		
		List<Book> books = Arrays.asList(new Book[] {
				new Book(103L, "My Dreams", 25.32, LocalDate.of(2020, Month.MAY,12)),
				new Book(104L, "Own Dreams", 125.32, LocalDate.of(2020, Month.MAY,13)),
				new Book(102L, "Your Dreams", 205.32, LocalDate.of(2020, Month.MAY,10)),
				new Book(105L, "All Dreams", 25.30, LocalDate.of(2020, Month.MAY,1)),
				new Book(101L, "Zero Dreams", 255.32, LocalDate.of(2020, Month.MAY,3))
		});
		
		books.stream().forEach(System.out::println);
		books.stream().forEach((b) -> {b.setPrice(b.getPrice()+100);} );
		System.out.println("--------------------");
		books.stream().forEach(System.out::println);

		System.out.println("--------------------");
		Optional<Book> result = books.stream().reduce((b1,b2) -> b1.getPrice()>b2.getPrice()?b1:b2);
		if(result.isPresent()) {
			System.out.println(result.get());
		}

		System.out.println("--------------------");
		Optional<Book> result2 = books.stream().reduce((b1,b2) -> b1.getPublishDate().isAfter(b2.getPublishDate())?b1:b2);
		if(result2.isPresent()) {
			System.out.println(result2.get());
		}

		System.out.println("--------------------");
		books.stream().filter((b) -> b.getPrice()<300).forEach(System.out::println);
		
		System.out.println("--------------------");
		List<Book> books2 = books.stream().filter((b) -> b.getPrice()>=300).collect(Collectors.toList());
		System.out.println(books2);
				
		System.out.println("--------------------");
		books.stream().map((b) -> b.getTitle()).forEach(System.out::println);
				
		System.out.println("--------------------");		
		Stream.of(1,2,3,4,5,6,7,8,9,10).map((n) -> n*n).forEach(System.out::println);
		
	}

}
