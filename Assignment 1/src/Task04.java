/* Task04 
 * 
 * Write a program that reads a positive integer N from console 
 * and prints out the maximum of its digits using loop statement. 
 * For example, if user enters 922396 then number 9 is printed. 
 */

import java.util.Scanner;

public class Task04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase;	// Inout variable

		// Input
		System.out.println("Please enter a number:");
		while(true) {		// Repeats until correct input is provided
			try {
				testCase = sc.nextInt();
				break;
			} catch (java.util.InputMismatchException e) {	// Catches incorrect input
				System.out.println("The number you have entered is invalid. Please enter a valid number");
				sc.nextLine();
			}
		}
		int dump = testCase;			// Extra variable for preserving the original value beacuse I need it for something
		sc.close();						// CLoses input stream

		// Finding the largest digit
		int maximum = 0;				// Predefined comparison value
		while (dump != 0) {				// Dump is 
			if (dump % 10 >= maximum)	// Checks digits one by one and compares them to maximum
				maximum = (dump % 10);	// Assigns new maximum if digit is greater than or equal to it
			dump /= 10;					// Decrements the original value by 10
		}

		// Output
		System.out.println("The largest digit of " + testCase + " is: " +maximum);
	}
}