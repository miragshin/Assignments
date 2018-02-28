 package extra;
/*
 * Code an interactive, two-player game of Tic-Tac-Toe. 
 * Hint. You'll use a two-dimensional array of chars.
 */

import java.util.Scanner;
public class Task7_TicTacToe {

	public static void main(String[] args) {
		char[][] arr = {
				{' ', ' ', ' '},
				{' ', ' ', ' '},
				{' ', ' ', ' '}
		};

		Scanner input = new Scanner(System.in);
		int row, column;
		int count = 0;

		printChart(arr);
		while (true) {
			count++;	// Counts the amount of times the loop as executed
			System.out.print("'X', choose your location (row, column): ");

			// For X input
			while (true) {
				row = input.nextInt();
				column = input.nextInt();
				if (slotAvailable(arr, row, column)) {
					break;
				}
				System.out.println(row + " " + column + " is not available. Please enter again.");
				printChart(arr);
			}
			arr[row][column] = 'X';
			printChart(arr);

			if (isOver(arr)) {
				System.out.println("'X' is the winner.");
				break;
			}

			System.out.print("'O', choose your location (row, column): ");

			// For O input
			while (true) {
				row = input.nextInt();
				column = input.nextInt();
				if (slotAvailable(arr, row, column)) {
					break;
				}
				System.out.println(row + " " + column + " is not available. Please enter again.");
				printChart(arr);
			}
			arr[row][column] = 'O';
			printChart(arr);
			if (isOver(arr)) {
				if (count == 5) {
					System.out.println("The game is a tie.");
					break;
				} else {
					System.out.println("'O' is the winner.");
					break;
				}
			}
		}
	}

	// This method checks each possible row, column and diagonal to check whether the game is finished or not
	private static boolean isOver(char arr[][]) {
			 if (arr[0][0] == arr[0][1] && arr[0][0] == arr[0][2] && arr[0][0] != ' ') return true;
		else if (arr[1][0] == arr[1][1] && arr[1][0] == arr[1][2] && arr[1][0] != ' ') return true;
		else if (arr[2][0] == arr[2][1] && arr[2][0] == arr[2][2] && arr[2][0] != ' ') return true;
		else if (arr[0][0] == arr[1][0] && arr[0][0] == arr[2][0] && arr[0][0] != ' ') return true;
		else if (arr[0][1] == arr[1][1] && arr[0][1] == arr[2][1] && arr[0][1] != ' ') return true;
		else if (arr[0][2] == arr[1][2] && arr[0][2] == arr[2][2] && arr[0][2] != ' ') return true;
		else if (arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2] && arr[0][0] != ' ') return true;
		else if (arr[0][2] == arr[1][1] && arr[0][2] == arr[2][0] && arr[0][2] != ' ') return true;
		else return false;
	}

	// This method takes the array and prints it out
	private static void printChart(char[][] arr) {
		System.out.println('\t' + "* | 0 | 1 | 2 |");
		System.out.println('\t' + "0 | " + arr[0][0] + " | " + arr[0][1] + " | " + arr[0][2] + " |");	// X X X
		System.out.println('\t' + "1 | " + arr[1][0] + " | " + arr[1][1] + " | " + arr[1][2] + " |");	// X X X
		System.out.println('\t' + "2 | " + arr[2][0] + " | " + arr[2][1] + " | " + arr[2][2] + " |");	// X X X
	}

	// This method checks whether the slot the user entered is available (taken)
	private static boolean slotAvailable(char[][] arr, int row, int column) {
		if (arr[row][column] == ' ') return true;
		else return false;
	}
}