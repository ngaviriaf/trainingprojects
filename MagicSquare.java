package co.ngaviriaf.examples;

import java.util.Arrays;

public class MagicSquare {
	
	static int n = 5;
	static int m = (int) ((n * (Math.pow(n, 2) + 1)) / 2);
	
	public static void main(String[] args) {
		solveSquare();
	}

	static boolean solveSquare() {
		
		int [][] board = new int [n][n];
		
		for (int i = 0; i < board.length; i++) {
			Arrays.fill(board[i], -1);
		}
		
		if(!solveSquare(board, 1)){
			System.out.println("No existe solución");
			return false;
		} else {
			printSquare(board);
		}
		
		return true;	
	}
	
	static void printSquare(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	static boolean solveSquare(int [][] board, int c){
		if(c > Math.pow(n, 2) && checkSolution(board)){
			return true;
		}
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j] == -1){
					board[i][j] = c;
					
					if(solveSquare(board, c + 1)){
						return true;
					} else {
						board[i][j] = -1;
					}
				}
			}
		}
		
		return false;
	}

	static boolean checkSolution(int board[][]) {
		printSquare(board);
		int d1 = 0; 
		int d2 = 0;
		
		for (int i = 0; i < board.length; i++) {
			int row = 0; 
			for (int j = 0; j < board[0].length; j++) {
				row += board[i][j];
				if(i == j){
					d1 += board[i][j];
				}
			}
			if(row != m)
				return false;	
		}
		
		if(d1 != m)
			return false;
		
		for (int i = 0; i < board[0].length; i++) {
			int col = 0; 
			for (int j = 0; j < board.length; j++) {
				col += board[j][i];
			}
			if(col != m)
				return false;
			
		}
		
		for (int i = 0, j = n-1; i < board.length && j >= 0; i++, j--) {
			d2 += board[i][j];
		}
		
		if(d2 != m)
			return false;
		
		return true;
	}

}
