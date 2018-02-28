// Multiplication chart thing

// I think it works

import java.util.Scanner;

public class Task5 {

	public static void main(String[] args) {
		
		// Variables
		int testCase;
		int dump;
		
		// Input
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				testCase = sc.nextInt();
				if (testCase <= 0 || testCase >= 10) throw new java.util.InputMismatchException();
				break;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Please enter a valid number (0 < N < 10)");
				sc.nextLine();
			}
		}
		sc.close();
		
		// Prints the first line, doesn't have anything to do with the output
		System.out.println("* |  1  2  3  4  5  6  7  8  9" + '\n' + 
				"-------------------------------");
		
		// Constructs the rest of the chart, vertically
		for (int i1 = 1; i1 <= testCase; i1++) {
			System.out.print(i1 + " | ");
			
			// Calculates the multiplication result 
			for (int i2 = 1; i2 <= 9; i2++) {
				dump = i1 * i2;
				
				// Print an extra white space if the number has 2 digits
				if (dump / 10 == 0)
					System.out.print(' ');
				
				System.out.print(dump + " ");
			}
			System.out.println(); // Prints a new line after each row
		}
	}
}