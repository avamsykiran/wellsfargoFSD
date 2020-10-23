package com.wellsfargo.batch5.lms.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.wellsfargo.batch5.lms.dao.BookDaoImpl;
import com.wellsfargo.batch5.lms.dao.IBookDao;
import com.wellsfargo.batch5.lms.dto.Book;
import com.wellsfargo.batch5.lms.exception.LibraryException;

public class BookServiceImpl implements IBookService{
	
	private IBookDao bookDao;
	
	public BookServiceImpl() {
		this.bookDao = new BookDaoImpl();
	}

	private boolean isValidBookCode(int bookCode) {
		return bookCode>0;
	}
	
	private boolean isValidTitle(String title) {
		return title!=null && title.length()>=4 && title.length()<=50;
	}
	
	private boolean isValidPrice(double price) {
		return price>=0;
	}
	
	private boolean isValidPublishDate(LocalDate pDate) {
		LocalDate today =LocalDate.now(); 
		return today.isAfter(pDate) || today.equals(pDate);
	} 
	
	private boolean isValidCategory(String category) {
		return category!=null && category.length()>=3 && category.length()<=50;
	}
	
	private void validateBook(Book book) throws LibraryException{
		List<String> errMsgs = new ArrayList<String>();
		
		if(!isValidBookCode(book.getBookCode())) {
			errMsgs.add("BookCode can not be negative");
		}
		if(!isValidTitle(book.getTitle())) {
			errMsgs.add("Book Title can not be left blank and must be of 4 to 50 chars in length");
		}
		if(!isValidPrice(book.getPrice())) {
			errMsgs.add("Price can not be negative");
		}
		if(!isValidPublishDate(book.getPublishDate())) {
			errMsgs.add("Book can not get published in future");
		}
		if(!isValidCategory(book.getCategory())) {
			errMsgs.add("Category can not be left blank and must be of 3 to 50 chars in length");
		}
		
		if(!errMsgs.isEmpty()) {
			throw new LibraryException(errMsgs.toString());
		}
	}
	
	@Override
	public Book add(Book book) throws LibraryException {
		if(book!=null) {
			validateBook(book);
			bookDao.add(book);
		}
		return book;
	}

	@Override
	public Book save(Book book) throws LibraryException {
		if(book!=null) {
			validateBook(book);
			bookDao.save(book);
		}
		return book;
	}

	@Override
	public void remove(Integer bookCode) throws LibraryException {
		bookDao.remove(bookCode);		
	}

	@Override
	public List<Book> listAll() throws LibraryException {
		return bookDao.listAll();
	}

	@Override
	public Book getById(Integer bookCode) throws LibraryException {
		return bookDao.getById(bookCode);
	}
}
