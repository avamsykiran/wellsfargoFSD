package com.wellsfargo.batch5.lms.service;

import java.util.List;

import com.wellsfargo.batch5.lms.dto.Book;
import com.wellsfargo.batch5.lms.exception.LibraryException;

public interface IBookService {
	Book add(Book book) throws LibraryException;
	Book save(Book book)throws LibraryException;
	void remove(Integer bookCode) throws LibraryException;
	List<Book> listAll() throws LibraryException;
	Book getById(Integer bookCode) throws LibraryException;
}
