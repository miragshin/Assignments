
/*
 * Given array of integers, create a method 
 *  int[] zeroComesFirst(int[] arr) which returns 
 *  an array that contains the exact same numbers 
 *  as the given array, but rearranged so that all 
 *  the zeros come at the start of the array. 
 * The order of the non-zero numbers does not matter. 
 * So {1, 0, 0, 1} becomes {0, 0, 1, 1}. 
 * You may modify and return the given array or 
 *  make a new array. If the given array does not have any zeros, 
 *  the method must return the exact same array.

 */

import java.util.Arrays;

public class Task2 {

	public static void main(String[] args) {
		int[] nums1 = { 1, 0, 0, 1 };
		int[] nums2 = { 0, 1, 5, 0, 2 };
		int[] nums3 = { 1, 0 };

		nums1 = zeroComesFirst(nums1);
		nums2 = zeroComesFirst(nums2);
		nums3 = zeroComesFirst(nums3);

		System.out.println(Arrays.toString(nums1)); // [0,0,1,1]
		System.out.println(Arrays.toString(nums2)); // [0,0,1,5,2]
		System.out.println(Arrays.toString(nums3)); // [0,1]
	}

	public static int[] zeroComesFirst(int[] arr) {
		int[] dumpArr = new int[arr.length];			// Copy array
		int count = 0;									// Counts amount of 0's
		
		// Finds how many 0's the array has
		for (int i: arr) {
			if (i == 0)
				count++;
		}
		
		// Appends all 0's to the beginning of new array
		for (int i = 0; i < count; i++) {
			dumpArr[i] = 0;
		}
		
		// Appends the rest of the values to the new array in the order they are given
		for (int i = 0; i < arr.length; i++) {			// Original array
			if (arr[i] != 0) {							// Ignores the iteration if 0
				dumpArr[count] = arr[i];				// If != 0 append
				count++;								// Iterator
			}
		}
		return dumpArr;									// Returns new array with modified order
	}
}
