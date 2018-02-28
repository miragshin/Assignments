

/*
 * This program finds an integer between given m and n that has the largest number
 * of factors. It prints out the maximum number of factors and an integer that
 * has that many factors.
 */

// It appears to be working

import java.util.Scanner;

public class Task4 {



	public static void main(String[] args) {
		
		// Variables
		int first;
		int second;
		int maximum = -1;
		int thisNumber = 0;
		Scanner sc = new Scanner(System.in);
		
		// Input
		while (true) { // Error checking, I guess
			try {
				first = sc.nextInt();
				second = sc.nextInt();
				if (!((first + 1) < second))
					throw new java.util.InputMismatchException();
				break;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Wrong input! Please re-enter m and ((m+1)<n)");
				sc.nextLine();
			}
		}
		sc.close();
		
		// Checks and records amount of diviros for every number between m and n (first/second)
		int dump = first;
		for (; dump <= second; dump++) {
			if (amountOfFactors(dump) > maximum) {
				maximum = amountOfFactors(dump);
				thisNumber = dump;
			}
		}
		
		// Output
		System.out.println("Among numbers " + first + " and " + second);
		System.out.println(thisNumber + " is first number with the maximum of " + maximum + " divisors");
		
	}
	
	// Returns the amount of divisors for each number
	// Had to make a separate method because it was getting too complicated
	private static int amountOfFactors(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				count++;
		}
		return count;
	}
}
	
	
	
	
	
	
	
	
	
	
