/* Create a simple command line game program guessing a whole number.

•	Let the computer "think" about a whole number between -12~19 (both exclusive) 
using following statement to generate a random number:2
•	During the game, player continuously guesses a number by entering it from console
•	If the guess was bigger than X print out “Nope! Try smaller”
•	If the guess was smaller than X print out “Nope! Try bigger”
•	If the player finds the correct number, print out “Now you got it!”, 
then in the new line print how many guesses you did all together
(e.g. “Total guesses you did to win: 11”) and quit the program.
*/

// Probably done

import java.util.Random;
import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
		Random rand = new Random();
		final int testCase = rand.nextInt(32) - 12;
		int userInput;
		int counter = 0;
		Scanner sc = new Scanner(System.in);
		
		// Game runtime
		while (true) {	// Continues until the user guesses the correct number
			counter++;	// Counts the amount of guesses
			userInput = sc.nextInt();	// Not error checked
			
			// If the guess is correct
			if (userInput == testCase) {
				System.out.println("Now you got it!"); // Might want to change to something else later
				break;
			}
			
			// If the guess is larger
			else if (userInput > testCase) {
				System.out.println("Nope! Try smaller"); 
				continue;
			}
			
			// If the guess is smaller
			else if (userInput < testCase) {
				System.out.println("Nope! Try bigger"); // Larger
				continue;
			}
		}
		sc.close();
		System.out.println("Total guesses you did to win: " + counter);
	}
}
