package lab04;

import java.util.Scanner;

/**
 * This class is for the creation of a cash machine object
 * 
 * @author Michael Daly
 * @version 1.0
 * @since CST8110 Introduction to Programming
 */

public class CashMachine {

	private Scanner consoleInput = new Scanner(System.in);
	private int itemCount;
	private double tax;
	private double sum;
	private String receipt;

	public CashMachine(Double tax) {
		this.tax = tax;
	}

	public String getOneStringInput(String input) {
		System.out.print(input);
		return consoleInput.next();
	}

	public double getOneDoubleInput(String input) {
		System.out.print(input);
		return consoleInput.nextDouble();
	}

	public int getItemCount() {
		return itemCount;
	}

	private double calculateTax() {
		return (sum * tax);
	}

	public double caclulateTaxPlusSum() {
		return (sum + calculateTax());
	}

	public boolean processMenu() {
		double selection = getOneDoubleInput("Action >>");
		if (selection == 1) {
			purchaseItem();

		} else if (selection == 2) {
			printReceipt();
		} else if (selection == 3) {
			return false;
		}

		return true;

	}

	private void printReceipt() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		if (itemCount == 0) {
			sb.append("Empty!!");
			System.out.print(sb.toString());
		} else {
			sb.append("Receipt for " + itemCount + " items:");
			sb.append("\n");
			sb.append(receipt);
			sb.append("\n");
			sb.append(String.format("\nTax:		$%.2f", calculateTax()));
			sb.append(String.format("\nTotal:		$%.2f", caclulateTaxPlusSum()));
			System.out.print(sb.toString());
		}

	}

	public void printMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("\n1) Purchase Item");
		sb.append("\n2) Print Receip");
		sb.append("\n3) Quit");
		sb.append("\n");
		System.out.print(sb.toString());
	}

	private void purchaseItem() {
		String item = getOneStringInput("item name (no spaces)>> ");
		double price = getOneDoubleInput("item price >> ");
		++itemCount;
		sum += price;
		if (receipt == null) {
			receipt = new String(String.format("%-15s$%.2f%n", item, price));
		} else {
			receipt = receipt.concat(String.format("%-15s$%.2f%n", item, price));
		}
	}

}
