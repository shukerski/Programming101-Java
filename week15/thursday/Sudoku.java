package com.week15.thursday;

public class Sudoku {
	private static final int SIZE = 9;
	private int[][] board = new int[SIZE][SIZE];
	
	
	public Sudoku(int[][] board) {
		this.board = board;
	}

	public int[][] getBoard() {
		return board;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}
	
	public int[] getRowAtIndex(int index) {
		int[] result = new int[SIZE];
		for(int i = 0; i < SIZE; i++) {
			result[i] = board[index][i];
		}
		return result;
	}
	
	public int[] getColumnAtIndex(int index) {
		int[] result = new int[SIZE];
		for(int i = 0; i < SIZE; i++) {
			result[i] = board[i][index];
		}
		return result;
	}
	
	public int[][] getSquare(int number) { // the argument is one of the 9 (3 by 3) squares
		int [][] result = new int[3][3];
		
		int initialRowPosition = (number / 3) * 3;
		int initialColumn = (number % 3) * 3;
		
		for(int i = initialRowPosition, row = 0; i < initialRowPosition + 3; i++, row++) {
			for(int j = initialColumn, column = 0; j < initialColumn + 3; j++, column++) {
				result[row][column] = board[i][j];
			}
		}
		
		return result;
	}
	
	
}
