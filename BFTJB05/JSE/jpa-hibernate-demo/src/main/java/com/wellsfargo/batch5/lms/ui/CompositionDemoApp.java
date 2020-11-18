package com.wellsfargo.batch5.lms.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wellsfargo.batch5.lms.entities.ContactDetails;
import com.wellsfargo.batch5.lms.entities.Librarian;
import com.wellsfargo.batch5.lms.entities.LibraryMember;
import com.wellsfargo.batch5.lms.entities.LibraryUser;
import com.wellsfargo.batch5.lms.util.JpaUtil;

public class CompositionDemoApp {

	public static void main(String[] args) {
		
		LibraryMember u = new LibraryMember(null, "user4", "pwd4", "MEMBER", "Indhikaa", "Aripaka");
		u.setAddress(new ContactDetails("9000000007", "#45/6-7,Gandhi Road", null, "Banglore"));
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(u);		
		txn.commit();
		em.close();

	}

}
