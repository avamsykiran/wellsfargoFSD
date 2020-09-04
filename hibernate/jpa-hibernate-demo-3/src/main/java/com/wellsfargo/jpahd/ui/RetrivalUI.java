package com.wellsfargo.jpahd.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RetrivalUI {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();

		//retrive data on composition...
		List<Object[]> data1 = em.createQuery("SELECT e.firstName,e.address.doorNumber,e.address.city FROM Employee e").getResultList();
		for(Object[] row : data1) {
			System.out.println(row[0] + "\t" +row[1] +"\t"+row[2]);
		}
		System.out.println("---------------------------------------------");

		//retrive data on OneToOne
		List<Object[]> data2 = em.createQuery("SELECT e.firstName,e.salAccount.bank,e.salAccount.branch FROM Employee e").getResultList();
		for(Object[] row : data2) {
			System.out.println(row[0] + "\t" +row[1] +"\t"+row[2]);
		}
		System.out.println("---------------------------------------------");

		
		em.close();
	}

}
