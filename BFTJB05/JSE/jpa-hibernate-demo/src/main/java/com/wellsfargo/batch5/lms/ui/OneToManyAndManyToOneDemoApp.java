package com.wellsfargo.batch5.lms.ui;

import java.time.LocalDate;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wellsfargo.batch5.lms.entities.Book;
import com.wellsfargo.batch5.lms.entities.Genre;
import com.wellsfargo.batch5.lms.util.JpaUtil;

public class OneToManyAndManyToOneDemoApp {

	public static void main(String[] args) {
		
		Genre g1 = new Genre(105, "Computers");		
		g1.setBooks(new TreeSet<Book>());		
		g1.getBooks().add(new Book(101, "Complete Reference", 5024.0, LocalDate.now(), g1));
		g1.getBooks().add(new Book(102, "Head First JAva", 2024.0, LocalDate.now(), g1));
	
		Genre g2 = new Genre(106, "Science");		
		g2.setBooks(new TreeSet<Book>());		
		g2.getBooks().add(new Book(103, "101 Science Experiements", 8024.0, LocalDate.now(), g2));
		g2.getBooks().add(new Book(104, "101 Magic Tricks", 1024.0, LocalDate.now(), g2));
		
		EntityManager em = JpaUtil.getEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(g1);
		em.persist(g2);
		txn.commit();		
		em.close();
	}

}
