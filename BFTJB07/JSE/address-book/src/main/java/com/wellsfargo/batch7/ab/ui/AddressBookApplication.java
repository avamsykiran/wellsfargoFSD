package com.wellsfargo.batch7.ab.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.wellsfargo.batch7.ab.dto.Contact;
import com.wellsfargo.batch7.ab.exception.AddressBookException;
import com.wellsfargo.batch7.ab.service.ContactServiceImpl;
import com.wellsfargo.batch7.ab.service.IContactService;

public class AddressBookApplication {
	
	static IContactService contactService;
	static Scanner scan;

	public static void main(String[] args) {
		
		contactService=new ContactServiceImpl();
		scan = new Scanner(System.in);
		
		int choice = -1;
		
		while(choice!=4) { //quit option is 4
			System.out.println("Choice\t\tOperation");
			System.out.println("============================================");
			System.out.println("1\t\tList all Contacts");
			System.out.println("2\t\tAdd a Contact");
			System.out.println("3\t\tDelete a Contact");
			System.out.println("4\t\tQuit");
			
			System.out.print("Choice> ");
			choice = scan.nextInt();
			
			switch(choice) {
			case 1: doList(); break;
			case 2: doAdd(); break;
			case 3: doDelete(); break;
			case 4: System.out.println("APP CLOSED"); break;
			default:System.out.println("Unknown Choice!"); break;
			}
		}
	}

	static void doAdd() {
		Contact contact =new Contact();
		
		System.out.print("ContactId: ");
		contact.setContactId(scan.nextInt());
		System.out.print("Name: ");
		contact.setName(scan.next());
		System.out.print("Mobile: ");
		contact.setMobile(scan.next());
		System.out.print("Group: ");
		contact.setGroup(scan.next());
		System.out.println("Date Of Birth(yyyy-MM-dd): ");
		contact.setDateOfBirth(LocalDate.parse(scan.next()));
		
		try {
			contactService.add(contact);
			System.out.println("Contact Saved!");
		} catch (AddressBookException e) {
			System.out.println("Err: " + e.getMessage());
		}
	}
	
	static void doList() {
		try {
			List<Contact> contacts = contactService.getAll();
			
			if(contacts==null || contacts.isEmpty()) {
				System.out.println("No Records!");
			}else {
				for(Contact c : contacts) {
					System.out.println(c.getContactId() + "\t"+ c.getName()+"\t"+c.getGroup()+
							"\t"+c.getMobile()+"\t"+c.getDateOfBirth());
				}
			}
		} catch (AddressBookException e) {
			System.out.println("Err: " + e.getMessage());
		}
	}
	
	static void doDelete() {
		System.out.print("ContactId: ");
		int contactId =scan.nextInt();
		
		try {
			contactService.delete(contactId);
			System.out.println("Contact Deleted!");
		} catch (AddressBookException e) {
			System.out.println("Err: " + e.getMessage());
		}
	}
}
