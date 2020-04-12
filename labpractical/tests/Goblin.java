package tests;

import java.util.Scanner;

public class Goblin {

	int goblinNumber;
	String name;
	double gold, cleverness, greed;
	Scanner input = new Scanner(System.in);

	public Goblin() {
		this(-1, "unknown", 0, 0);
		this.gold = 0;
	}

	public Goblin(int goblinNumber, String name, double cleverness, double greed) {
		this.goblinNumber = goblinNumber;
		this.name = name;
		this.cleverness = cleverness;
		this.greed = greed;
	}

	public void inputGoblinDetails() {
		System.out.print("Goblin Number: ");
		this.goblinNumber = input.nextInt();
		System.out.print("Goblin Name: ");
		this.name = input.next();
		System.out.print("Cleverness: ");
		this.cleverness = input.nextDouble();
		while (cleverness < 1 || cleverness > 100) {
			System.out.println("Value must be between 1 and 100");
			this.cleverness = input.nextDouble();
		}
		System.out.print("Greed: ");
		this.greed = input.nextDouble();
		while (greed < 1 || greed > 100) {
			System.out.println("Value must be between 1 and 100");
			this.greed = input.nextDouble();
		}
	}

	public void calculateGold() {
		this.gold = (((this.greed - 1) * (this.cleverness)) / 1000);
	}

	public void print() {
		System.out.print("Goblin #:   " + this.goblinNumber + "   ");
		System.out.print("Name:   " + this.name + "   ");
		System.out.format("Cleverness:   %.2f   ", this.cleverness);
		System.out.format("Greed:   %.2f   ", this.greed);
		System.out.format("Gold:   %.2f   ", this.gold);
		if (gold < 1) {
			System.out.print("poor golbin");
		} else if (gold <= 6) {
			System.out.print("promising goblin");
		} else if (gold > 6) {
			System.out.print("this goblin will go far");
		} else {
			System.out.print("not sure about this goblin");
		}
		System.out.print("\n");
	}

}
