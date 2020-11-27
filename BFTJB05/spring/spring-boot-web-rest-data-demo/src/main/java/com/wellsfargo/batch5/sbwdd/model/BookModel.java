package com.wellsfargo.batch5.sbwdd.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class BookModel implements Comparable<BookModel>{	

	@NotNull(message="Book Code is mandate")
	@Min(value=1,message="Book Code can not be negative or zero")
	private Integer bookCode;
	
	@NotNull(message="Title is mandate")
	@NotBlank(message="Title is mandate")
	private String title;
	
	@NotNull(message="Price is mandate")
	@Min(value=1,message="Price can not be negative or zero")	
	private Double price;
	
	@NotNull(message="Publish Date is mandate")	
	@PastOrPresent(message="Publish Date can not be a future date")
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate publishDate;
	
	private GenreModel genere;
	
	public BookModel() {
		
	}

	public BookModel(Integer bookCode, String title, Double price, LocalDate publishDate, GenreModel genere) {
		super();
		this.bookCode = bookCode;
		this.title = title;
		this.price = price;
		this.publishDate = publishDate;
		this.genere = genere;
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

	public GenreModel getGenere() {
		return genere;
	}

	public void setGenere(GenreModel genere) {
		this.genere = genere;
	}

	@Override
	public int compareTo(BookModel o) {
		return this.bookCode.compareTo(o.bookCode);
	}
	
	@Override
	public int hashCode() {	
		return Objects.hashCode(bookCode);
	}
	
	@Override
	public boolean equals(Object obj) {	
		return Objects.equals(this, obj);
	}

	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", title=" + title + ", price=" + price + ", publishDate=" + publishDate
				+ ", genere=" + genere + "]";
	}
	
	
}
