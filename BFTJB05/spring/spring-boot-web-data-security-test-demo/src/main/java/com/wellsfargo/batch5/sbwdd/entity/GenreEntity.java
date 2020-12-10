package com.wellsfargo.batch5.sbwdd.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="genres")
public class GenreEntity {

	@Id
	@Column(name="genre_id")
	private Integer genreId;
	
	@Column(name="genre_name",nullable=false)
	private String genreName;
	
	@OneToMany(mappedBy="genere",cascade=CascadeType.ALL)
	private Set<BookEntity> books;
	
	public GenreEntity() {
		
	}

	public GenreEntity(Integer genreId, String genreName) {
		super();
		this.genreId = genreId;
		this.genreName = genreName;
	}

	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", genreName=" + genreName + "]";
	}

	public Set<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(Set<BookEntity> books) {
		this.books = books;
	}

	
}
