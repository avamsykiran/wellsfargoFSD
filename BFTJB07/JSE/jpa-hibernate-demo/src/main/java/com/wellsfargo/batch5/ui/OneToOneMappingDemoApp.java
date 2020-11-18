package com.wellsfargo.batch5.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.wellsfargo.batch5.entities.AdbEmployee;
import com.wellsfargo.batch5.entities.AdbSubscriber;
import com.wellsfargo.batch5.entities.AdbUser;
import com.wellsfargo.batch5.entities.AddressGroup;
import com.wellsfargo.batch5.entities.BankAccount;
import com.wellsfargo.batch5.util.JpaUtil;

public class OneToOneMappingDemoApp {

	public static void main(String[] args) {

		AdbEmployee u = new AdbEmployee(null,"u15","pwd15","ADMIN","Kiran",25000.0);
		u.setSalAccount(new BankAccount(10101L, "IN0098", u));

		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();		
		em.persist(u);
		txn.commit();
		em.close();
	}
}
