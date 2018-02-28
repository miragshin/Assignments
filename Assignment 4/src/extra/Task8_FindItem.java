package extra;

/*
 * Create an ArrayList that can hold 10 Integers, and fill each index with a 
 *  different random value from 1-50. Display those values on the screen, and 
 *  then prompt the user for an integer input. Search through the ArrayList,
 *  and if the item is present, give the index number where it is located. 
 * If the value is not in the ArrayList, display a single message saying so. 
 * If the value is present more than once, display the message as many times 
 *  as necessary. 
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Task8_FindItem {

	public static void main(String[] args) {

		// Variable declaration
		ArrayList<Integer> arr = new ArrayList<>();
		Random rand = new Random();

		for (int i = 0; i < 10; i++) {				// Adds 10 integers
			arr.add(rand.nextInt(50) + 1);	// Picked randomly, in range [1-50]
		}
		System.out.println("Array List: " + arr.toString());
		System.out.print("Value to find: ");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		sc.close();
		if (arr.contains(input)) {
			for (int i = arr.indexOf(input); i <= arr.lastIndexOf(input); i++) {
				if (arr.get(i).equals(input)) {
					System.out.println(input + " is in index " + i + ".");
				}
			}
		}
		else System.out.println(input + " is not in the ArrayList.");
	}
}






















