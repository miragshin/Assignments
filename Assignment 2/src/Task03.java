/* Task03
 * 
 * Implement a boolean method public static boolean isPowerOfTwo(int x) which 
 * returns TRUE if number is power of 2 and returns FALSE otherwise. 
 */

public class Task03 {

	public static void main(String[] args) {
		/* No need to modify main method. 
		 * Just make sure your method satisfies ALL possible test cases according to task instructions,
		 * such as below.*/
		
		System.out.println(isPowerOfTwo(9)); // false
		System.out.println(isPowerOfTwo(17)); // false
		System.out.println(isPowerOfTwo(16)); // true
		System.out.println(isPowerOfTwo(2)); // true
		System.out.println(isPowerOfTwo(1)); // true
		System.out.println(isPowerOfTwo(0)); // false
		System.out.println(isPowerOfTwo(-4)); // false
	}

	public static boolean isPowerOfTwo(int x) {
		if (x == 1) return true;					// Who cares, it works
		if (x <= 0 || x % 2 != 0) return false;		// Returns false if the number is 0, negative, isn't a divisor of 2
		double dump = Math.log(x) / Math.log(2);	// Calculates the logarithm of to the base of 2
		if (Math.floor(dump) == dump) return true;	// If x is a power of 2, log(x) cannot be a floating point value
		return false;								// If everything else above fails
	}
}
