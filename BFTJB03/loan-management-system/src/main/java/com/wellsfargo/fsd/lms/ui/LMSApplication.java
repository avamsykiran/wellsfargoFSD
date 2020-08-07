package com.wellsfargo.fsd.lms.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.wellsfargo.fsd.lms.entity.Loan;
import com.wellsfargo.fsd.lms.exception.LoanException;
import com.wellsfargo.fsd.lms.service.LoanService;
import com.wellsfargo.fsd.lms.service.LoanServiceImpl;

public class LMSApplication {

	public static final Scanner scanner = new Scanner(System.in);
	public static final LoanService loanService = new LoanServiceImpl();

	public static void main(String[] args) {
		Menu[] menus = Menu.values();

		Menu menuSelected = null;

		while (menuSelected != Menu.QUIT) {
			System.out.println("Choice\tOperation");
			for (Menu m : menus) {
				System.out.println(m.ordinal() + "\t" + m);
			}

			System.out.print("Choice> ");
			int ch = scanner.nextInt();

			if (ch >= 0 && ch < menus.length) {
				menuSelected = menus[ch];

				switch (menuSelected) {
				case ADD:
					doAdd();
					break;
				case FIND:
					doFind();
					break;
				case LIST:
					doList();
					break;
				case DELETE:
					doDelete();
					break;
				}

			} else {
				System.out.println("Unknown Choice");
				menuSelected = null;
			}
		}

		scanner.close();
		System.out.println("APPLICATION TERMINATED");
	}

	private static void doAdd() {

		Loan loan = new Loan();
		
		System.out.print("LoanId> ");
		loan.setLoanId(scanner.nextInt());
		System.out.print("Principal: ");
		loan.setPrincipal(scanner.nextDouble());
		System.out.print("Rate Of Interest: ");
		loan.setRateOfInterest(scanner.nextDouble());
		System.out.print("Status: ");
		loan.setStatus(scanner.next());
		System.out.print("EmiCount: ");
		loan.setEmiCount(scanner.nextInt());
		System.out.print("Disburment Date(yyyy-MM-dd)> ");
		loan.setDateOfDisbursment(LocalDate.parse(scanner.next()));
		
		try {
			loanService.validateAndAdd(loan);
			System.out.println("Loan Added!");
		}catch(LoanException exp) {
			System.out.println(exp.getMessage());
		}
	}

	private static void doFind() {
		System.out.println("LoanId> ");
		int loanId = scanner.nextInt();

		try {
			Loan loan = loanService.getLoan(loanId);

			if (loan == null) {
				System.out.println("No Such Record Found");
			} else {
				System.out.println(loan);
			}
		} catch (LoanException exp) {
			System.out.println(exp.getMessage());
		}

	}

	private static void doList() {

		try {
			List<Loan> loans = loanService.getAllLoans();

			if (loans == null) {
				System.out.println("No Records To Display");
			} else {
				for (Loan l : loans) {
					System.out.println(l);
				}
			}
		} catch (LoanException exp) {
			System.out.println(exp.getMessage());
		}

	}

	private static void doDelete() {
		System.out.println("LoanId> ");
		int loanId = scanner.nextInt();

		try {
			boolean isDeleted = loanService.deleteLoan(loanId);

			if (!isDeleted) {
				System.out.println("No Such Record Found");
			} else {
				System.out.println("Loan is deleted!");
			}
		} catch (LoanException exp) {
			System.out.println(exp.getMessage());
		}
	}

}
