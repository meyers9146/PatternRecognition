import java.util.Scanner;

public class PatternRecognition {
	public static void main (String[] args) {
		
	Scanner input = new Scanner(System.in);
	
	//Request number of rows
	System.out.println("Enter the number of rows for the list: ");
	int rows = input.nextInt();
	
	//Request number of columns
	System.out.println("Enter the number of columns: ");
	int columns = input.nextInt();
	
	//Check for a valid array size
	while (rows < 4 || columns < 4) {
		System.out.print("This program checks for 4 consecutive integers. Your"
				+ " array size is too small to test.");
		//Re-request number of rows
		System.out.println("Enter the number of rows for the list: ");
		rows = input.nextInt();
		//Re-request number of columns
		System.out.println("Enter the number of columns: ");
		columns = input.nextInt();
	}
	
	int[][]matrix = new int[columns][rows];
	
	//Enter values for the matrix, separated by spaces. Hit Enter when finished
	System.out.println("Please enter " + rows*columns + " integer values separated"
			+ " by spaces to populate the matrix. Hit Enter when finished.");
	
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = input.nextInt();
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.printf("%2d ", matrix[i][j]);
			}
			System.out.print("\n");
		}
	
		input.close();
		
	//Print the entered matrix
	System.out.println("Here is your entered matrix:");
	for(int i = 0; i < columns; i++) {
		for(int j = 0; j < rows; j++) {
			System.out.printf("%3d ", matrix[i][j]);
		}
		System.out.print("\n");
	}
	
	//Perform check for 4 consecutive numbers and return result
	System.out.println("This matrix " + ((isConsecutiveFour(matrix) == true )? "has":"does not have")
	+ " a sequence of four matching numbers.");
		
	}
	
	public static boolean isConsecutiveFour(int[][] values) {
	
		for (int i = 0; i < values.length-3; i++) {
			for (int j = 0; j < (values[0].length-3); j++) {
				//check diagonal
				if (values[i][j] == values[i+1][j+1] && values[i+1][j+1] == values[i+2][j+2]
						&& values[i+2][j+2] == values[i+3][j+3]) {
					return true;
				}
				//check horizontal
				else if (values[i][j] == values[i][j+1] && values[i][j+1] == values[i][j+2]
						&& values[i][j+2] == values[i][j+3]) {
					return true;
				}
				//check vertical
				else if (values[i][j] == values[i+1][j] && values[i+1][j] == values[i+2][j]
						&& values[i+2][j] == values[i+3][j]) {
					return true;
				}
			}
		}
		//check opposite diagonal
		for (int i = values.length; i > 2; i--) {
			for (int j = values[0].length; j > 2; j--) {
				if (values[i][j] == values [i-1][j-1] && values[i-1][j-1] == values[i-2][j-2]
						&& values[i-2][j-2] == values[i-3][j-3]) {
					return true;
				}
			}
		}
		return false;
		
	}
}