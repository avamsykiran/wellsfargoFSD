package com.wellsfargo.jpahd.ui;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.wellsfargo.jpahd.entity.ContractEmployee;
import com.wellsfargo.jpahd.entity.Employee;
import com.wellsfargo.jpahd.entity.Manager;

public class EmployeeApp {

	public static void main(String[] args) {

		Employee emp = new Employee(101L, "Vamsy", "Aripaka", 25000.0, LocalDate.now());
		Manager mgr = new Manager(102L, "Srinu", "Dachepalli", 55000.0, LocalDate.now(), 8525.0);
		ContractEmployee cemp = new ContractEmployee(103L, "Suseela", "Aripaka", 35000.0, LocalDate.now(), 12);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();

		EntityTransaction txn = em.getTransaction();

		txn.begin();

		em.persist(emp);
		em.persist(mgr);
		em.persist(cemp);

		txn.commit();
		
		System.out.println("Data saved!");
		em.close();
	}

}
