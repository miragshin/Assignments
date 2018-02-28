// Prints the pattern thing

// Done (probably)

import java.util.Scanner;

public class Task7 {

	public static void main(String[] args) {
		
		// Input
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.close();
		
		// Variables, explained later in the code
		String s = "*";
		String whiteSpace = "  ";
		
		// This records every line of final output until the middle line
		// and yes, I know this is not the best solution, but I'm lazy don't judge 
		String[] arr = new String[testCase / 2];
		
		// This is a String variable for printing the whitespaces before the other characters
		for (int i = 0; i < testCase / 2 - 1; i++) {
			whiteSpace += "  ";
		}
		
		
		for (int i1 = 0; i1 < testCase / 2; i1++) {
			System.out.println(whiteSpace + s);
			arr[i1] = whiteSpace + s;					// Records the output for later reuse
			s += " #";									// Adds # to right
			s = "# " + s;								// Adds # to left
			whiteSpace = whiteSpace.substring(0, whiteSpace.length() - 2);	// Cuts the whiteSpace string
		}
		
		// This is the middle line, consisting of all *'s
		for (int i = 0; i < testCase; i++)
			System.out.print("* ");
		System.out.println("");
		
		// Prints the previously reported half of the output in reverse
		// Again, I know this is too lazy, but don't judge, programmers are always lazy
		for (int i = testCase / 2 - 1; i != -1; i--) {
			System.out.println(arr[i]);
		}
	}
}