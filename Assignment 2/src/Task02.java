/* Task02 
 * 
 * Implement a boolean method public static boolean isPrime(int x) which 
 * returns TRUE if number is prime and returns FALSE if number is not prime.
 */

public class Task02 {

	public static void main(String[] args) {
		/* No need to modify main method. 
		 * Just make sure your method satisfies ALL possible test cases according to task instructions,
		 * such as below.*/
		
		System.out.println(isPrime(9)); // false
		System.out.println(isPrime(8)); // false
		System.out.println(isPrime(17)); // true
		System.out.println(isPrime(47)); // true
		System.out.println(isPrime(2)); // true
		System.out.println(isPrime(1)); // false
		System.out.println(isPrime(0)); // false
		System.out.println(isPrime(-3)); // false
	}

	public static boolean isPrime(int x) {
		if (x <= 0 || x == 1) return false;		// 0, 1 and negative numbers are not prime
		for (int i = (x - 1); i != 1; --i) {	// Iterates backwards to check for numbers one by one
			if (x % i == 0) return false;		// Returns false if a divisor is found
		}
		return true;							// Returns true if the loop finishes without finding a divisor
	}
}
