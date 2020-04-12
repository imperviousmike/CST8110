package practice;

import java.util.Scanner;

public class Account {

	private long accountNumber;
	private String name;
	double balance, interestPercent, interestAmount;

	public Account() {
		accountNumber = 100;
		name = "Not Set";
		balance = 100;
		interestPercent = 0.01;

	}

	public Account(long accountNumber, String name, double balance, double interestPercent) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.interestPercent = interestPercent;
	}

	public void readInfo() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter the account number: ");
			accountNumber = input.nextLong();
			System.out.print("Enter name: ");
			name = input.next();
			System.out.print("Enter balance: ");
			balance = input.nextDouble();
			System.out.println("Enter interest percentage: ");
			interestPercent = input.nextDouble();
			while (interestPercent < 0) {
				System.err.print("Interest percent cannot be negative. Please reenter: ");
				interestPercent = input.nextDouble();
			}
		}

	}

	public void calculateInterest() {

		interestAmount = balance * (interestPercent / 100);

	}

	public void displayInfo() {
		System.out.print("\nAccount number:\t" + accountNumber);
		System.out.print("\tName:\t" + name);
		System.out.format("\tBalance:\t%.2f", balance);
		System.out.format("\tInterest Percentage:\t%.2f", interestPercent);
		System.out.format("\tInterest:\t%.2f", interestAmount);

	}

}
