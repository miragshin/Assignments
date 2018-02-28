// Last problem with patterns. Probably done


import java.util.Scanner;

public class Task8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		sc.close();
		int i1 = 1;
		int i2 = 1;
		int i3 = testCase;
		int testCaseDump = testCase;
		String whiteSpace = "";
		for (; i1 <= testCase; i1++) {								// Amount of lines
			for (i2 = 1; i2 <= testCaseDump; i2++) {				// Left half
				if (!(i2 == testCase))
					System.out.print(i2 + "  ");
			}
			System.out.print(whiteSpace);
			for (i3 = testCaseDump; i3 != 0; i3--) {				// Right half
				System.out.print(i3 + "  ");
			}
			System.out.println();									// Prints a new line
			if (i1 > 1)
				whiteSpace += "      ";								// Might want to
			else whiteSpace += "   ";								// Change the amount
			testCaseDump--;
		}
	}
}

// Actually I kinda wrote this 3 days ago ad forgot what it does
// so sorry if the comments are a little bit off



