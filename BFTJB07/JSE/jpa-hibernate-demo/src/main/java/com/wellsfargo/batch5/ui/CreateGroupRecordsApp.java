package com.wellsfargo.batch5.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wellsfargo.batch5.entities.AddressGroup;
import com.wellsfargo.batch5.util.JpaUtil;

public class CreateGroupRecordsApp {

	public static void main(String[] args) {
		
		AddressGroup[] groups = new AddressGroup[] {
				new AddressGroup(101, "SCHOOL"),
				new AddressGroup(102, "WORK"),
				new AddressGroup(103, "COLLAGE"),
				new AddressGroup(104, "GYM")				
		};
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		for(AddressGroup g : groups) {
			em.persist(g);
		}
		txn.commit();
		em.close();
	}
}
