/* Task01
 * 
 * Write a program, which gets as input four integers from console (use Scanner) 
 * and prints out their sum and product. 
 */
import java.util.Scanner;

public class Task01 {

	// Class variables
	static int[] x = new int[2];   		/* Have to do this because java doesn't have pointers */
	static int[] arr = new int[4];		/* ^ */
	static Scanner sc = new Scanner(System.in); //  Don't ask
	
	// Main method
	public static void main(String[] args) {
		System.out.print("Enter 4 numbers: ");
		nameThisLater(); // Calls the function that scans and returns an array of results
		
		// Output
		System.out.println("The product of numbers is: " + x[0]); // Prints the product of numbers
		System.out.println("The sum of numbers is: " + x[1]);     // Prints the sum of numbers
		}
	
	// I just really wanted to use recursion with a custom method.
	static int[] nameThisLater() {	// Don't forget to name this later
		try {
			arr[0] = sc.nextInt(); // I
			arr[1] = sc.nextInt(); // am
			arr[2] = sc.nextInt(); // too
			arr[3] = sc.nextInt(); // lazy
		} catch (java.util.InputMismatchException e) { // Just in case someone wants to break it
			System.out.println("Please enter valid numbers");
			sc.nextLine(); // Because Java reads the newline character (enter) in the next input
			nameThisLater(); // Recalls itself to scan everything again if the input fails. Yes, I do know I could use a loop instead...
		}
		x[0] = (arr[0] + arr[1] + arr[2] + arr[3]); // Sum of numbers
		x[1] = (arr[0] * arr[1] * arr[2] * arr[3]); // Product of numbers
		return(x); // Returns an array with 2 elements, which are the final results
	}
}







