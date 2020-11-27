package com.wellsfargo.batch5.sbwdd.service;

import java.util.List;

import com.wellsfargo.batch5.sbwdd.exception.LibraryException;
import com.wellsfargo.batch5.sbwdd.model.BookModel;
import com.wellsfargo.batch5.sbwdd.model.GenreModel;

public interface BookService {
	BookModel add(BookModel book) throws LibraryException;
	BookModel update(BookModel book) throws LibraryException;
	BookModel get(int bookCode) throws LibraryException;
	void delete(int bookCode) throws LibraryException;
	List<BookModel> getAll() throws LibraryException;
	List<BookModel> getAll(GenreModel genre) throws LibraryException;
}
