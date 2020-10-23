package com.wellsfargo.batch5.lms.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.wellsfargo.batch5.lms.dto.Book;
import com.wellsfargo.batch5.lms.exception.LibraryException;
import com.wellsfargo.batch5.lms.service.BookServiceImpl;
import com.wellsfargo.batch5.lms.service.IBookService;

public class LibraryApplication {

	static IBookService bookService;
	static Scanner scan;

	public static void main(String[] args) {

		bookService = new BookServiceImpl();
		scan = new Scanner(System.in);

		LibraryOperations choice = null;

		while (choice != LibraryOperations.QUIT) {
			System.out.println("Choice\t\tMenu");
			for (LibraryOperations opt : LibraryOperations.values()) {
				System.out.println(opt.ordinal() + "\t\t" + opt);
			}
			System.out.println("Choice:> ");
			int ch = scan.nextInt();

			if (ch >= 0 && ch < LibraryOperations.values().length) {
				choice = LibraryOperations.values()[ch];

				switch (choice) {
				case ADD:
					doAdd();
					break;
				case LIST:
					doList();
					break;
				case DELETE:
					doDelete();
					break;
				case QUIT:
					System.out.println("Application Terminated!");
					break;
				}
			}
		}
	}

	private static void doList() {
		try {
			List<Book> books = bookService.listAll();
			if (books == null || books.isEmpty()) {
				System.out.println("No Records Found");
			} else {
				for (Book book : books) {
					System.out.println(book.getBookCode() + "\t" + book.getTitle() + 
							"\t" + book.getPrice() + "\t"
							+ book.getCategory() + "\t" + book.getPublishDate());
				}
			}
		} catch (LibraryException exp) {
			System.out.println("Err: " + exp.getMessage());
		}
	}

	private static void doAdd() {
		
		Book book = new Book();
		
		System.out.print("bookCode: ");
		book.setBookCode(scan.nextInt());
		System.out.print("Title: ");
		book.setTitle(scan.next());
		System.out.print("Price: ");
		book.setPrice(scan.nextDouble());
		System.out.print("Published Date(yyyy-MM-dd): ");
		book.setPublishDate(LocalDate.parse(scan.next()));
		System.out.print("Category: ");
		book.setCategory(scan.next());
		
		try {
			bookService.add(book);
			System.out.println("Book Saved Successfully!");
		} catch (LibraryException exp) {
			System.out.println("Err: " + exp.getMessage());
		}
	}

	private static void doDelete() {
		System.out.print("bookCode: ");
		int bookCode = scan.nextInt();
		try {
			bookService.remove(bookCode);
			System.out.println("Book got deleted!");
		} catch (LibraryException exp) {
			System.out.println("Err: " + exp.getMessage());
		}
	}
}
