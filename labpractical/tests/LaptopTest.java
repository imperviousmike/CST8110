package tests;

public class LaptopTest {
	
	public static void main(String[] args) {
		System.out.println("Program developed by Michael Daly");
		Laptop laptop1 = new Laptop();
		Laptop laptop2 = new Laptop(100103,"Apple",1200.0,7.0);
		Laptop laptop3 = new Laptop();
		System.out.println("Enter details for laptop 3");
		laptop3.readLaptopInfo();
		System.out.println("laptop details");
		for(int i = 0; i < 12 ; i ++) {
			System.out.print("=");
		}
		System.out.print("\n");
		laptop1.calculateFinalPrice();
		laptop1.displayLaptopInfo();
		laptop2.calculateFinalPrice();
		laptop2.displayLaptopInfo();
		laptop3.calculateFinalPrice();
		laptop3.displayLaptopInfo();
		
		
	}

}
