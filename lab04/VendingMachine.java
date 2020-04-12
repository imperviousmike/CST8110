package lab04;

import java.util.Scanner;

/**
 * This class is for the manipulation and creation of vending machine objects
 * 
 * @author Michael Daly
 * @version 1.0
 * @since CST8110 Introduction to Programming
 */

public class VendingMachine {

	private final int APPLE = 1;
	private final int GRAPES = 2;
	private final int GRAPEFRUIT = 3;
	private int total;
	private int appleCount;
	private int grapesCount;
	private int grapeFruitCount;

	public VendingMachine() {

	}

	private void printReceipt() {

		System.out.println(appleCount + " Apples... $1");
		System.out.println(grapesCount + " Grapes... $2");
		System.out.println(grapeFruitCount + " Grapefruit... $3");
		System.out.println("Your total is $" + total + "\n");
	}

	private void purchaseItem() {

		String choice;

		System.out.println("Choose an item ");
		try (Scanner input = new Scanner(System.in)) {
			choice = input.next();
		}

		if (choice.equalsIgnoreCase("Apple")) {
			total += APPLE;
			++appleCount;

		} else if (choice.equalsIgnoreCase("Grapes")) {
			total += GRAPES;
			++grapesCount;

		} else if (choice.equalsIgnoreCase("Grapefruit")) {
			total += GRAPEFRUIT;
			++grapeFruitCount;
		} else {
			System.out.print("Invalid choice, please enter a valid choice\n");
		}
		System.out.println("\n");

	}

	private void printMenu() {
		System.out.println("Welcome to the vending machine, please choose an item: ");
		System.out.println("Apple... $1");
		System.out.println("Grapes... $2");
		System.out.println("Grapefruit... $3");
		System.out.println("\n1) Purchase an item");
		System.out.println("2) Print receipt");
		System.out.println("3) Quit");

	}

	public void runLoop() {

		boolean infinite = true;
		try (Scanner input = new Scanner(System.in)) {

			while (infinite == true) {
				printMenu();
				int choice = input.nextInt();
				switch (choice) {
				case (1):
					purchaseItem();
					break;
				case (2):
					printReceipt();
					break;
				case (3):
					infinite = Boolean.FALSE;
				}

			}

		}
	}

}
