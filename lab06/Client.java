package lab06;

import java.util.Scanner;

public class Client {

	private String name;
	private int clientNumber;

	Client() {
		this("unassigned", -1);
	}

	Client(String name, int clientNumber) {
		this.name = name;
		this.clientNumber = clientNumber;
	}

	public void keyboardClientInfo() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("\nClient name: ");
			this.name = input.nextLine();
			System.out.print("Client number: ");
			this.clientNumber = input.nextInt();
			System.out.print("\n");
		}
	}

	public void displayClientInfo() {
		System.out.format("Client name: %s\tClient Number: %d\n", this.name, this.clientNumber);
	}

	public static void main(String[] args) {
		final int numOfClients = 2;
		Client[] clients = new Client[numOfClients];

		for (int i = 0; i < numOfClients; i++) {
			System.out.println("Enter information for Client " + (i + 1));
			clients[i] = new Client();
			clients[i].keyboardClientInfo();
		}

		System.out.println("List of Clients:\n");
		for (Client c : clients) {
			c.displayClientInfo();
		}

	}

}
