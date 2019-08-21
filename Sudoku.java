package co.ngaviriaf.examples;

public class Sudoku {
	public static void main(String args[]) { 
	   solveSudoku();
	} 
	
	static boolean solveSudoku(){
		int[][] board = new int[][] 
				    { 
				            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
				            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
				            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
				            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
				            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
				            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
				            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
				            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
				            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
				    }; 
				    
		if(!solveSudoku(board)){
			System.out.println("El sudoku no tiene solución");
			return false;
		} else {
			printSudoku(board);
		}
		
		return true;
	}
	
	
	 static void printSudoku(int [][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}		
	}

	static boolean solveSudoku(int [][] board){
		int row = -1;
		int col = -1;
		boolean isFinished = true;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j] == 0){
					row = i;
					col = j;
					isFinished = false;
				}
			}
		}
		
		if(isFinished){
			return true;
		}
		
		for (int n = 1; n <= board.length; n++) {
			if(isSafe(board, row, col, n)){
				board[row][col] = n;
				
				if(solveSudoku(board)){
					return true;
				} else {
					board[row][col] = 0;
				}
			}
		}
		
		return false;
	}

	static boolean isSafe(int[][] board, int row, int col, int n) {
		for (int i = 0; i < board.length; i++) {
			if(board[i][col] == n){
				return false;
			}
		}
		
		for (int i = 0; i < board[row].length; i++) {
			if(board[row][i] == n){
				return false;
			}
		}
		
		int sqrt = (int) Math.sqrt(board.length);
		
		int rowStart = row - row % sqrt;
		int colStart = col - col % sqrt;
		
		for (int i = rowStart; i < rowStart + sqrt; i++) {
			for (int j = colStart; j < colStart + sqrt; j++) {
				if(board[i][j] == n){
					return false;
				}
			}
		}
		return true;
	}
}
