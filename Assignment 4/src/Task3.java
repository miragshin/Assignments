/*
 * Given array of integers, create a method int middleAverage(int[] arr) 
 *  which returns the "middle" average of an array of integers, which is 
 *  the mean average of its integers, except ignoring the largest and 
 *  smallest values in the array. If there are multiple copies of the 
 *  smallest value, ignore just one copy (consider other copies), 
 *  and likewise for the largest value. Use integer division to find the 
 *  final average. Assume that the array is length 3 or more.
 */

public class Task3 {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4, 100 };
		int[] nums2 = { 1, 1, 5, 5, 10, 8, 7 };
		int[] nums3 = { -10, -4, -2, -4, -2, 0 };

		System.out.println(middleAverage(nums1)); // 3
		System.out.println(middleAverage(nums2)); // 5
		System.out.println(middleAverage(nums3)); // -3
	}

	public static int middleAverage(int[] nums) {
		int sum = 0;
		int maximum = Integer.MIN_VALUE;			// Smallest integer
		int minimum = Integer.MAX_VALUE;			// Largest integer
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > maximum) {				// If greater than maximum
				maximum = nums[i];					// Assign new maximum
			}
			if (nums[i] < minimum) {				// If smaller than minimum
				minimum = nums[i];					// Assign new minimum
			}
			sum += nums[i];							// Sum of all elements in the array
		}
		sum = sum - (maximum + minimum);			// Excludes maximum and minimum
		return sum / (nums.length - 2);				// Finds and returns average value
	}
}