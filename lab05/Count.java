package lab05;

import java.util.Scanner;

/**
 * This class is for the manipulation and creation of Count objects
 *
 * @author Michael Daly
 * @version 1.0
 * @since CST8110 Introduction to Programming
 */

public class Count {

    private int stepSize;
    private int startNum;

    private Scanner scanner = new Scanner(System.in);

    /**
     * Even though this is a redundunt operation
     * initiat task contains it - so... nothing else to do
     */
    Count() {
        new Count(0, 0);
    }

    // Another constructor which can be joined with previous one if
    // we really care about minimizing work for Garbage Collector
    Count(int stepSize, int startNum) {
        this.startNum = startNum;
        this.stepSize = stepSize;
    }

    /**
     * This method grabs user input and send it for validation.
     * Must be public, since the access is from outside.
     * Validated values will be overwritten even in case they're
     * correct, but that's OK for now.
     */
    public void getValuesFromUser() {
    	String startNumText = "Enter the start value: ";
    	String stepSizeText=  "Enter the countdown step size: ";
        System.out.print(startNumText);
        this.startNum = scanner.nextInt();
        this.startNum = this.validateInput(this.startNum, startNumText);

        System.out.print(stepSizeText);
        this.stepSize = scanner.nextInt();
        this.stepSize = this.validateInput(this.stepSize,stepSizeText);
    }

    /**
     * This one validates input and overwrites it as it has been shown above
     */
    private int validateInput(int num, String output) {
        // input should be more than 0, so include a loop [while]
        // to check it and finally return a proper one. In case
        // initial value is correct - this loop won't be triggered
        while (num <= 0) {
            System.out.print("Invalid entry..." + output);
            num = scanner.nextInt();
        }
        // if initial number is valid, then it will be simply overwritten
        return num;
    }

    /**
     * Show the magic ;-)
     */
    public void displaySteps() {
        System.out.println("The numbers are:");
        for (int i = this.startNum; i > 0; i = i - this.stepSize) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
