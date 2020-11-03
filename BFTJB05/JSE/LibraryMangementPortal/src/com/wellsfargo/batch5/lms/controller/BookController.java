package com.wellsfargo.batch5.lms.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.batch5.lms.exception.LibraryException;
import com.wellsfargo.batch5.lms.model.Book;
import com.wellsfargo.batch5.lms.service.BookServiceImpl;
import com.wellsfargo.batch5.lms.service.IBookService;

@WebServlet({ "/listBooks", "/newBook", "/addBook", "/deleteBook", "/editBook", "/saveBook" })
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IBookService bookService;

	@Override
	public void init() throws ServletException {
		this.bookService = new BookServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String urlMapping = request.getServletPath();
		String view = "";
		try {
			switch (urlMapping) {
			case "/listBooks":
				view = doListBooks(request, response);
				break;
			case "/newBook":
				view = doNewBook(request, response);
				break;
			case "/addBook":
				view = doAddBook(request, response);
				break;
			case "/deleteBook":
				view = doDeleteBook(request, response);
				break;
			case "/editBook":
				view = doEditBook(request, response);
				break;				
			case "/saveBook":
				view = doSaveBook(request, response);
				break;
			}
		} catch (LibraryException exp) {
			request.setAttribute("errMsg", exp.getMessage());
			view = "/errPage.jsp";
		}
		request.getRequestDispatcher(view).forward(request, response);
	}

	private String doDeleteBook(HttpServletRequest request, HttpServletResponse response) throws LibraryException {
		int bcode = Integer.parseInt(request.getParameter("bcode"));
		bookService.remove(bcode);
		request.setAttribute("msg", "Book Removed Successfully");		
		return "index.jsp";
	}

	private String doAddBook(HttpServletRequest request, HttpServletResponse response) {
		Book book = new Book();
		book.setBookCode(Integer.parseInt(request.getParameter("bookCode")));
		book.setTitle(request.getParameter("title"));
		book.setCategory(request.getParameter("category"));
		book.setPrice(Double.parseDouble(request.getParameter("price")));
		book.setPublishDate(LocalDate.parse(request.getParameter("publishDate")));
		
		String view ="";
		try {
			bookService.add(book);
			request.setAttribute("msg", "Book Saved Successfully");
			view="index.jsp";
		} catch (LibraryException e) {		
			request.setAttribute("isNew",true);
			request.setAttribute("errs", e.getMessage());
			request.setAttribute("book",book);
			view="book_form_page.jsp";
		}
		return view;
	}

	private String doSaveBook(HttpServletRequest request, HttpServletResponse response) {
		Book book = new Book();
		book.setBookCode(Integer.parseInt(request.getParameter("bookCode")));
		book.setTitle(request.getParameter("title"));
		book.setCategory(request.getParameter("category"));
		book.setPrice(Double.parseDouble(request.getParameter("price")));
		book.setPublishDate(LocalDate.parse(request.getParameter("publishDate")));
		
		String view ="";
		try {
			bookService.save(book);
			request.setAttribute("msg", "Book Saved Successfully");
			view="index.jsp";
		} catch (LibraryException e) {		
			request.setAttribute("isNew",false);
			request.setAttribute("errs", e.getMessage());
			request.setAttribute("book",book);
			view="book_form_page.jsp";
		}
		return view;
	}

	private String doEditBook(HttpServletRequest request, HttpServletResponse response) throws LibraryException {
		int bcode = Integer.parseInt(request.getParameter("bcode"));
		Book book = bookService.getById(bcode);
		
		request.setAttribute("isNew",false);
		request.setAttribute("book",book);
		return "book_form_page.jsp";
	}

	private String doNewBook(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("isNew", true);
		return "book_form_page.jsp";
	}

	private String doListBooks(HttpServletRequest request, HttpServletResponse response) throws LibraryException {
		request.setAttribute("booksList", bookService.listAll());
		return "/list_books_page.jsp";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
