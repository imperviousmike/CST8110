package firstyear.firstsemester.cst8110.assignment2;

import java.util.Scanner;

/* File Name:		StudentTest.java
 * Compiler: 		Eclipse 2019-06(JDT Core)
 * Version : 		1.0
 * Author : 			Michael Daly 040966083
 * Course : 			CST 8110 - Into to Computer Programming
 * Section:			362
 * Assignment : 		2
 * Date : 			November 2019
 * Professor : 		Fedor Ilitchev
 * Purpose : 		This Class is the main test/run class for creating and manipulating Student objects
 */
public class StudentTest {

	/*
	 * Purpose: This is the main method to run the program that functions
	 * identically to the document Author: Michael Daly History/Versions: 1.0
	 * Parameters: String[] args - arguments given when running the program via
	 * command line(not used in this application)
	 */
	public static void main(String[] args) {
		int numStudents;

		Student.displayTitle();

		do {
			System.out.print("Enter number of students: ");
			try (Scanner input = new Scanner(System.in)) {
				numStudents = input.nextInt();
			}
		} while (numStudents < 0);

		System.out.println();

		Student[] students = new Student[numStudents];

		String studentDetails = "Enter details of Student ";

		String squiggly = "";
		for (int i = 0; i < 26; i++) {
			squiggly += "~";
		}

		for (int i = 0; i < numStudents; i++) {
			System.out.print(studentDetails + (i + 1));
			System.out.print(("\n" + squiggly + "\n"));
			Student student = new Student();
			student.readStudentDetails();
			student.calculateGpa();
			students[i] = student;
		}

		Student.displayHeader();

		for (Student student : students) {
			student.displayStudentDetails();
		}

	}

}
