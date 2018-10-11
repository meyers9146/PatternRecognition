 /*
 * Class: CMSC201
 * Instructor: Gregoriy Grinberg
 * Description: A program that requests a two-dimensional array of numbers from the user
 * and analyzes it for four-in-a-row matching numbers
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your name here: Michael Meyers
 */

import java.util.Scanner;

public class PatternRecognition {
	public static void main (String[] args) {
		
	Scanner input = new Scanner(System.in);
	
	boolean programRunning = true; //Program repeats while programRunning is true
	
	do {
	
	//Request number of rows
	System.out.println("Enter the number of rows for the list: ");
	int rows = input.nextInt();
	
	//Request number of columns
	System.out.println("Enter the number of columns: ");
	int columns = input.nextInt();
	
	//Check for a valid array size
	while (rows < 4 || columns < 4) {
		System.out.println("This program checks for 4 consecutive integers. Your"
				+ " array size is too small to test.");
		//Re-request number of rows
		System.out.println("Enter the number of rows for the list: ");
		rows = input.nextInt();
		//Re-request number of columns
		System.out.println("Enter the number of columns: ");
		columns = input.nextInt();
	}
	
	//Create the matrix with the given columns and rows
	int[][]matrix = new int[rows][columns];
	
	//Enter values for the matrix, separated by spaces. Hit Enter when finished
	System.out.println("Please enter " + rows*columns + " integer values separated"
			+ " by spaces to populate the matrix. Hit Enter when finished.");
	
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = input.nextInt();
			}
		}
	
		
		
	//Print the entered matrix
	System.out.println("Here is your entered matrix:");
	for(int i = 0; i < rows; i++) {
		for(int j = 0; j < columns; j++) {
			System.out.printf("%3d ", matrix[i][j]);
		}
		System.out.print("\n");
	}
	
	//Perform check for 4 consecutive numbers and return result
	System.out.println("This matrix " + ((isConsecutiveFour(matrix) == true )? "has":"does not have")
	+ " a sequence of four matching numbers.");
	
	//Ask if user wants to run again
	char YesNo = 'x';
	while (!(YesNo == 'Y' || YesNo == 'y' || YesNo == 'N' || YesNo == 'n')){
		System.out.println("Would you like to run the program again? Y/N");
		YesNo = input.next().charAt(0);
		}
	if (YesNo == 'Y' || YesNo == 'y') programRunning = true;
	else if (YesNo == 'N' || YesNo == 'n') programRunning = false;
	
	
	}while(programRunning);
	
	input.close();
	
	//Print programmer name at end and end program
	System.out.println("Programmed by Michael Meyers");
	System.out.println("Ending program...");
	
	}
	
	public static boolean isConsecutiveFour(int[][] values) {
	
		//check diagonal
		for (int i = 0; i < values.length-3; i++) {
			for (int j = 0; j < (values[0].length-3); j++) {
				if (values[i][j] == values[i+1][j+1] && values[i+1][j+1] == values[i+2][j+2]
						&& values[i+2][j+2] == values[i+3][j+3]) {
					return true;
				}
			}
		}
		//check horizontal
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[0].length - 3; j++) {
				if (values[i][j] == values[i][j+1] && values[i][j+1] == values[i][j+2]
				&& values[i][j+2] == values[i][j+3]) {
			return true;
				}
			}
		}
		//check vertical
		for (int i = 0; i < values.length-3; i++) {
			for (int j = 0; j < values[0].length; j++) {
				if (values[i][j] == values[i+1][j] && values[i+1][j] == values[i+2][j]
					&& values[i+2][j] == values[i+3][j]) {
					return true;
					}
				}
			}
		//check opposite diagonal
		for (int i = values.length-1; i > 2; i--) {
			for (int j = 0; j < values[0].length-3; j++) {
				if (values[i][j] == values [i-1][j+1] && values[i-1][j+1] == values[i-2][j+2]
						&& values[i-2][j+2] == values[i-3][j+3]) {
					return true;
				}
			}
		}
		return false;
		
	}
}