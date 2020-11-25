package com.wellsfargo.batch5.sbwdd.service;

import java.util.List;

import com.wellsfargo.batch5.sbwdd.exception.LibraryException;
import com.wellsfargo.batch5.sbwdd.model.GenreModel;

public interface GenreService {
	GenreModel add(GenreModel genre) throws LibraryException;
	GenreModel get(int genreId) throws LibraryException;
	List<GenreModel> getAll() throws LibraryException;
	void delete(int genreId) throws LibraryException;
}
