/*
 * This program asks the user for a list of names (one per line) till the user 
 *  enters an empty line (just hits Enter with no name). Then, the program must 
 *  print out the list of names user entered. 
 * Note that, the list can NOT contain the duplicate of the same name. So, you should 
 *  let the user know if he/she enters the same name (no matter how many times they do).
 *  (Hint: You may find an ArrayList makes it easy to keep track of the names entered).
 */

// Probably done

import java.util.ArrayList;
import java.util.Scanner;

public class Task5 {

	public static void main(String[] args) {

		// Variable declarations
		ArrayList<String> arr = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		String name;

		// Input and operations
		while (true) {
			System.out.print("Enter name: ");
			name = sc.nextLine();				// Takes input as string
			if (name.isEmpty())					// If the input is empty
				break;							// breaks out of the loop
			if (!arr.contains(name)) {			// If input name doesn't exist
				arr.add(name);					// Adds new name to the list
			}
			else {								// If the input name already exists
				System.out.println(name + " already exists in the list!");
			}
		}
		sc.close();

		// Output
		System.out.print("Your unique name list contains:\n" + arr.toString());
	}
}