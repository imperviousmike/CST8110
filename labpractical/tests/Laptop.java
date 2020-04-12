package tests;

import java.util.Scanner;

public class Laptop {

	private long laptopId;
	private String laptopBrand;
	private double price, finalPrice, applicableTaxes;

	public Laptop() {
		this.laptopId = 100101;
		this.laptopBrand = "Acer";
		this.price = 550.0;
		this.applicableTaxes = 17.0;

	}

	public Laptop(long laptopId, String laptopBrand, double price, double applicableTaxes) {

		this.laptopId = laptopId;
		this.laptopBrand = laptopBrand;
		this.price = price;
		this.applicableTaxes = applicableTaxes;

	}

	public void readLaptopInfo() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Enter laptop ID: ");
			this.laptopId = input.nextLong();
			System.out.print("Enter laptop brand: ");
			this.laptopBrand = input.next();

			do {
				System.out.print("Enter price: ");
				this.price = input.nextDouble();
				if (this.price < 0) {
					System.out.println("Prices should be positive");
				}
			} while (this.price < 0);

			System.out.print("Enter applicable taxes: ");
			this.applicableTaxes = input.nextDouble();
		}

	}

	public void calculateFinalPrice() {
		this.finalPrice = this.price + (this.price * (this.applicableTaxes * .01));
	}

	public void displayLaptopInfo() {

		System.out.format("laptop Id: %d Brand: %s Applicable Taxes: %.1f%% Final Price: $%.2f\n", this.laptopId,
				this.laptopBrand, this.applicableTaxes, this.finalPrice);
	}
}
