package com.wellsfargo.fsd.cms.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.wellsfargo.fsd.cms.entity.Contact;
import com.wellsfargo.fsd.cms.exception.ContactException;
import com.wellsfargo.fsd.cms.service.ContactService;
import com.wellsfargo.fsd.cms.service.ContactServiceImpl;

public class CMSApplication {

	public static final ContactService contactService = new ContactServiceImpl();
	public static final Scanner scanner = new Scanner(System.in);

	private static void doAdd() {

		Contact contact = new Contact();
		
		System.out.print("ContactId> ");
		contact.setContactId(scanner.nextInt());
		System.out.print("Name> ");
		contact.setFullName(scanner.next());
		System.out.print("DateOfBirth(yyyy-MM-dd)> ");
		contact.setDateOfBirth(LocalDate.parse(scanner.next()));
		System.out.print("Mobile Number> ");
		contact.setMobile(scanner.next());
				
		try {
			contactService.validateAndAdd(contact);
			System.out.println("Contact Got Added!");
		} catch (ContactException exp) {
			System.out.println(exp.getMessage());
		}
	}

	private static void doDelete() {
		try {
			System.out.println("Contact Id: ");
			int contactId = scanner.nextInt();

			boolean isDeleted = contactService.deleteContact(contactId);

			if (!isDeleted) {
				System.out.println("No Such Record Found.");
			} else {
				System.out.println("Contact Deleted!");
			}
		} catch (ContactException exp) {
			System.out.println(exp.getMessage());
		}
	}

	private static void doFind() {

		try {
			System.out.println("Contact Id: ");
			int contactId = scanner.nextInt();

			Contact contact = contactService.getContact(contactId);

			if (contact == null) {
				System.out.println("No Such Record Found.");
			} else {
				System.out.println(contact);
			}
		} catch (ContactException exp) {
			System.out.println(exp.getMessage());
		}

	}

	private static void doList() {

		try {
			List<Contact> contacts = contactService.getAllContacts();

			if (contacts == null) {
				System.out.println("No Records To Display.");
			} else {
				for (Contact c : contacts) {
					System.out.println(c);
				}
			}
		} catch (ContactException exp) {
			System.out.println(exp.getMessage());
		}

	}

	public static void main(String[] args) {

		Menu[] menus = Menu.values();
		Menu selectedMenu = null;

		while (selectedMenu != Menu.QUIT) {
			System.out.println("Choice\tOperation");
			for (Menu m : menus) {
				System.out.println(m.ordinal() + "\t" + m);
			}

			System.out.print("Choice> ");
			int ch = scanner.nextInt();

			if (ch >= 0 && ch < menus.length) {
				selectedMenu = menus[ch];

				switch (selectedMenu) {
				case ADD:
					doAdd();
					break;
				case LIST:
					doList();
					break;
				case FIND:
					doFind();
					break;
				case DELETE:
					doDelete();
					break;
				}
			} else {
				selectedMenu = null;
				System.out.println("Unkown Choice");
			}
		}

		scanner.close();
		System.out.println("APPLICATION TERMINATED!");
	}

}
