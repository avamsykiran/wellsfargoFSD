package com.wellsfargo.jpahd.ui;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.wellsfargo.jpahd.entity.Employee;

public class EmployeeApp2 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		EntityManager em = emf.createEntityManager();
		
		Scanner kbScan = new Scanner(System.in);
		
		boolean shallContinue=true;

		while(shallContinue) {
		
			System.out.println("Enter Employee Id: ");
			long empId = kbScan.nextLong();
			
			Employee emp = em.find(Employee.class, empId);
			if(emp!=null) {
				System.out.println(emp.getFirstName() + " " + emp.getLastName());
			}else {
				System.out.println("Emp Not Found");
			}
			
			System.out.println("Continue? (true/false): ");
			shallContinue=kbScan.nextBoolean();
		}
		
		em.close();
		kbScan.close();
	}

}
