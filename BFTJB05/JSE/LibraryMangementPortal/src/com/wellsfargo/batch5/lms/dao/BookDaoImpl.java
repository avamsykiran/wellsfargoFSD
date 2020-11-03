package com.wellsfargo.batch5.lms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.wellsfargo.batch5.lms.exception.LibraryException;
import com.wellsfargo.batch5.lms.model.Book;

public class BookDaoImpl implements IBookDao {
	
	Logger log = Logger.getLogger("DAO");
	
	public static final String INS_QRY=
			"INSERT INTO books(b_code,title,price,publish_data,category) VALUES(?,?,?,?,?)";
	public static final String UPD_QRY=
			"UPDATE books SET title=?,price=?,publish_data=?,category=? WHERE b_code=?";
	public static final String DEL_QRY=
			"DELETE FROM books WHERE b_code=?";
	public static final String SELECT_ALL_QRY=
			"SELECT b_code,title,price,publish_data,category FROM books";
	public static final String SELECT_BY_ID_QRY=
			"SELECT b_code,title,price,publish_data,category FROM books WHERE b_code=?";
	

	@Override
	public Book add(Book book) throws LibraryException {
		if(book!=null) {
			try(Connection con=ConnectionProvider.getConnection(); 
					PreparedStatement pst = con.prepareStatement(INS_QRY)){
				
				pst.setInt(1, book.getBookCode());
				pst.setString(2, book.getTitle());
				pst.setDouble(3,book.getPrice());
				pst.setDate(4, Date.valueOf(book.getPublishDate()));
				pst.setString(5, book.getCategory());
				
				pst.executeUpdate();
			}catch(SQLException exp) {
				log.error(exp);
				throw new LibraryException("Sorry! An Error Occured While Saving Data!");
			}
		}
		return book;
	}

	@Override
	public Book save(Book book) throws LibraryException {
		if(book!=null) {
			try(Connection con=ConnectionProvider.getConnection(); 
					PreparedStatement pst = con.prepareStatement(UPD_QRY)){
								
				pst.setString(1, book.getTitle());
				pst.setDouble(2,book.getPrice());
				pst.setDate(3, Date.valueOf(book.getPublishDate()));
				pst.setString(4, book.getCategory());
				pst.setInt(5, book.getBookCode());
				
				pst.executeUpdate();
			}catch(SQLException exp) {
				log.error(exp);
				throw new LibraryException("Sorry! An Error Occured While Saving Data!");
			}
		}
		return book;
	}

	@Override
	public void remove(Integer bookCode) throws LibraryException {
		try(Connection con=ConnectionProvider.getConnection(); 
				PreparedStatement pst = con.prepareStatement(DEL_QRY)){
							
			pst.setInt(1,bookCode);
			
			pst.executeUpdate();
		}catch(SQLException exp) {
			log.error(exp);
			throw new LibraryException("Sorry! An Error Occured While Deleting Data!");
		}
		
	}

	@Override
	public List<Book> listAll() throws LibraryException {
		List<Book> books=new ArrayList<>();
		try(Connection con=ConnectionProvider.getConnection(); 
				PreparedStatement pst = con.prepareStatement(SELECT_ALL_QRY)){
							
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setBookCode(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setPrice(rs.getDouble(3));
				book.setPublishDate(rs.getDate(4).toLocalDate());
				book.setCategory(rs.getString(5));
				
				books.add(book);
			}
						
		}catch(SQLException exp) {
			log.error(exp);
			throw new LibraryException("Sorry! An Error Occured While Fetching Data!");
		}
		return books;
	}

	@Override
	public Book getById(Integer bookCode) throws LibraryException {
		Book book = null;
		try(Connection con=ConnectionProvider.getConnection(); 
				PreparedStatement pst = con.prepareStatement(SELECT_BY_ID_QRY)){
							
			pst.setInt(1, bookCode);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				book = new Book();
				book.setBookCode(rs.getInt(1));
				book.setTitle(rs.getString(2));
				book.setPrice(rs.getDouble(3));
				book.setPublishDate(rs.getDate(4).toLocalDate());
				book.setCategory(rs.getString(5));				
			}
						
		}catch(SQLException exp) {
			log.error(exp);
			throw new LibraryException("Sorry! An Error Occured While Fetching Data!");
		}
		return book;
	}

}
