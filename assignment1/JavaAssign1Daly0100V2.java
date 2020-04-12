package assignment1;

import java.util.Scanner;

/**
 * This program runs a simple Mad Libs game with input and output
 * 
 * @author Michael Daly
 * @version 1.0
 * @since 2019-10-04 CST8110 Introduction to Programming
 */

public class JavaAssign1Daly0100V2 {

	public static void main(String args[]) {
		Scanner inputDaly0100 = new Scanner(System.in);

		System.out.print("Please enter a silly word: ");
		String firstSillyDaly0100 = inputDaly0100.nextLine();
		System.out.print("Please enter a last name: ");
		String lastNameDaly0100 = inputDaly0100.nextLine();
		System.out.print("Please enter an illness: ");
		String illnessDaly0100 = inputDaly0100.nextLine();
		System.out.print("Please enter a plural noun: ");
		String pNounDaly0100 = inputDaly0100.nextLine();
		System.out.print("Please enter an adjective: ");
		String firstAdjDaly0100 = inputDaly0100.nextLine();
		System.out.print("Please enter an adjective: ");
		String secAdjDaly0100 = inputDaly0100.nextLine();
		System.out.print("Please enter a silly word: ");
		String secondSillyDaly0100 = inputDaly0100.nextLine();
		System.out.print("Please enter a place: ");
		String placeDaly0100 = inputDaly0100.nextLine();
		System.out.print("Please enter a number: ");
		String numDaly0100 = inputDaly0100.nextLine();
		System.out.print("Please enter an adjective: ");
		String thirdAdjDaly0100 = inputDaly0100.nextLine();

		System.out.println("\nDear School Nurse: \n");
		System.out.println(firstSillyDaly0100 + " " + lastNameDaly0100
				+ " will not be attending school todday. He/she has come down with");
		System.out.println("a case of " + illnessDaly0100 + " and has horrible " + pNounDaly0100 + " and a/an "
				+ firstAdjDaly0100 + " fever. We have made");
		System.out.println("an appointment with the " + secAdjDaly0100 + " Dr. " + secondSillyDaly0100
				+ ", who studied for many years in");
		System.out.println(
				placeDaly0100 + " and has " + numDaly0100 + " degrees in pediatrics. He will send you all the");
		System.out.println("information you need. Thank you! \n\nSincerely\n Mrs. " + thirdAdjDaly0100);
		System.out.println("\nThank you for playing a Mad Libs with me!");

		inputDaly0100.close();
	}

}
