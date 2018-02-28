/* Task01
 * 
 * Implement a boolean method public static boolean isEven(int x) which 
 * returns TRUE if number is even and returns FALSE if number is odd. 
 */

public class Task01 {

	public static void main(String[] args) {
		/* No need to modify main method. 
		 * Just make sure your method satisfies ALL possible test cases according to task instructions,
		 * such as below.*/

		System.out.println(isEven(9)); // false
		System.out.println(isEven(8)); // true
		System.out.println(isEven(2)); // true
		System.out.println(isEven(1)); // false
		System.out.println(isEven(0)); // true
		System.out.println(isEven(-2)); // true
		System.out.println(isEven(-5)); // false
	}

	public static boolean isEven(int x) {
		if (x % 2 == 0) return true;
		return false;
	}

	
}
