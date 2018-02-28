/*
 * Write a method public static String invertString(String str) that 
 *  takes a string as input and returns a string with all the letter 
 *  cases inverted. However, note that you CANNOT use Character class.
 *  
 *  For example:
 *  invertString("Hello World There!") --> "hELLO wORLD tHERE!"
 */

public class 		Task1 {

	public static void main(String[] args) {
		System.out.println(invertString("Hello World There!")); // hELLO wORLD tHERE!
		System.out.println(invertString("Bye Bye World :(")); // bYE bYE wORLD :(
	}


	public static String invertString(String str) {
		String tempString = "";												// To store the modified string
		char tempChar;														// Temporarily store single character

		/*
		* 32 is the difference between capital and lowercase letters in ASCII table. Since lowercase letters have
		* higher integer value in the ASCII table, the program adds 32 to capital letters, but subtracts from
		* lowercase letters
		*/
		for (int i = 0; i < str.length(); i++) {
			tempChar = str.charAt(i);
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {				// For capital letters
				tempChar = str.charAt(i);									// Store the character
				tempChar += 32;
			}
			else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {		// For lowercase letters
				tempChar = str.charAt(i);
				tempChar -= 32;
			}
			tempString += tempChar;
		}
		return tempString;
	}
}
