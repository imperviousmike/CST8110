package lab02;

import java.util.Scanner; //program uses class Scanner

/**
 * This program prompts the user to enter a number and then display the entered
 * number
 * 
 * @author Anu Thomas modified by Michael Daly
 * @version 1.1
 * @since 2019-09-16 CST8110 Introduction to Programming
 */

public class JavaMain {
	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		int firstNumber = 0;
		int secondNumber = 0;

		System.out.println("This program reads two numbers, finds the sum and displays it.");

		System.out.print("Enter first number: ");
		firstNumber = input.nextInt();
		System.out.print("Enter second number: ");
		secondNumber = input.nextInt();

		System.out.println("\nSum of " + firstNumber + " and " + secondNumber + " is " + (firstNumber + secondNumber));

		input.close();

	} // end of main
}// end of class
