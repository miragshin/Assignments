/*
 * Write a method public static boolean isValidTime(String time) that takes as 
 *  input parameter a string and validates it by checking if the string is in one 
 *  of the following formats:
 *   "hh:mm" or "hh:mm AM/PM" (AM/PM should come after 1 whitespace and can be 
 *   either uppercase, lowercase or mixed).
 *   
 *   The method should return true if the string is valid and false otherwise.
 *    
 *   For example, the valid times samples are: 
 *   "13:45",  "1:45 PM",  "01:45 pm" , "03:40",  "3:40",   "6:20 Am" 
 *   
 *   For example, the following strings are invalid time samples:
 *   "43:45",  "13:30 am",    "1:75 PM",  "1:45 PS",  "111:45 pm" ,
 *   "03-40",  "3::30",   "6:y0 Am",  "3:30am",   "3:30    am" ,  "3:30 a  m",   
 *   "03:60" (because mm<60)
 *   
 *   isValidTime("13:45") -->  true
 *   isValidTime("43:45") -->  false
 */

public class Task5 {

	public static void main(String[] args) {
		System.out.println(isValidTime("13:45")); // true
		System.out.println(isValidTime("1:45 PM")); // true
		System.out.println(isValidTime("01:45 pm")); // true
		System.out.println(isValidTime("03:40")); // true
		System.out.println(isValidTime("3:40")); // true
		System.out.println(isValidTime("6:20 Am")); // true
		System.out.println(isValidTime("00:00")); // true
		System.out.println(isValidTime("12:00")); // true

		System.out.println(isValidTime("43:45")); // false
		System.out.println(isValidTime("13:30 am")); // false
		System.out.println(isValidTime("1:75 PM")); // false
		System.out.println(isValidTime("1:45 PS")); // false
		System.out.println(isValidTime("111:45 pm")); // false
		System.out.println(isValidTime("03-40")); // false
		System.out.println(isValidTime("3::30")); // false
		System.out.println(isValidTime("6:y0 Am")); // false
		System.out.println(isValidTime("3:30am")); // false
		System.out.println(isValidTime("3:30    am")); // false
		System.out.println(isValidTime("3:30 a  m")); // false
		System.out.println(isValidTime("03:60")); // false

	}

	public static boolean isValidTime(String time) {
		if (!time.equals(time.trim())) {								// If there are whitespaces in beginng and end
			return false;
		}
		if (!(isValidColon(time))) {									// If colon placement is not correct
			return false;
		}
		if (!is24Format(time)) {										// If it is 12 hour format
			if (!isValidAmPm(time)) {									// and am/pm is not placed correctly
				return false;
			}
		}
		if (is24Format(time)) {											// If 24 hour
			if (time.indexOf(':') == 1) {								// h:mm
				if (time.length() > 4) {								// Checks for length
					return false;
				}
			} else if (time.indexOf(':') == 2) {						// hh:mm
				if (time.length() > 5) {								// Checks for length
					 return false;
				}
			}
		}
		return parseAndCheck(time);										// Last method called, return value is the result
	}

	/* Checks for valid colon placement, works for both h:mm and hh:mm */
	private static boolean isValidColon(String time) {
		if (!time.contains(":")) {										// If ':' doesn't exist
			return false;
		} else if (time.indexOf(':') != time.lastIndexOf((':'))) {		// If multiple exist
			return false;
		} else if (!(time.indexOf(':') == 1
				|| time.indexOf(':') == 2)) {
			return false;
		} else {
			if (is24Format(time)) {										// If it is 24 hour and
				if ((time.toLowerCase().contains("am") &&				// 1. has "am"
						time.toLowerCase().contains("am")) ||			// 1.5. has "am" (I don't know why I did this like this, but it works, don't question black computer magic
							time.toLowerCase().contains("pm")) {		// 2. has "pm"
					return false;
				}
			}
		}
		return true;
	}

	/* This method is called when all the colon placement and whatnot are correct.
	 * Checks for the actual numeric errors, and parses strings into integers for value comparison */
	private static boolean parseAndCheck(String time) {
		int hourNumber = 0, minuteNumber = 0;


		if (time.indexOf(':') == 1) {									// Parse hour if h:mm
			if (Character.isDigit(time.charAt(0))) {					// If first character is a digit
				hourNumber = Integer.parseInt(time.substring(0, 1));	// Parse the first character
			} else {													// If it's not a digit,
				return false;											// return false
			}
		} else if (time.indexOf(':') == 2) {                    		// Parse hour if hh:mm
			if (Character.isDigit(time.charAt(0)) &&					// If first character is a digit and
					Character.isDigit(time.charAt(1))) {				// if second character is a digit,
				hourNumber = Integer.parseInt(time.substring(0, 2));	// Parse the first two characters
			} else {													// If not character(s),
				return false;											// return false
			}
		}

		if (time.indexOf(':') == 1) {									// For h:mm
			if (Character.isDigit(time.charAt(2)) &&					// If 3rd character is a digit and
					Character.isDigit(time.charAt(3))) {				// if 4th character is a digit,
				minuteNumber = Integer.parseInt(time.substring(2, 4));	// C# is great
			} else {													// If not character(s),
				return false;											// return false
			}
		} else if (time.indexOf(':') == 2) {							// For hh:mm
			if (Character.isDigit(time.charAt(3)) &&					// If 4th character is a digit and
					Character.isDigit(time.charAt(4))) {				// if 5th character is a digit,
				minuteNumber = Integer.parseInt(time.substring(3, 5));	// Parse 4th and 5th characters into integer
			} else {													// If not character(s),
				return false;											// return false
			}
		}

		// This part checks for numeric logic errors
		if (is24Format(time)) {											// If it's 24 hour format
			if (!(0 <= hourNumber && hourNumber <= 23)) {				// If hour is not between 0 and 23,
				return false;											// return false
			}
			if (!(0 <= minuteNumber && minuteNumber <= 59)) {			// If minute is not between 0 and 59,
				return false;											// return false
			}
			return true;												// If all is right, return true
		} else {														// If it's 12 hour format
			if (!(1 <= hourNumber && hourNumber <= 12)) {				// If hour is not between 1 and 12,
				return false;											// return false
			}
			if (!(0 <= minuteNumber && minuteNumber <= 59)) {           // If minute is not between 0 and 59,
				return false;                                           // return false
			}
			return true;
		}
	}

	/* Checks for whether a given 24h string contains am or pm.
	 * Probably redundant, I know, but who cares */
	private static boolean is24Format(String time) {					// Works only with valid input
		if (time.toLowerCase().contains("am") ||						// If the string contains "am" or
				time.toLowerCase().contains("pm")) {					// if the string contains "pm"
			return false;

		}
		return true;
	}

	/* Checks for whether the am/pm placement is correct.
	*  Probably also redundant */
	private static boolean isValidAmPm(String time) {        			// If it's 12h format

		if (time.toLowerCase().contains("am")) {						// If it contains "am"
			if (time.indexOf(':') == 1) {								// If the format is h:mm
				if (time.toLowerCase().indexOf("am") != 5)				// Checks for "hm:mm am"
					return false;
			} else if (time.indexOf(':') == 2) {						// If the format is hh:mm
				if (time.toLowerCase().indexOf("am") != 6)				// Checks for "hh:mm am"
					return false;
			}
		} else if (time.toLowerCase().contains("pm")) {					// If it contains "am"
			if (time.indexOf(':') == 1) {								// If the format is h:mm
				if (time.toLowerCase().indexOf("pm") != 5)				// Checks for "h:mm pm"
					return false;
			} else if (time.indexOf(':') == 2) {						// If the format is hh:mm
				if (time.toLowerCase().indexOf("pm") != 6)				// Checks for "hh:mm pm"
					return false;
			}
		}
		return true;
	}
}