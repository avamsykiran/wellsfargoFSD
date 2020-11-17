package com.wellsfargo.batch5.lms.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wellsfargo.batch5.lms.entities.Librarian;
import com.wellsfargo.batch5.lms.entities.LibraryMember;
import com.wellsfargo.batch5.lms.entities.LibraryUser;
import com.wellsfargo.batch5.lms.util.JpaUtil;

public class IsARelationMappingDemo {

	public static void main(String[] args) {
		
		LibraryUser u1 = new LibraryUser(null, "user1","pwd1", "USER");
		Librarian u2 = new Librarian(null, "user2","pwd2", "ADMIN","Vamsy",25000.0);
		LibraryMember u3 = new LibraryMember(null, "user3", "pwd3", "MEMBER", "Suseela", "Aripaka");
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		
		em.persist(u1);
		em.persist(u2);
		em.persist(u3);
		
		txn.commit();
		em.close();

	}

}
