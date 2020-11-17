package com.wellsfargo.batch5.lms.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wellsfargo.batch5.lms.entities.Genre;
import com.wellsfargo.batch5.lms.util.JpaUtil;

public class CreateGenresApp {

	public static void main(String[] args) {
		Genre g1 = new Genre(101, "Fiction");
		Genre g2 = new Genre(102, "Technology");
		Genre g3 = new Genre(103, "Science");
		Genre g4 = new Genre(104, "Kids");
		
		EntityManager em = JpaUtil.getEntityManager();
		
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(g1);
		em.persist(g2);
		em.persist(g3);
		em.persist(g4);
		txn.commit();
		System.out.println("Generes Saved!");
		em.close();
	}

}
