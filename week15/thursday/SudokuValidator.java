package com.week15.thursday;

public class SudokuValidator {
//	The results array will be filled as follows:
//	 0 - 8 - the rows threads
//	 9 - 17 - the columns
//	 18 - 26 - the squares
	private static boolean[] results = new boolean[27];
	static Sudoku sudoku;

	public SudokuValidator(Sudoku sudoku) {
		this.sudoku = sudoku;
	}

	public boolean[] getResults() {
		return results;
	}

	public static class ValidRows implements Runnable {
		private int row;

		public ValidRows(int row) {
			this.row = row;
		}

		@Override
		public void run() {
			// If validity[0] is true, then 1 is present in the row, validity[1]
			// -> 2 is present and so on
			boolean[] validity = new boolean[9];
			int[] currentRow = sudoku.getRowAtIndex(row);

			for (int i = 0; i < 9; i++) {
				int number = currentRow[i];

				if (number < 1 || number > 9 || validity[number - 1]) {
					return;
				}
				validity[number - 1] = true;
			}

			// If the program reaches this line then the row is valid.
			results[row] = true;

		}
	}

	public static class ValidColumns implements Runnable {
		private int column;

		public ValidColumns(int column) {
			this.column = column;
		}

		@Override
		public void run() {
			// If validity[0] is true, then 1 is present in the column,
			// validity[1]
			// -> 2 is present and so on
			boolean[] validity = new boolean[9];
			int[] currentColumn = sudoku.getRowAtIndex(column);

			for (int i = 0; i < 9; i++) {
				int number = currentColumn[i];

				if (number < 1 || number > 9 || validity[number - 1]) {
					return;
				}
				validity[number - 1] = true;
			}

			// If the program reaches this line then the column is valid.
			results[column + 9] = true;
		}

	}

	public static class ValidSquares implements Runnable {
		private int square;

		public ValidSquares(int square) {
			this.square = square;
		}

		@Override
		public void run() {
			// If validity[0] is true, then 1 is present in the square,
			// validity[1]
			// -> 2 is present and so on
			boolean[] validity = new boolean[9];
			int[][] currentSquare = sudoku.getSquare(square);

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					int number = currentSquare[i][j];

					if (number < 1 || number > 9 || validity[number - 1]) {
						return;
					}
					validity[number - 1] = true;
				}
			}
			// If the program reaches this line then the square is valid.
			results[square + 18] = true;

		}

	}
}
