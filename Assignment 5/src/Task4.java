/*
 * Write a method public static boolean isValidSchoolEmail(String email) that
 *  takes as input a String parameter and checks if it is a valid University email
 *  (they normally end with either .edu or its local variants,
 *  such as .edu.az , .edu.tr and so on. Also, according to rules,
 *  the ID part of emails must be at least 3 characters long and can only consist of
 *  letters, numbers and underscore ('_').
 *
 *  For example:
 *
 *  isValidSchoolEmail("emil@ada.edu.az") --> true
 *  isValidSchoolEmail("tofig@qu.edu") -->  true
 *  isValidSchoolEmail("gulam@qu.edudd") -->  false
 *  isValidSchoolEmail("to@qu.edu") -->  false
 *  isValidSchoolEmail("to?fig@qu.edu") -->  false
 *  isValidSchoolEmail("eabbasov2019@ada.edu.tr") -->  true
 */

public class Task4 {

	public static void main(String[] args) {
		System.out.println(isValidSchoolEmail("emil@ada.edu.az")); // true
		System.out.println(isValidSchoolEmail("tofig@qu.edu")); // true
		System.out.println(isValidSchoolEmail("gulam@qu.edudd")); // false
		System.out.println(isValidSchoolEmail("to@qu.edu")); // false
		System.out.println(isValidSchoolEmail("to?fig@qu.edu")); // false
		System.out.println(isValidSchoolEmail("eabbasov2019@ada.edu.tr")); // true
		System.out.println(isValidSchoolEmail("eabbasov2019ada.edu.tr")); // false

	}

	/* Abstracted method for checking if the given email is valid. Uses other methods */
	public static boolean isValidSchoolEmail(String email) {
		if (!checkAtSign(email)) {											// Checks for @ sign related faults
			return false;
		}

		// Divides user ID and maid ID into separate strings for easier checking
		String userID = email.substring(0, email.indexOf('@'));
		String mailID = email.substring(email.indexOf('@') + 1, email.length());

		if (!checkMailID(mailID)) {											// Checks for mail ID related faults
			return false;
		}
		if (!checkUserID(userID)) {											// Checks for user ID related faults
			return false;
		}
		return true;														// returns false if all is right with the world
	}


	/* Checks whether the given string only contains letters or an underscore*/
	private static boolean ifAllLetter(String str) {
		for (int i = 0; i <= str.length() - 1; i++) {
			if (!('a' <= str.charAt(i) && str.charAt(i) <= 'z')) {
				if (!('A' <= str.charAt(i) && str.charAt(i) <= 'Z') && str.charAt(i) != '_') {
					if (!(Character.isDigit(str.charAt(i)))) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/* Checks whether the given character is a valid letter, or an underscore *
	 * I don't remember why I made 2 of those, but it's probably important for something
	 * and it's 2 in the morning, so I won't remove it
	 */
	private static boolean isLetterOrUnderscore(char ch) {
		if (!('a' <= ch && ch <= 'z')) {                                    // If not a lowercase letter and
			if (!('A' <= ch && ch <= 'Z')) {                                // if not a capital letter and
				if (!(ch == '_')) {											// if not an underscore
					return false;											// return false
				}
			}
		}
		return true;                                                        // If not, return true
	}

	/*
	 * This method checks for @ sign placement;
	 * whether it exists to start with or multiple @ signs exist
	 */
	private static boolean checkAtSign(String email) {
		if (!email.contains("@")) {											// If it doesn't exist
			return false;
		} else if (email.indexOf('@') != email.lastIndexOf('@')) {		// If multiple '@''e exist
			return false;
		}
		return true;
	}

	/*
	 * This method checks a given user ID for several possible invalidities
	 * such as length, characters and first character
	 */
	private static boolean checkUserID(String userID) {
		if (userID.length() < 3) {											// For length
			return false;
		} else if (!ifAllLetter(userID)) {									// For letters and underscore
			return false;
		} else if (!isLetterOrUnderscore(userID.charAt(0))) {				// If first character is letter
			return false;
		} else if (userID.charAt(0) == '_') {								// If first letter is an underscore
			return false;
		}
		return true;
	}

	/*
	 * This method checks a given mail ID for several possible invalidities such as
	 * false or multiple domain names, invalid characters, and length
	 */
	private static boolean checkMailID(String mailID) {
		if (!mailID.contains(".")) {										// If there is no '.'
			return false;
		}
		if (!mailID.contains(".edu")) {										// If there is no ".edu"
			return false;
		}
		for (int i = 0; i <= mailID.length() - 1; i++) {					// If invalid characters exist
			if (!(Character.isLetterOrDigit(mailID.charAt(i))
					|| mailID.charAt(i) == '.')) {
				return false;
			}
		}
		if (mailID.indexOf(".edu") != mailID.lastIndexOf(".edu")) {		// If multiple ".edu"
			return false;
		}

		for (int i = 0, count = 0; i < mailID.length(); i++) {				// Checks domain name length
			if (mailID.charAt(i) != '.') {									// While '.' is not encountered
				count++;													// Count the amount of characters
			} else {														// If character is '.'
				if (count < 2 || count > 3) {								// Compare previous value
					return false;											// If invalid, return false
				} else {													// If not
					count = 0;												// Seet counter to 0 and restart
				}
			}
		}
		return true;														// If it fails to fail, return true
	}
}