/* Task05
 * 
 * Write a program that reads a positive integer N>1 from console and prints out 
 * product of its greatest divisor that is less than itself. For example, if number 8 is 
 * entered, 4 must be printed. Or if number 9 is entered, 3 must be printed. 
 */

import java.util.Scanner;

public class Task05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a number: ");

		// Input
		int testCase;
		while(true) {
			try {		// Because I like try/catch
				testCase = sc.nextInt();
				break;
			} catch (java.util.InputMismatchException e) {	// Catches invalid input like characters
				System.out.println("Please enter a valid number");
				sc.nextLine(); // Thanks, Java
			}
		}
		sc.close();

		// Output
		int i = testCase - 1;			// "Less than itself"
		for (; i != 0; i--) {			// Loop iterates backwards because it's more efficient
			if (testCase % i == 0) { 	// First divisor that comes up
				System.out.println("The greatest divisor of " + testCase + " is: " + i);
				break;					// Prematurely exit loop after finding the answer
			}
		}
	}
}
