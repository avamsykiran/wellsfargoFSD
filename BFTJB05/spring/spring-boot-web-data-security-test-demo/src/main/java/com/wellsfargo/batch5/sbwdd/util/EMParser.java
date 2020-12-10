package com.wellsfargo.batch5.sbwdd.util;

import java.util.Set;
import java.util.stream.Collectors;

import com.wellsfargo.batch5.sbwdd.entity.BookEntity;
import com.wellsfargo.batch5.sbwdd.entity.ContactDetails;
import com.wellsfargo.batch5.sbwdd.entity.GenreEntity;
import com.wellsfargo.batch5.sbwdd.entity.LibraryMember;
import com.wellsfargo.batch5.sbwdd.model.BookModel;
import com.wellsfargo.batch5.sbwdd.model.GenreModel;
import com.wellsfargo.batch5.sbwdd.model.RegisterLibraryMemberModel;

public class EMParser {
	
	public static BookModel parse(BookEntity source) {
		BookModel target = new BookModel();
		
		target.setBookCode(source.getBookCode());
		target.setPrice(source.getPrice());
		target.setPublishDate(source.getPublishDate());
		target.setTitle(source.getTitle());
		target.setGenere(parse(source.getGenere()));
				
		return target;
	}
	
	public static GenreModel parse(GenreEntity source) {
		GenreModel target = new GenreModel();
		
		target.setGenreId(source.getGenreId());
		target.setGenreName(source.getGenreName());
				
		return target;
	}
	
	public static BookEntity parse(BookModel source) {
		BookEntity target = new BookEntity();
		
		target.setBookCode(source.getBookCode());
		target.setPrice(source.getPrice());
		target.setPublishDate(source.getPublishDate());
		target.setTitle(source.getTitle());
		target.setGenere(parse(source.getGenere()));
		
		return target;
	}
	
	public static GenreEntity parse(GenreModel source) {
		GenreEntity target = new GenreEntity();
		
		target.setGenreId(source.getGenreId());
		target.setGenreName(source.getGenreName());
			
		return target;
	}
	public static LibraryMember parse(RegisterLibraryMemberModel source) {
		LibraryMember target = new LibraryMember();
		
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());
		target.setAddress(
				new ContactDetails(source.getMobileNumber(), 
						source.getAddressLine1(), source.getAddressLine2(), source.getCity()));
		target.setPassword(source.getPassword());
		target.setRole("MEMBER");
		target.setUserName(source.getUserName());
		
		return target;
	}

}
