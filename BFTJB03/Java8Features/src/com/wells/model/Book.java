package com.wells.model;

import java.time.LocalDate;

public class Book {
	
	private Long bcode;
	private String title;
	private Double price;
	private LocalDate publishDate;
	
	public Book() {
		//left blank
	}

	public Book(Long bcode, String title, Double price, LocalDate publishDate) {
		super();
		this.bcode = bcode;
		this.title = title;
		this.price = price;
		this.publishDate = publishDate;
	}

	public Long getBcode() {
		return bcode;
	}

	public void setBcode(Long bcode) {
		this.bcode = bcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public String toString() {
		return "Book [bcode=" + bcode + ", title=" + title + ", price=" + price + ", publishDate=" + publishDate + "]";
	}

}
