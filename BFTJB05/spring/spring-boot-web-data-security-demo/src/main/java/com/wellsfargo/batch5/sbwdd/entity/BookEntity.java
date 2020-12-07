package com.wellsfargo.batch5.sbwdd.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class BookEntity implements Comparable<BookEntity>{	
	@Id
	@Column(name="book_code")
	private Integer bookCode;
	
	@Column(name="title")
	private String title;
	
	@Column(name="price")
	private Double price;
	
	@Column(name="pub_date")
	private LocalDate publishDate;
	
	@ManyToOne
	@JoinColumn(name="gid")
	private GenreEntity genere;
	
	public BookEntity() {
		
	}

	public BookEntity(Integer bookCode, String title, Double price, LocalDate publishDate, GenreEntity genere) {
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

	public GenreEntity getGenere() {
		return genere;
	}

	public void setGenere(GenreEntity genere) {
		this.genere = genere;
	}

	@Override
	public int compareTo(BookEntity o) {
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
