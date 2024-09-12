package edu.ics211.h11;

/**
 * find a solution to a Sudoku problem
 * 
 * @author Biagioni, Edoardo
 * @date October 23, 2013
 * @missing fillSudoku, to be implemented by the students in ICS 211
 */
public class Sudoku {

	/**
	 * check that the sudoku rules hold in this sudoku puzzle. cells that contain 0
	 * are not checked.
	 * 
	 * @param sudoku      the sudoku to be checked
	 * @param printErrors whether to print the error found, if any
	 * @return true if this sudoku obeys all of the sudoku rules, otherwise false
	 */
	public static boolean checkSudoku(int[][] sudoku, boolean printErrors) {
		if (sudoku.length != 9) {
			if (printErrors) {
				System.out.println("sudoku has " + sudoku.length + " rows, should have 9");
			}
			return false;
		}
		for (int i = 0; i < sudoku.length; i++) {
			if (sudoku[i].length != 9) {
				if (printErrors) {
					System.out.println("sudoku row " + i + " has " + sudoku[i].length + " cells, should have 9");
				}
				return false;
			}
		}
		/* check each cell for conflicts */
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku.length; j++) {
				int cell = sudoku[i][j];
				if (cell == 0) {
					continue; /* blanks are always OK */
				}
				if ((cell < 1) || (cell > 9)) {
					if (printErrors) {
						System.out.println("sudoku row " + i + " column " + j + " has illegal value " + cell);
					}
					return false;
				}
				/* does it match any other value in the same row? */
				for (int m = 0; m < sudoku.length; m++) {
					if ((j != m) && (cell == sudoku[i][m])) {
						if (printErrors) {
							System.out.println(
									"sudoku row " + i + " has " + cell + " at both positions " + j + " and " + m);
						}
						return false;
					}
				}
				/* does it match any other value it in the same column? */
				for (int k = 0; k < sudoku.length; k++) {
					if ((i != k) && (cell == sudoku[k][j])) {
						if (printErrors) {
							System.out.println(
									"sudoku column " + j + " has " + cell + " at both positions " + i + " and " + k);
						}
						return false;
					}
				}
				/* does it match any other value in the 3x3? */
				for (int k = 0; k < 3; k++) {
					for (int m = 0; m < 3; m++) {
						int testRow = (i / 3 * 3) + k; /* test this row */
						int testCol = (j / 3 * 3) + m; /* test this col */
						if ((i != testRow) && (j != testCol) && (cell == sudoku[testRow][testCol])) {
							if (printErrors) {
								System.out.println("sudoku character " + cell + " at row " + i + ", column " + j
										+ " matches character at row " + testRow + ", column " + testCol);
							}
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	/**
	 * convert the sudoku to a printable string
	 * 
	 * @param sudoku the sudoku to be converted
	 * @param debug  whether to check for errors
	 * @return the printable version of the sudoku
	 */
	public static String toString(int[][] sudoku, boolean debug) {
		if ((!debug) || (checkSudoku(sudoku, true))) {
			String result = "";
			for (int i = 0; i < sudoku.length; i++) {
				if (i % 3 == 0) {
					result = result + "+-------+-------+-------+\n";
				}
				for (int j = 0; j < sudoku.length; j++) {
					if (j % 3 == 0) {
						result = result + "| ";
					}
					if (sudoku[i][j] == 0) {
						result = result + "  ";
					} else {
						result = result + sudoku[i][j] + " ";
					}
				}
				result = result + "|\n";
			}
			result = result + "+-------+-------+-------+\n";
			return result;
		}
		return "illegal sudoku";
	}

	/**
	 * find an assignment of values to sudoku cells that makes the sudoku valid
	 * 
	 * @param sudoku the sudoku to be filled
	 * @return whether a solution was found if a solution was found, the sudoku is
	 *         filled in with the solution if no solution was found, restores the
	 *         sudoku to its original value
	 */
	public static boolean fillSudoku(int[][] sudoku) {
		int row = -1;
		int column = -1;
		boolean emptyCellExists = false;
		// Find empty cells keep its location
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku[i][j] == 0) { // Store location of empty cell
					row = i;
					column = j;
					emptyCellExists = true;
					break; // Stops looping if we find an empty cell
				}
			}
			if (emptyCellExists) break; 
		}
		if (emptyCellExists) {
			int[] possible = possibleCellValues(sudoku, row, column); // Get an array of possible values in the cell
			if (possible.length == 0) { // No possible numbers
				return false;
			}
			for (int candidates = 0; candidates < possible.length; candidates++) { // Try each number possible number
				if (possible[candidates] == 0) continue;
				sudoku[row][column] = possible[candidates];
				if (fillSudoku(sudoku)) return true; // Sudoku is filled with correct values
			}
			sudoku[row][column] = 0; // No further possible values, so we reset it
			return false;
		} else { // No empty cells
			if (checkSudoku(sudoku, false)) { // Verify the sudoku is valid
				return true;
			} else {
				sudoku[row][column] = 0; // Reset value of the cell
				return false;
			}
		}
	}

	/**
	 * This method finds the possible values that can enter the cell and returns the
	 * possible values into the array
	 * 
	 * @param sudoku Sudoku that we are trying to solve.
	 * @param row    Row of the cell that we want to find possible values for
	 * @param column Column of the cell that we want to find possible values for
	 * @return Returns a int array that contains the values that we want insert into
	 *         that cell
	 */
	private static int[] possibleCellValues(int[][] sudoku, int row, int column) {
		int[] possibleValues = new int[10]; // Create an array thats max index is nine
		for (int possibleNumbers = 1; possibleNumbers < 10; possibleNumbers++) {
			sudoku[row][column] = possibleNumbers; // Fill the array with all values
			if (checkSudoku(sudoku, false)) {
				possibleValues[possibleNumbers] = possibleNumbers; // If the value is legal, then it saves it
			}
		}
		return possibleValues;
	}
}
