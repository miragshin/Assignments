/* Task06
 * 
 * Implement a program that reads several integers (more than two integers) from 
 * console input and prints out the sum of the minimum and the maximum of the 
 * numbers user entered. Your program should read from console until it reads a 
 * sentinel that is 0 (zero). After reading 0 (zero), it should stop reading input print 
 * out the sum of min and max. Keep in mind, that Zero itself should NOT be 
 * considered as one of integers. 
 * 
 * For example, if the following is entered 3 -1 5 9 0, then 8.
 */

import java.util.Scanner;

public class Task06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);				// Creates new Scanner object
		System.out.println("Please enter the numbers");
		int minimum = sc.nextInt();							// First input is recorded as the comparison value
		int maximum = minimum;								// Because I don't want to predefine mix and max
		int input;											// Generic variable for single input value
		do {
			input = sc.nextInt();							// Takes user input one by one
			if (input == 0) break;							// Had to put this here because mix would be 0 otherwise
			if (input <= minimum) minimum = input;			// Records the minimum of the numbers
			if (input >= maximum) maximum = input;			// Records the maximum of the numbers
		} while (input != 0);								// Loop is terminated if input it 0. I know that the break statement inside the loop body is sufficient, but just in case.
		sc.close();											// Closes input stream
		System.out.println(maximum + minimum);				// Final result
	}

}
