package com.wellsfargo.batch5.lms.dao;

import java.util.List;

import com.wellsfargo.batch5.lms.exception.LibraryException;
import com.wellsfargo.batch5.lms.model.Book;

public interface IBookDao {
	Book add(Book book) throws LibraryException;
	Book save(Book book)throws LibraryException;
	void remove(Integer bookCode) throws LibraryException;
	List<Book> listAll() throws LibraryException;
	Book getById(Integer bookCode) throws LibraryException;
	
}
