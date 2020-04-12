package assignment2;


import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

/* File Name:		Student.java
 * Compiler: 		Eclipse 2019-06(JDT Core)
 * Version : 		1.0
 * Author : 			Michael Daly 040966083
 * Course : 			CST 8110 - Into to Computer Programming
 * Section:			362
 * Assignment : 		2
 * Date : 			November 2019
 * Professor : 		Fedor Ilitchev
 * Purpose : 		This Class allows the creation and modification of a Student object.
 */
public class Student {
    private long studNumber;
    private String firstName, lastName;
    private double[] marks;
    private double totalMarks, totalBonus, gpa;
    private static final int NUMBER_MARKS = 3;
    private Scanner input;

    /*
     * Purpose: 		 	Default constructor that initializes required variables to be used later.
     * Author: 			Michael Daly
     * History/Versions: 1.0
     * Parameters: 		none
     */
    public Student() {
        this.marks = new double[NUMBER_MARKS];
        this.input = new Scanner(System.in);
    }

    /*
     * Purpose: 		 	Allows user to input values to be stored in Student class.
     * Author: 			Michael Daly
     * History/Versions: 1.0
     * Parameters: 		none
     */
    public void readStudentDetails() {
        int numBonus;
        BigInteger bi = new BigInteger("0"); //used for validation of student number


        do {
            try {
                System.out.print("Enter Student Number: ");
                bi = input.nextBigInteger();
            } catch (InputMismatchException ex) {
                System.out.println("Invalid format. Please enter a valid number");
                this.input = new Scanner(System.in);
                continue;
            }

            if (bi.longValue() > Long.MAX_VALUE || bi.longValue() < 0) {
                System.out.print("Invalid number, please enter number in correct format/size\n");
            } else {
                studNumber = bi.longValue();
            }
        } while (studNumber == 0);

        System.out.print("Enter first name: ");
        this.firstName = input.next();
        System.out.print("Enter last name: ");
        this.lastName = input.next();
        readMarks();

        do {
            System.out.print("Enter number of bonuses (should not be greater than 5): ");
            numBonus = input.nextInt();
            if (numBonus > 5) {
                System.out.print("Number of bonuses should not be greater than 5!!!\n\n");
            }
        } while (numBonus < 0 || numBonus > 5);
        readBonus(numBonus);
    }

    /*
     * Purpose: 		 	Runs a loop based on the maximum amount of marks(NUMBER_MARKS) to allow the user to input enter the students marks,
     * 					and validates the input.
     * Author: 			Michael Daly
     * History/Versions: 1.0
     * Parameters: 		none
     */
    private void readMarks() {

        for (int i = 0; i < NUMBER_MARKS; i++) {
            do {
                System.out.print("Enter mark " + (i + 1) + ":");
                this.marks[i] = input.nextDouble();
                if (this.marks[i] < 0 || this.marks[i] > 100) {
                    System.out.print("Marks should be within 0 and 100. Please reenter. \n");
                }
            } while (this.marks[i] < 0 || this.marks[i] > 100);
        }

    }

    /*
     * Purpose: 		 	Based on the given number of bonus marks, loops to take accept user to input bonus amount and adds it to the
     * 			 		total of bonus marks(totalBonus).
     * Author: 			Michael Daly
     * History/Versions: 1.0
     * Parameters: 		int numBonus - Number of student bonus marks
     */
    private void readBonus(int numBonus) {
        for (int i = 0; i < numBonus; i++) {
            System.out.print("Enter bonus " + (i + 1) + ":");
            this.totalBonus += input.nextDouble();
        }
        System.out.print("\n");
    }


    /*
     * Purpose: 		 	Calculates the gpa. If the student has a mark less than 50 it gives them a 0.00 GPA.
     * Author: 			Michael Daly
     * History/Versions: 1.0
     * Parameters: 		none
     */
    public void calculateGpa() {

        for (double mark : marks) {
            this.totalMarks += mark;
        }

        this.totalBonus = convertBonus();
        this.totalMarks += this.totalBonus;

        if (!checkEligibility()) {
            this.gpa = 0.0;
        } else {
            this.gpa = ((totalMarks / (NUMBER_MARKS * 100)) * 4);
        }

        if (this.gpa > 4.0) {
            this.gpa = 4.0;
        }

    }

    /*
     * Purpose: 		 	Per the document any bonus that totals to above 15 must be adjusted back to 15. This method does that, then returns the
     * 					calculated adjusted value.
     * Author: 			Michael Daly
     * History/Versions: 1.0
     * Parameters: 		none
     */
    private double convertBonus() {
        if (this.totalBonus > 15) {
            this.totalBonus = 15;
        }
        double convertedBonus = (this.totalBonus / 15) * 2;

        return convertedBonus;

    }

    /*
     * Purpose: 			Per the document, any bonus that totals to above 15 must be adjusted back to 15. This method does that,
     * 					then returns the calculated adjusted value.
     * Author: 			Michael Daly
     * History/Versions: 1.0
     * Parameters: 		none
     */
    private double calculatePercentage() {
        double percentage = (this.totalMarks / (NUMBER_MARKS * 100)) * 100;
        return percentage;
    }

    /*
     * Purpose: 			Based on the course outline, this sets the proper grade letter from the final calculated percentage and returns it.
     * Author: 			Michael Daly
     * History/Versions: 1.0
     * Parameters: 		none
     */
    private String findGradeLetter() {
        String gradeLetter = "";

        if (!checkEligibility()) {
            gradeLetter = "F";
            return gradeLetter;
        }


        double finalGrade = calculatePercentage();

        if (finalGrade > 89)
            gradeLetter = "A+";
        else if (finalGrade > 84)
            gradeLetter = "A";
        else if (finalGrade > 79)
            gradeLetter = "A-";
        else if (finalGrade > 76)
            gradeLetter = "B+";
        else if (finalGrade > 72)
            gradeLetter = "B";
        else if (finalGrade > 69)
            gradeLetter = "B-";
        else if (finalGrade > 66)
            gradeLetter = "C+";
        else if (finalGrade > 62)
            gradeLetter = "C";
        else if (finalGrade > 59)
            gradeLetter = "C-";
        else if (finalGrade > 56)
            gradeLetter = "D+";
        else if (finalGrade > 52)
            gradeLetter = "D";

        else
            gradeLetter = "D-";


        return gradeLetter;

    }

    /*
     * Purpose: 			Checks each mark, and if it finds a failing mark returns false(meaning they are ineligible)
     * Author: 			Michael Daly
     * History/Versions: 1.0
     * Parameters: 		none
     */
    private boolean checkEligibility() {
        boolean eligibility = true;

        for (double mark : marks) {
            if (mark < 50) {
                eligibility = false;
            }
        }
        return eligibility;
    }

    /*
     * Purpose: 			Prints out all the attributes of a Student in the matching format to the header
     * Author: 			Michael Daly
     * History/Versions: 1.0
     * Parameters: 		none
     */
    public void displayStudentDetails() {
        String gradeLetter = findGradeLetter();
        int firstLength = this.firstName.length();
        int lastLength = this.lastName.length();
        String sStudNumber = String.valueOf(this.studNumber);
        int studNumberLength = sStudNumber.length();

        if (firstLength > 11) {
            firstLength = 11;
        }
        if (lastLength > 11) {
            lastLength = 11;
        }
        if (studNumberLength > 11) {
            studNumberLength = 11;
        }

        String displayFirst = this.firstName.substring(0, firstLength); //trim to fit in output
        String displayLast = this.lastName.substring(0, lastLength); //trim to fit in output
        String displayStudNumber = sStudNumber.substring(0, studNumberLength); //trim to fit in output
        System.out.format("%8s\t|%11s %-11s|\t%3.2f\t\t|%6.2f |\t%-2s\t|\t", displayStudNumber, displayFirst,
                displayLast, this.totalMarks, this.gpa, gradeLetter);

        if (gradeLetter.equals("F")) {
            System.out.print("NOTE: Failed in one or more courses");
        }
        System.out.println();
    }

    /*
     * Purpose: 			Prints out the header when the program starts
     * Author: 			Michael Daly
     * History/Versions: 1.0
     * Parameters: 		none
     */
    public static void displayTitle() {
        StringBuilder sb = new StringBuilder();

        sb.append("GPA CALCULATOR\n");
        for (int i = 0; i < 14; i++) {
            sb.append("=");
        }
        sb.append("\n");
        System.out.print(sb.toString());

    }

    /*
     * Purpose: 			Prints out the header for displaying student info
     * Author: 			Michael Daly
     * History/Versions: 1.0
     * Parameters: 		none
     */
    public static void displayHeader() {
        String stars = "";

        for (int i = 0; i < 90; i++) {
            stars += "*";
        }

        System.out.format("%s%n\t\t\t\t%s%n%s%n%n", stars, "MARK LIST", stars);
        System.out.format("%s  |\t %s\t\t|\t%s\t|  %s  |  %s |%n", "Student Number", "Name", "Total Marks", "GPA",
                "Grade Letter");

        for (int i = 0; i < 89; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
