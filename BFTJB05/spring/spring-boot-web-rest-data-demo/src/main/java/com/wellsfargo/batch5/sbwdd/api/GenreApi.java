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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.batch5.sbwdd.exception.LibraryException;
import com.wellsfargo.batch5.sbwdd.model.BookModel;
import com.wellsfargo.batch5.sbwdd.model.GenreModel;
import com.wellsfargo.batch5.sbwdd.service.BookService;
import com.wellsfargo.batch5.sbwdd.service.GenreService;

@RestController
@RequestMapping("/genres")
public class GenreApi {

	@Autowired
	private GenreService gService;
	
	@Autowired
	private BookService bService;
	
	@GetMapping
	public ResponseEntity<List<GenreModel>> genresAction() throws LibraryException{
		return new ResponseEntity<List<GenreModel>>(gService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{gid}")
	public ResponseEntity<GenreModel> genreAction(@PathVariable("gid") int genreId) {
		ResponseEntity<GenreModel> response=null;
		try {
			GenreModel genre = gService.get(genreId);
			response = new ResponseEntity<GenreModel>(genre, HttpStatus.OK);
		}catch(LibraryException exp) {
			response = new ResponseEntity<GenreModel>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@GetMapping("/{gid}/books")
	public ResponseEntity<List<BookModel>> booksByGenreAction(@PathVariable("gid") int genreId) throws LibraryException{
		return new ResponseEntity<List<BookModel>>(bService.getAll(gService.get(genreId)), HttpStatus.OK);
	}
	
	@DeleteMapping("/{gid}")
	public ResponseEntity<Void> deleteAction(@PathVariable("gid") int genreId) {
		ResponseEntity<Void> response=null;
		try {
			gService.delete(genreId);
			response = new ResponseEntity<>(HttpStatus.OK);
		}catch(LibraryException exp) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@PostMapping
	public ResponseEntity<GenreModel> addAction(
			@RequestBody @Valid GenreModel genre,
			BindingResult result) throws LibraryException {
		
		ResponseEntity<GenreModel> response=null;
	
		if(result.hasErrors()) {
			throw new LibraryException(ExceptionApi.toErrMsg(result.getAllErrors()));
		}else {
			genre = gService.add(genre);
			response = new ResponseEntity<GenreModel>(genre, HttpStatus.OK);
		}
		
		return response;	
	}
	
	
}
