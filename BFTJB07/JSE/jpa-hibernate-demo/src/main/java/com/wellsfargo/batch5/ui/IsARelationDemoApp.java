package com.wellsfargo.batch5.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wellsfargo.batch5.entities.AdbEmployee;
import com.wellsfargo.batch5.entities.AdbSubscriber;
import com.wellsfargo.batch5.entities.AdbUser;
import com.wellsfargo.batch5.entities.AddressGroup;
import com.wellsfargo.batch5.util.JpaUtil;

public class IsARelationDemoApp {

	public static void main(String[] args) {

		AdbUser u1 = new AdbUser(null, "usr1", "pwd1", "DUMMY");
		AdbEmployee u2 = new AdbEmployee(null,"u2","pwd2","ADMIN","Vamsy",25000.0);
		AdbSubscriber u3 = new AdbSubscriber(null, "u3", "pwd3", "SUBSCRIBER", "Indhikaa","Aripaka");

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
