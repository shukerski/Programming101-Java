package com.week02.friday;

import java.util.Scanner;

public class GameOfLife {
	//■ □
	public static char[][] board = new char[20][20];
	public static char [][] previousBoard = new char[20][20];
	
	public static void printBoard(char[][] board)
	{
		for(int i = 0; i < 20; i++){
			for(int j = 0; j < 20; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	public static char  changeCell(int x, int y, char[][]board){
		int liveNeighbours = 0;
		for(int i = -1; i < 2; i++)
			for(int j = -1; j < 2; j++) {
				if((x + i >= 0) && (y + j >= 0) && (x + i < 20) && (y + j < 20)) {
					if(board[x+i][y+j]=='■' && !(i==0 && j==0)){
						liveNeighbours++;
					}
				}		
			}
		
		if(liveNeighbours <2 && board[x][y]=='■')
			return '□';
		if( (liveNeighbours==2 || liveNeighbours == 3) && board[x][y]=='■')
			return '■';
		if(liveNeighbours > 3 && board[x][y]=='■')
			return '□';
		if(board[x][y]=='□' && liveNeighbours == 3)
			return '■';
		if(board[x][y]=='□')
			return '□';
		else
			return 'e'; // error
	}

	public static void main(String [] args) throws InterruptedException{
		
		// Initializing a blank board
		for(int i = 0; i < 20; i++)
			for(int j = 0; j < 20; j++)
			{
				board[i][j] = '□';
			}
		
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			int x = reader.nextInt();
			int y = reader.nextInt();
			board[x][y] = '■';
		}
		reader.close();
		
		printBoard(board);
		
		while(true) {
			for(int i = 0; i < 20; i++) {
				for(int j = 0; j < 20; j++) {
					previousBoard[i][j] = board[i][j];
				}
			}
			for(int i = 0; i < 20; i++) {
				for(int j = 0; j < 20; j++) {
					board[i][j] = changeCell(i,j, previousBoard);
				}
			}
			
			printBoard(board);
			Thread.sleep(1000);
		}
	}
}
