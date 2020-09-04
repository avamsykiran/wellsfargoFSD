package com.wellsfargo.jpahd.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.wellsfargo.jpahd.entity.ContractEmployee;
import com.wellsfargo.jpahd.entity.Employee;
import com.wellsfargo.jpahd.entity.Manager;

public class RetriveUI {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();

		final String eQry = "SELECT e FROM Employee e";
		final String mQry = "SELECT m FROM Manager m";
		final String ceQry = "SELECT e FROM ContractEmployee e";
		
		List<Employee> emps = em.createQuery(eQry, Employee.class).getResultList();
		
		for(Employee e : emps) {
			System.out.println(e.getFirstName());
		}
		
		List<Manager> mgrs = em.createQuery(mQry, Manager.class).getResultList();
		for(Manager m : mgrs) {
			System.out.println(m.getFirstName());
		}
		
		List<ContractEmployee> cemps = em.createQuery(ceQry, ContractEmployee.class).getResultList();
		for(ContractEmployee e : cemps) {
			System.out.println(e.getFirstName());
		}
		
		em.close();
	}

}
