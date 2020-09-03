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

		Department d1 = new Department(null, "Accounts");
		Department d2 = new Department(null, "Sales");
		
		d1.setEmployees(new TreeSet<Employee>());
		d1.getEmployees().add(
				new Employee(101L,"Vamsy","Aripaka",2500.0,LocalDate.now(),
						new Address("4-16/1", "DWK", "Vizag"),
						new BankAccount(100012L, "DWK", "IndusInd Bank"),d1));
		
		d1.getEmployees().add(
				new Employee(102L,"Suseela","Aripaka",1500.0,LocalDate.now(),
						new Address("4-16/1", "DWK", "Vizag"),
						new BankAccount(100013L, "DWK", "IndusInd Bank"),d1));
		
		for(Employee e:d1.getEmployees()) {
			e.getSalAccount().setAccountHolder(e);
		}
		
		d2.setEmployees(new TreeSet<Employee>());
		d2.getEmployees().add(new Employee(103L,"Sagar","Aripaka",2500.0,LocalDate.now(),
				new Address("4-16/1", "DWK", "Vizag"),
				new BankAccount(100014L, "DWK", "IndusInd Bank"),d2));

		d2.getEmployees().add(new Employee(104L,"Srinu","Dachepalli",2500.0,LocalDate.now(),
				new Address("4-17/2", "DWK", "Vizag"),
				new BankAccount(100015L, "DWK", "IndusInd Bank"),d2));

		for(Employee e:d2.getEmployees()) {
			e.getSalAccount().setAccountHolder(e);
		}	

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();

		EntityTransaction txn = em.getTransaction();

		txn.begin();
		em.persist(d1);
		em.persist(d2);
		txn.commit();
		System.out.println("Employee is saved!");
		
		em.close();
	}
}
