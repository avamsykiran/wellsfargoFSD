package com.wellsfargo.batch5.lms.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wellsfargo.batch5.lms.entities.BankAccount;
import com.wellsfargo.batch5.lms.entities.Librarian;
import com.wellsfargo.batch5.lms.entities.LibraryMember;
import com.wellsfargo.batch5.lms.entities.LibraryUser;
import com.wellsfargo.batch5.lms.util.JpaUtil;

public class OneToOneAggregationMapping {

	public static void main(String[] args) {
		
		Librarian u = new Librarian(null, "user15","pwd15", "ADMIN","Kiran",25000.0);
		u.setSalAccount(new BankAccount(10101L, "SBI0007", u));
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(u);		
		txn.commit();
		em.close();

	}

}
