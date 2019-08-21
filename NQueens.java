package co.ngaviriaf.examples;

import java.util.Arrays;

public class NQueens {
	
	public static void main(String[] args) {
		solveNQueens();
	}
	
	static int n = 8;
	
	static boolean solveNQueens(){
		int [][] board = new int [n][n];
		
		for (int i = 0; i < board.length; i++) {
			Arrays.fill(board[i], 0);
		}
		
		if(!solveNQueens(board, 0)){
			System.out.println("No tiene solución");
			return false;
		} else {
			printBoard(board);
		}
		
		return true;
	}
	
	static boolean solveNQueens(int [][] board, int col){
		if(col == n){
			return true;
		}
		
		for (int i = 0; i < board.length; i++) {
			if(isSafe(board, i, col)){
				board[i][col] = 1;				
				if(solveNQueens(board, col+1)){
					return true;
				} else {
					board[i][col] = 0;
				}
			}
		}
		return false;
	}
	
	static boolean isSafe(int[][] board, int row, int col) {
		int i, j;
		
		for (i = 0; i < col; i++) {
			if(board[row][i] == 1){
				return false;
			}
		}
		
		for (i = row, j = col; i >= 0 && j >=0; i--, j--) {
			if(board[i][j] == 1){
				return false;
			}
		}
		
		for (i = row, j = col; i < n && j >=0; i++, j--) {
			if(board[i][j] == 1){
				return false;
			}
		}
		
		return true;
	}

	public static void printBoard(int [][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
	
	
}
