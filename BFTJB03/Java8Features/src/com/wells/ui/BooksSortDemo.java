package com.wells.ui;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.wells.model.Book;

public class BooksSortDemo {

	public static void main(String[] args) {

		List<Book> books = Arrays.asList(new Book[] {
				new Book(103L, "My Dreams", 25.32, LocalDate.of(2020, Month.MAY,12)),
				new Book(104L, "Own Dreams", 125.32, LocalDate.of(2020, Month.MAY,13)),
				new Book(102L, "Your Dreams", 205.32, LocalDate.of(2020, Month.MAY,10)),
				new Book(105L, "All Dreams", 25.30, LocalDate.of(2020, Month.MAY,1)),
				new Book(101L, "Zero Dreams", 255.32, LocalDate.of(2020, Month.MAY,3))
		});
		
		for(Book b:books) {
			System.out.println(b);
		}
		System.out.println("---------------------------------------------------");
		
		Collections.sort(books, (b1,b2)->b1.getBcode().compareTo(b2.getBcode()));
		for(Book b:books) {
			System.out.println(b);
		}
		System.out.println("---------------------------------------------------");
	
		Collections.sort(books, (b1,b2)->b1.getPublishDate().compareTo(b2.getPublishDate()));
		for(Book b:books) {
			System.out.println(b);
		}
		System.out.println("---------------------------------------------------");
	
		Collections.sort(books,
				Collections.reverseOrder((b1,b2)->b1.getTitle().compareTo(b2.getTitle())));
		for(Book b:books) {
			System.out.println(b);
		}
		System.out.println("---------------------------------------------------");
	
	}

}
