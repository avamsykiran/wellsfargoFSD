package com.wellsfargo.batch5.ui;

import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wellsfargo.batch5.entities.AddressGroup;
import com.wellsfargo.batch5.entities.Contact;
import com.wellsfargo.batch5.entities.ContactDetails;
import com.wellsfargo.batch5.util.JpaUtil;

public class OneToManyAndManyToOneDemoApp {

	public static void main(String[] args) {
		
		AddressGroup g1 = new AddressGroup(201,"Doctors");
		AddressGroup g2 = new AddressGroup(202,"Emergencies");
		
		g1.setContacts(new TreeSet<>());
		g2.setContacts(new TreeSet<>());

		g1.getContacts().add(new Contact(101L,"Swathi","Mehta",
				new ContactDetails("9898989898", "s@g.com", null,null, "Vizag","AP"),g1));
		g1.getContacts().add(new Contact(102L,"Krupa","Mehta",
				new ContactDetails("9898989899", "k@g.com", null,null, "Vizag","AP"),g1));
		
		g2.getContacts().add(new Contact(103L,"Fire Service",null,
				new ContactDetails("103", "fs@g.com", null,null, "Vizag","AP"),g2));
		g2.getContacts().add(new Contact(104L,"Police Service",null,
				new ContactDetails("100", "ps@g.com", null,null, "Vizag","AP"),g2));
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(g1);
		em.persist(g2);
		txn.commit();
		em.close();
	}
}
