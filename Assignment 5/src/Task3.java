/*
 * Write a method  public static int countDistinctVowels(String str) that  takes 
 *  as input two parameters consisting of an English and returns number of distinct 
 *  vowel occurrences inside the string (which means you must not count the same vowels twice). It must be case insensitive (means case of a letter must NOT matter).
 *  
 *  For example:
 *  countDistinctVowels("Hello Love Earth") -->  3

 */

public class Task3 {

	public static void main(String[] args) {
		System.out.println(countDistinctVowels("Hello Love Earth")); // 3
		System.out.println(countDistinctVowels("Be The Change You Wanna See In The World!")); // 5
	}

	public static int countDistinctVowels(String str) {
		int count = 0;
		str = str.toLowerCase();		// Converts all string characters to lowercase for easier comparison
		if (str.indexOf('a') != -1) {
			count++;
		}
		if (str.indexOf('e') != -1) {
			count++;
		}
		if (str.indexOf('i') != -1) {
			count++;
		}
		if (str.indexOf('o') != -1) {
			count++;
		}
		if (str.indexOf('u') != -1) {
			count++;
		}
		return count;
	}
}