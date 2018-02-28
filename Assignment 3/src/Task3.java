/*
 * Write a Console Program that simulates rolling two die 
 * (Note: The word "dice" is a plural, as in "two dice." The singular is "die.") and 
 *  see if you can get Double Sixes within 3 chances. If you succeed, then print "Yeah, I rock at this!", 
 *  otherwise print "Ahh, today is just not my day, I guess :( ".
 */


// Probably done

import java.util.Random;

public class Task3 {

	public static void main(String[] args) {
		int i1;
		int i2;
		Random rand = new Random();
		for (int i = 1; i <= 3; i++) {
			i1 = rand.nextInt(6) + 1; // [1 - 6]
			i2 = rand.nextInt(6) + 1; // [1 - 6]
			System.out.println("Chance #" + i + ": " + i1 + " " + i2);
			if (i1 == 6 && i2 == 6) {							// If both are 6
				System.out.println("Yeah, I rock at this!");	// Print the output
				System.exit(0);									// And close the program
			}
		}
		System.out.println("Ahh, today is just not my day, I guess :("); // Print if above fails
	}
}