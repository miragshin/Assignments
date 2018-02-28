/* 
 * Write a method public static String extractText(String str) that takes a string 
 * as argument and returns its content without digit characters and reducing whitespaces.
 * 
 * For example: 
 * extractText("He had 3 friends back in 2012.") -->  "He had friends back in."
 * Note that there are 1 space between had and friends, and no space after in.
 */

public class Task2 {

	public static void main(String[] args) {
		System.out.println(extractText("He had 3 friends back in 2012.")); //He had friends back in.
		System.out.println(extractText("4 Friends + 4 emenies equals at least 5 Friends")); //Friends + enemies equals at least Friends
	}


	public static String extractText(String str) {
		String tempString = "";
		for (int i = 0; i < str.length(); i++) {
			if (!isDigit(str.charAt(i)) || str.charAt(i) == ' ') {		// If it's a letter or whitespace
				tempString += str.charAt(i);							// Add it
			}
		}
		tempString = tempString.trim();									// For whitespaces in beginning and end
		return trimWhitespaces(tempString);
	}

	// For removing extra extra white spaces
	private static String trimWhitespaces(String str) {
		String dump = "";
		for (int i = 0; i < str.length(); i++) {
			while (str.charAt(i) == ' ' &&								// While there are 2 consecutive white paces
					(str.charAt(i + 1) == ' ' ||
							!isLetter(str.charAt(i + 1)))) {
				i++;;													// Ignore the iteration
			}
			dump += str.charAt(i);										// Concatenate after ignoring whitespaces
		}
		return dump;
	}

	// For checking if the character is a digit
	private static boolean isDigit(char ch) {
		int dump = ch - '0';
		return (0 <= dump && dump <= 9);
	}

	// For checking if the character is a letter
	private static boolean isLetter(char ch) {
		if ('a' <= ch && ch <= 'z') return true;
		if ('A' <= ch && ch <= 'Z') return true;
		return false;
	}
}