package com.wellsfargo.fsd.ims.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.wellsfargo.fsd.ims.entity.Item;
import com.wellsfargo.fsd.ims.exception.ImsException;
import com.wellsfargo.fsd.ims.service.ItemService;
import com.wellsfargo.fsd.ims.service.ItemServiceImpl;

public class IMSApplication {

	public static final Scanner scanner = new Scanner(System.in);
	public static final ItemService itemService = new ItemServiceImpl();

	public static void main(String[] args) {

		Menu menu = null;

		while (menu != Menu.QUIT) {
			System.out.println("Choice\tOperation");
			for (Menu m : Menu.values()) {
				System.out.println(m.ordinal() + "\t" + m);
			}

			System.out.print("Choice> ");
			int ordinal = scanner.nextInt();

			if (ordinal < 0 || ordinal >= Menu.values().length) {
				System.out.println("Unknown Choice!");
				menu = null;
			} else {
				menu = Menu.values()[ordinal];
				switch (menu) {
				case ADD:
					doAdd();
					break;
				case DELETE:
					doDelete();
					break;
				case FIND:
					doFind();
					break;
				case LIST:
					doList();
					break;
				}
			}
		}

		System.out.println("APOPLICATION TERMINATED!!");

	}

	private static void doAdd() {
		try {
			Item item = new Item();

			System.out.print("Icode> ");
			item.setIcode(scanner.nextInt());
			System.out.print("Title> ");
			item.setTitle(scanner.next());
			System.out.print("Unit> ");
			item.setUnit(scanner.next());
			System.out.print("PackageDate(yyyy-MM-dd)> ");
			item.setPackageDate(LocalDate.parse(scanner.next()));
			System.out.print("IsFragile(true/false)> ");
			item.setFragile(scanner.nextBoolean());
			System.out.println("CostPrice> ");
			item.setCostPrice(scanner.nextDouble());
			System.out.println("SellingPrice> ");
			item.setSellingPrice(scanner.nextDouble());

			itemService.validateAndAdd(item);
			System.out.println("Item Added!");
		} catch (ImsException exp) {
			System.out.println(exp.getMessage());
		}

	}

	private static void doDelete() {
		System.out.print("ICODE> ");
		int icode = scanner.nextInt();

		try {
			boolean isDeleted = itemService.deleteItem(icode);

			if (isDeleted) {
				System.out.println("Item Deleted!");
			} else {
				System.out.println("Sorry, no such item found");
			}
		} catch (ImsException exp) {
			System.out.println(exp.getMessage());
		}

	}

	private static void doFind() {
		System.out.print("ICODE> ");
		int icode = scanner.nextInt();

		try {
			Item item = itemService.getItemById(icode);

			if (item == null) {
				System.out.println("No Such Item Found!");
			} else {
				System.out.println(item);
			}
		} catch (ImsException exp) {
			System.out.println(exp.getMessage());
		}

	}

	private static void doList() {
		try {
			List<Item> items = itemService.getAllItems();

			if (items == null) {
				System.out.println("No records in the database! Try adding one.");
			} else {
				for (Item item : items) {
					System.out.println(item);
				}
			}

		} catch (ImsException exp) {
			System.out.println(exp.getMessage());
		}

	}
}
