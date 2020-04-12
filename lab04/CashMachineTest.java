package lab04;
/**
 * This class is for the testing of the functions of the CashMachine
 * 
 * @author Michael Daly
 * @version 1.0
 * @since CST8110 Introduction to Programming
 */

public class CashMachineTest{

	public static void main( String[] args){

		CashMachine cashMachine = new CashMachine( 0.15);

		System.out.println("Welcome to CashMachine!");
		
		do{
			cashMachine.printMenu();
		}while( cashMachine.processMenu());

		System.out.println();
		System.out.println("GoodBye!!");
	}
}
