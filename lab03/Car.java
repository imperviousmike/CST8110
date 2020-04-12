package lab03;

import java.util.Scanner;

/**
 * This class is for the creation and manipulation of the Car object
 * 
 * @author Michael Daly
 * @version 1.0
 * @since CST8110 Introduction to Programming
 */

@SuppressWarnings("resource")
public class Car {

	private String plate;
	private int time;
	private double velocity;

	public Car() {
		plate = "AAAA";
		time = 10;
		velocity = 98.0;
	}

	public Car(String plate, int time, double velocity) {
		this.plate = plate;
		this.time = time;
		this.velocity = velocity;
	}

	public Car(Car car) {
		this.plate = car.plate;
		this.time = car.time;
		this.velocity = car.velocity;
	}

	public void inputPlate() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the plate: ");
		plate = input.nextLine();
	}

	public void inputTime() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the time: ");
		time = input.nextInt();

	}

	public void inputVelocity() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the velocity: ");
		velocity = input.nextDouble();
	}

	public void displayCar() {
		StringBuilder sb = new StringBuilder();
		sb.append("Plate is " + plate);
		sb.append(" with a time of " + time);
		sb.append(", velocity of " + velocity);
		System.out.println(sb.toString());
	}

	public String calcAcceleration() {
		return String.format("%.2f", (velocity / time));
	}

}
