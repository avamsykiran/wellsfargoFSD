package com.wellsfargo.batch5.lms.model;

import java.time.LocalDate;

public class Book {	
	private Integer bookCode;
	private String title;
	private double price;
	private LocalDate publishDate;
	private String category;
	
	public Book() {
		
	}

	public Book(Integer bookCode, String title, double price, LocalDate publishDate, String category) {
		super();
		this.bookCode = bookCode;
		this.title = title;
		this.price = price;
		this.publishDate = publishDate;
		this.category = category;
	}

	public Integer getBookCode() {
		return bookCode;
	}

	public void setBookCode(Integer bookCode) {
		this.bookCode = bookCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
