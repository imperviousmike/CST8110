package lab05;

import java.util.Scanner;

/**
 * This class is for the testing of Count objects
 * 
 * @author Michael Daly
 * @version 1.0
 * @since CST8110 Introduction to Programming
 */

public class CountTest {

	public static void main(String args[]) {

		Count c = new Count();
		int choice;
		System.out.print("Program developed by Michael Daly\n");
		try (Scanner input = new Scanner(System.in)) {
			do {
				System.out.print("\n1) Display Count\n2) Exit\n");
				System.out.print("Enter your selection: ");
				while (!input.hasNextInt()) {
					input.next();
				}
				choice = input.nextInt();

				if (choice == 1) {
					c.getValuesFromUser();
					c.displaySteps();
				} else if (choice == 2) {
					System.out.println("Goodbye!");
				}

				else {
					System.out.print("\n*** INVALID ENTRY ***\n");
				}

			} while (choice != 2);
		}
	}

}
