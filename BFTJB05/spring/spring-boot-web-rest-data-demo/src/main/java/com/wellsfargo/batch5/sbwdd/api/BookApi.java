package com.wellsfargo.batch5.sbwdd.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.batch5.sbwdd.exception.LibraryException;
import com.wellsfargo.batch5.sbwdd.model.BookModel;
import com.wellsfargo.batch5.sbwdd.service.BookService;
import com.wellsfargo.batch5.sbwdd.service.GenreService;

@RestController
@RequestMapping("/books")
public class BookApi {

	@Autowired
	private GenreService gService;
	
	@Autowired
	private BookService bService;
	
	@GetMapping
	public ResponseEntity<List<BookModel>> booksAction() throws LibraryException{
		return new ResponseEntity<List<BookModel>>(bService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/genres/{gid}")
	public ResponseEntity<List<BookModel>> booksByGenreAction(@PathVariable("gid") int genreId) throws LibraryException{
		return new ResponseEntity<List<BookModel>>(bService.getAll(gService.get(genreId)), HttpStatus.OK);
	}
	
	@GetMapping("/{bid}")
	public ResponseEntity<BookModel> genreAction(@PathVariable("bid") int bookCode) {
		ResponseEntity<BookModel> response=null;
		try {
			BookModel book = bService.get(bookCode);
			response = new ResponseEntity<>(book, HttpStatus.OK);
		}catch(LibraryException exp) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@DeleteMapping("/{bid}")
	public ResponseEntity<Void> deleteAction(@PathVariable("bid") int bookCode) {
		ResponseEntity<Void> response=null;
		try {
			bService.delete(bookCode);
			response = new ResponseEntity<>(HttpStatus.OK);
		}catch(LibraryException exp) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@PostMapping
	public ResponseEntity<BookModel> addAction(
			@RequestBody @Valid BookModel book,
			BindingResult result) throws LibraryException {
		
		ResponseEntity<BookModel> response=null;
	
		if(result.hasErrors()) {
			throw new LibraryException(ExceptionApi.toErrMsg(result.getAllErrors()));
		}else {
			book = bService.add(book);
			response = new ResponseEntity<BookModel>(book, HttpStatus.OK);
		}
		
		return response;	
	}
	
	@PutMapping
	public ResponseEntity<BookModel> updateAction(
			@RequestBody @Valid BookModel book,
			BindingResult result) throws LibraryException {
		
		ResponseEntity<BookModel> response=null;
	
		if(result.hasErrors()) {
			throw new LibraryException(ExceptionApi.toErrMsg(result.getAllErrors()));
		}else {
			book = bService.update(book);
			response = new ResponseEntity<BookModel>(book, HttpStatus.OK);
		}
		
		return response;	
	}
}
