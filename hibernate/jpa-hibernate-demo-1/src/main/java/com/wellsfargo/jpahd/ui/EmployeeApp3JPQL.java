package com.wellsfargo.jpahd.ui;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.wellsfargo.jpahd.entity.Employee;

public class EmployeeApp3JPQL {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();

		String qryText = "SELECT e FROM Employee e"; // JPQL

		// Query empQry = em.createQuery(qryText);

		TypedQuery<Employee> empQry = em.createQuery(qryText, Employee.class);

		List<Employee> emps = empQry.getResultList();

		for (Employee emp : emps) {
			System.out.println(emp.getEmpNo() + "\t" + emp.getFirstName() + "\t" + emp.getLastName() + "\t"
					+ emp.getJoinDate() + "\t" + emp.getBasic());
		}

		System.out.println("---------------------------------------------------");

		TypedQuery<Employee> empQry2 = em.createQuery("SELECT e FROM Employee e WHERE e.basic between 10000 and 55000",
				Employee.class);

		List<Employee> emps2 = empQry2.getResultList();

		for (Employee emp : emps2) {
			System.out.println(emp.getEmpNo() + "\t" + emp.getFirstName() + "\t" + emp.getLastName() + "\t"
					+ emp.getJoinDate() + "\t" + emp.getBasic());
		}

		System.out.println("---------------------------------------------------");

		// named Params

		TypedQuery<Employee> empQry3 = em
				.createQuery("SELECT e FROM Employee e WHERE e.basic between :limit1 and :limit2", Employee.class);

		empQry3.setParameter("limit1", 55000.0);
		empQry3.setParameter("limit2", 95000.0);

		List<Employee> emps3 = empQry3.getResultList();

		for (Employee emp : emps3) {
			System.out.println(emp.getEmpNo() + "\t" + emp.getFirstName() + "\t" + emp.getLastName() + "\t"
					+ emp.getJoinDate() + "\t" + emp.getBasic());
		}

		System.out.println("---------------------------------------------------");

		// named Querys

		TypedQuery<Employee> empQry4 = em.createNamedQuery("listEmpsWithLastName", Employee.class);

		empQry4.setParameter("lnm", "Aripaka");

		List<Employee> emps4 = empQry4.getResultList();

		for (Employee emp : emps4) {
			System.out.println(emp.getEmpNo() + "\t" + emp.getFirstName() + "\t" + emp.getLastName() + "\t"
					+ emp.getJoinDate() + "\t" + emp.getBasic());
		}

		em.close();
	}

}
