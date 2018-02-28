/* Task02
 * 
 * Write a program that reads an integer N and a double D from console and 
 * prints out that double D on separate lines 2*N+1 times. 
 * 
 * For example, if user enters 1  4.5 then the output should be like this:
4.5
4.5
4.5

 */
import java.util.Scanner;

public class Task02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N;		// Integer input variable
		double D;	// Double input variable
		System.out.println("Please enter the numbers:");

		// Input. Repeats until the input is correct.
		while(true) {
			try {
				N = sc.nextInt();
				D = sc.nextDouble();
				sc.close();
				break;
			} catch(java.util.InputMismatchException e) {	// Catches invalid input like characters
				System.out.println("Please enter valid numbers");
				sc.nextLine(); // Because Java doesn't read the newline character after the first input
			}
		}

		// Output
		for (int i = 0; i < (2 * N + 1); ++i) {
			System.out.println(D);
		}
	}

}
