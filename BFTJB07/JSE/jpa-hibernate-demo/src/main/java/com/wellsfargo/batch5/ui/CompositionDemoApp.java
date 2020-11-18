package com.wellsfargo.batch5.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wellsfargo.batch5.entities.AdbEmployee;
import com.wellsfargo.batch5.entities.AdbSubscriber;
import com.wellsfargo.batch5.entities.AdbUser;
import com.wellsfargo.batch5.entities.AddressGroup;
import com.wellsfargo.batch5.entities.ContactDetails;
import com.wellsfargo.batch5.util.JpaUtil;

public class CompositionDemoApp {

	public static void main(String[] args) {

		AdbSubscriber u = new AdbSubscriber(null, "u4", "pwd4", "SUBSCRIBER", "Suseela","Aripaka");
		u.setSubscriberContactDetails(new ContactDetails("9000000001", "x@x.co", "45-5/1",null, "Vizag", "AP"));
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(u);
		txn.commit();
		em.close();
	}
}
