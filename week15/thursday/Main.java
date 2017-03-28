package com.week15.thursday;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.week15.thursday.SudokuValidator.ValidRows;
import com.week15.thursday.SudokuValidator.ValidColumns;
import com.week15.thursday.SudokuValidator.ValidSquares;

public class Main {

	public static void main(String[] args) {
		   int[][] board =
			      {{5, 3, 4, 6, 7, 8, 9, 1, 2},
			       {6, 7, 2, 1, 9, 5, 3, 4, 8},
			       {1, 9, 8, 3, 4, 2, 5, 6, 7},
			       {8, 5, 9, 7, 6, 1, 4, 2, 3},
			       {4, 2, 6, 8, 5, 3, 7, 9, 1},
			       {7, 1, 3, 9, 2, 4, 8, 5, 6},
			       {9, 6, 1, 5, 3, 7, 2, 8, 4},
			       {2, 8, 7, 4, 1, 9, 6, 3, 5},
			       {3, 4, 5, 2, 8, 6, 1, 7, 9}};
		   
		   Sudoku s = new Sudoku(board);
		   SudokuValidator sv = new SudokuValidator(s);
		   ExecutorService service = Executors.newFixedThreadPool(3);
		   
		   for(int i = 0; i < 9; i++) {
			   service.submit(new ValidRows(i));
			   service.submit(new ValidColumns(i));
			   service.submit(new ValidSquares(i));
		   }
		   
		   service.shutdown();
		   
		   boolean[] res = sv.getResults();
		   boolean validBoard = true;
		   
		   for(int i = 0; i < res.length; i++) {
			   if(res[i] == false) {
				   validBoard = false;
			   }
		   }
		   
		   if(validBoard) {
			   System.out.println("The board is valid!");
		   } else {
			   System.out.println("The board is not valid!");
		   }

	}

}
