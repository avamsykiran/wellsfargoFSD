package com.wellsfargo.jpahd.ui;

import java.time.LocalDate;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.wellsfargo.jpahd.entity.Address;
import com.wellsfargo.jpahd.entity.BankAccount;
import com.wellsfargo.jpahd.entity.Department;
import com.wellsfargo.jpahd.entity.Employee;

public class EmployeeApp {

	public static void main(String[] args) {

		Department dept1 = new Department(null,"Operations");
		Department dept2 = new Department(null,"Development");
		
		BankAccount ba1 = new BankAccount(12201L, "DWK", "IndusInd");
		BankAccount ba2 = new BankAccount(10202L, "AKP", "SBI");
		BankAccount ba3 = new BankAccount(22203L, "TUNI", "CityBank");
		BankAccount ba4 = new BankAccount(12404L, "DWK", "HDFC");
		
		Address a1 = new Address("4-16/1", "DWK", "VIZAG");
		Address a2 = new Address("5-16/1", "TUNI", "VIZAG");
		Address a3 = new Address("6-10/1", "GandhiMarg", "DELHI");
		Address a4 = new Address("4-21/1", "DWK", "VIZAG");
		
		Employee e1 = new Employee(101L, "Vinay", "Gandhi", 10345.0, LocalDate.now(),a1,ba1,dept1);
		Employee e2 = new Employee(102L, "Kiran", "Varma", 10245.0, LocalDate.now(),a2,ba2,dept1);
		Employee e3 = new Employee(103L, "Sunitha", "Sastri", 20345.0, LocalDate.now(),a3,ba3,dept2);
		Employee e4 = new Employee(104L, "Ankita", "Gupta", 13345.0, LocalDate.now(),a4,ba4,dept2);
		
		ba1.setAccountHolder(e1);
		ba2.setAccountHolder(e2);
		ba3.setAccountHolder(e3);
		ba4.setAccountHolder(e4);
		
		dept1.setEmployees(new TreeSet<Employee>());
		dept1.getEmployees().add(e1);
		dept1.getEmployees().add(e2);
		dept2.setEmployees(new TreeSet<Employee>());
		dept2.getEmployees().add(e3);
		dept2.getEmployees().add(e4);
				
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();

		EntityTransaction txn = em.getTransaction();

		txn.begin();
		em.persist(dept1);
		em.persist(dept2);
		txn.commit();
		System.out.println("Data is saved!");
		
		em.close();
	}
}
