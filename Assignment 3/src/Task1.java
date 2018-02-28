/*
 * Write a Console Program that can output the integer numbers from m to n (both inclusive!). 
 * However, if the current number is divisible by 3, then print "Love" instead of the number and if the number 
 *  is divisible by 7, then print "Java". For numbers which are divisible by both 3 and 7 print "LoveJava". 

Note 1: You should also do the error handling, such as when user enters wrong m and n (where m>n) you notify 
 the user about the wrong input and ask to re-enter! 
Note 2: Create a method (that takes two int parameters) to print the results on the Console window.

 */

// Done

import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		int m, n;
		
		// Input
		Scanner sc = new Scanner(System.in);
		while (true) {					// Continues until correct input is given
			try {
				m = sc.nextInt();		// First integer
				n = sc.nextInt();		// Second integer
				if (!(m > n)) throw new java.util.InputMismatchException();	// Reinitiates  the loop if m < n
				break;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Please enter valid numbers (m > n)");
				sc.nextLine();	// Java doesn't read the newline character if the input fails so I need this
			}
		}
		sc.close();
		
		// Output
		for (; n <= m; n++) {
			if (n % 21 == 0) System.out.println("LoveJava");	// If divisible by both 3 and 7
			else if (n % 3 == 0) System.out.println("Love");	// If divisible by only 3
			else if (n % 7 == 0) System.out.println("Java");	// If divisible by only 7
			else System.out.println(n);							// If not divisible by any of the following
		}
	}
}
