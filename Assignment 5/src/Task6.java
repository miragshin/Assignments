/*
 * Write a method public static String convertToHumanTime(String date) that takes
 *  as  input a String parameter of format "hh:mm" (only 24h format this time)
 *  and returns a String in British English time style. No need to check for
 *  errors, only correct time samples will be tested.
 *
 *  For example:
 *  convertToHumanTime("13:00") -->   "It is 1 o�clock."
 *  convertToHumanTime("1:00") -->   "It is 1 o�clock."
 *  convertToHumanTime("00:00") -->   "It is midnight."
 *  convertToHumanTime("00:25") -->   "It is 25 past midnight."
 *  convertToHumanTime("23:55") -->   "It is 5 to midnight."
 *  convertToHumanTime("12:00") -->   "It is noon."
 *  convertToHumanTime("14:30") -->   "It is half past 2."
 *  convertToHumanTime("4:10") -->   "It is 10 past 4."
 *  convertToHumanTime("4:40") -->   "It is 20 to 5."
 *  convertToHumanTime("12:15") -->   "It is quarter past noon."
 *  convertToHumanTime("11:45") -->   "It is quarter to noon."
 */

public class Task6 {

	public static void main(String[] args) {
		System.out.println(convertToHumanTime("13:00")); //  It is 1 o'clock.
		System.out.println(convertToHumanTime("1:00")); //   It is 1 o'clock.
		System.out.println(convertToHumanTime("00:00")); //  It is midnight.
		System.out.println(convertToHumanTime("00:25")); //  It is 25 past midnight.
		System.out.println(convertToHumanTime("23:55")); //  It is 5 to midnight.
		System.out.println(convertToHumanTime("12:00")); //  It is noon.
		System.out.println(convertToHumanTime("14:30")); //  It is half past 2.
		System.out.println(convertToHumanTime("4:10")); //   It is 10 past 4.
		System.out.println(convertToHumanTime("4:40")); //   It is 20 to 5.
		System.out.println(convertToHumanTime("12:15")); //  It is quarter past noon.
		System.out.println(convertToHumanTime("11:45")); //  It is quarter to noon.
	}

	/**
	 * OK so here's what this does. There are 3 components of a date string that can change depending on the variables.
	 * Those are the hour (hourString) [can be a number, number + "o'clock", "midnight", or "noon"];
	 * the minute (minuteString) [can be a number, or "quarter"],
	 * and what I call the prefix because I don't know what it's called, which cam be either "to" or "past".
	 * In some cases, those variables can be omitted, so their default values are set to empty strings
	 * @return result is the final result printed. I wanted to keep the things tidy and declared a new
	 * variables for this purpose.
	 * I hope this explained my logic. I'm too lazy to comment each line otherwise so...
	 */

	public static String convertToHumanTime(String date) {

		String result, hourString = "", minuteString = "", prefix = "";
		int hour, minute;
		if (date.indexOf(':') == 1) {
			hour = date.charAt(0) - '0';
			minute = Integer.parseInt(date.substring(2, 4));
		} else {
			hour = Integer.parseInt(date.substring(0, 2));
			minute = Integer.parseInt(date.substring(3, 5));
		}

		if (0 < minute && minute < 30) {            // Sets prefix
			minuteString = String.valueOf(minute);
			prefix = "past";
		} else if (30 < minute && minute < 60) {
			minuteString = String.valueOf(60 - minute);
			hour++;
			prefix = "to";
		}

		if (minute == 15) {
			minuteString = "quarter";
		} else if (minute == 45) {
			minuteString = "quarter";
		} else if (minuteString.isEmpty()) {
			minuteString = String.valueOf(minute);
		}

		if (minute == 30) {
			minuteString = "half";
			prefix = "past";
		}

		if (hour == 24) {
			hourString = "midnight";
		}

		if (hour >= 13) {            // Normalizes hour
			hour = hour - 12;
		}

		if (hour == 0) {                            // Special case 1: midnight
			hourString = "midnight";
			if (minute == 0) {
				return "It is midnight";
			}
		}

		if (hour == 11 && hourString.isEmpty()) {                        // Special case: noon
			hourString = "noon";
		}

		if (hour == 12 && hourString.isEmpty()) {
			hourString = "noon";
		}

		if (minute == 0) {
			if (hourString.isEmpty()) {
				return "It is " + hour + " o'clock";
			} else {
				return "It is " + hourString + ".";
			}
		}

		if (hourString.isEmpty()) {
			hourString = String.valueOf(hour);
		}

		result = "It is " + minuteString + " " + prefix + " " + hourString + ".";
		return result;
	}
}