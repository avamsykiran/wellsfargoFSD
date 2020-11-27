package com.wellsfargo.batch5.sbwdd.model;

import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GenreModel {

	@NotNull(message="Genre Id is mandate")
	@Min(value=1,message="Genre Id can not be negative or zero")
	private Integer genreId;
	
	@NotNull(message="Genre Name is mandate")
	@NotBlank(message="Genre Name is mandate")
	@Size(min=4,max=30,message="Genre Name must be of 4 to 30 chars in length")
	private String genreName;
	
	public GenreModel() {
		
	}

	public GenreModel(Integer genreId, String genreName) {
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
	
}
