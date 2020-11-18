package com.wellsfargo.batch5.lms.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.wellsfargo.batch5.lms.entities.Book;
import com.wellsfargo.batch5.lms.util.JpaUtil;

public class JpaRetrivalDemoApp {

	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEntityManager();
		
		Book book = em.find(Book.class, 102);
		System.out.println(book);
		
		String qryText = "SELECT b FROM Book b WHERE b.price>=:limit";
		
		TypedQuery<Book> qry = em.createQuery(qryText, Book.class);
		qry.setParameter("limit", 4500.0);
		List<Book> books = qry.getResultList();
		for(Book b:books) {
			System.out.println(b);
		}
	}

}
