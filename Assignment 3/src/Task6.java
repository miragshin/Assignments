// Thing with #'s

// Probably works

import java.util.Scanner;

public class Task6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String output = "#";
		int testCase = sc.nextInt();
		sc.close();
		for (int i1 = 0; i1 < testCase; i1++) {
			System.out.println(output);
			for (int i2 = 0; i2 <= i1; i2++) {
				output = output + "#";
			}
		}
	}
}

//1. 1
//2. 2
//3. 4
//4. 7
//5. 11