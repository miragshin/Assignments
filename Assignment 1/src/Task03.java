/* Task03 
 * 
 * Write a program that reads an integer N from console and prints the first N 
 * elements of Fibonacci sequence using loop statement (NOT recursion!). 
 * The Fibonacci sequence is the series of numbers: 
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34� 
 * The next number is found by adding up the two numbers before it: 
 * F(0)=0, F(1)=1, F(n) = F(n-1) + F(n-2)
 */
import java.util.Scanner;

public class Task03 {		// Version 2 without arrays...

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a number:");
		int testCase;
		int First = 0;
		int Second = 1;
		int Third = 1;

		// Security measure try/catch. Loop repeats until correct input is given
		while(true) {
			try {
				testCase = sc.nextInt();
				if (testCase <= 0)	// If input is 0, or negative. Have to do this check because int accepts negative numbers otherwise.
					throw new java.util.InputMismatchException();
				break;
			} catch(java.util.InputMismatchException e) {	// If invalid input is given, e.g characters, strings, numbers out of range, etc.
				System.out.println("Please enter a valid number");
				sc.nextLine();	// Because Java reads the newline in the next iteration
			}
		}
		sc.close();

		// If the input is 1
		if (testCase == 1) {
			System.out.println("The first number of the Fibonacci squence is 0");
			System.exit(0);	// Terminates the program.
		}

		// If the input is 2
		else if (testCase == 2) {
			System.out.println("The first 2 numbers of the Fibonacci sequence are:\n0 1");
			System.exit(0);	// Terminates the program.
		}

		// For input > 2
		System.out.println("The first " + testCase + " numbers of the Fibonacci sequence are:");
		System.out.print(First + " " + Second + " " + Third + " ");
		for (int i = 0; i < testCase - 3; i++) {
			First = Second + Third;
			Second = Third;
			System.out.print(First + " ");
			Third = First;
		}
	}
}
