/*
 * Given array of integers, create a method
 *  int [] order49(int[] arr) which returns an array
 *  that contains exactly the same numbers as the given
 *  array, but rearranged so that every 4 is immediately
 *  followed by a 9. Do not move the 4's, but every other
 *  number may move. The array contains the same number
 *  of 4's and 9's, every 4 has a number after it that is
 *  not a 4 or 9, and a 4 appears in the array before any 9.
 */

import java.util.Arrays;

public class Task4 {

	public static void main(String[] args) {
		int[] nums1 = {1, 4, 1, 9};
		int[] nums2 = {1, 4, 1, 9, 9, 4, 1};
		int[] nums3 = {4, 2, 2, 9};

		nums1 = order49(nums1);
		nums2 = order49(nums2);
		nums3 = order49(nums3);

		System.out.println(Arrays.toString(nums1)); // [1,4,9,1]
		System.out.println(Arrays.toString(nums2)); // [1,4,9,1,1,4,9]
		System.out.println(Arrays.toString(nums3)); // [4,9,2,2]
	}

	public static int[] order49(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 4) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[j] == 9) {
						if ((j > 1 && arr[j - 1] != 4) || j == 0) {
							int temp = arr[i + 1];
							arr[i + 1] = arr[j];
							arr[j] = temp;
						}
					}
				}
			}
		}
		return arr;
	}
}

/*
arr[0] = 1		dump[0] = 1		i = 0	j = 0
arr[1] = 4		dump[1] = 4		i = 1	j = 1	1. dump[1] = 4	2. dump[2] = 9	3. j = 3
arr[2] = 9		dump[2] = 9		i = 2	j = 3	1. dump[3] =
arr[3] = 1		dump[3]


{1,4,1,9}
{1,4,9,1

1. i = 0 j = 0 dump[0] = arr[0]; (1)
1. i = 1 j = 1 dump[1] = arr[1]; (4)
   i = 1 j = 1 dump[2] = 9	j = 2 (9)
2. i = 2 j = 3 dump[3] = arr[2];




 */