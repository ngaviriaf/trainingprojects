package co.ngaviriaf.examples;

import java.util.Arrays;

public class Knight {

    public static void main(String[] args) {
        solveKnight();
    }

    static int n = 8;

    public static boolean solveKnight(){
        int board [][] = new int [8][8];
        
        for(int i = 0; i < board.length; i++){
            Arrays.fill(board[i], -1);
        }

        int xMove [] = { 2, 1, -1, -2, -2, -1, 1, 2};
        int yMove [] = { 1, 2, 2, 1, -1, -2, -2, -1}; 
        
        board [0][0] = 0;
        if(!solveKT(board, 1, 0, 0, xMove, yMove)){         
            System.out.println("No existe solución");
            return false;
        } else {
            imprimirSolucion(board);
        }

        return true;
    }

    public static boolean solveKT(int [][] board, int mov, int x, int y, int [] xMove, int [] yMove){
        int nextX, nextY;

        if(mov == n * n){
            return true;
        }

        for (int i = 0; i < 8; i++) {
            nextX = x + xMove[i];
            nextY = y + yMove[i];

            if(isSafe(board, nextX, nextY)){
                board[nextX][nextY] = mov;

                if(solveKT(board, mov + 1, nextX, nextY, xMove, yMove)){
                    return true;
                } else {
                    board[nextX][nextY] = -1;
                }
            }
        }
        
        return false;
    }

    public static boolean isSafe(int [][] board, int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n && board[x][y] == -1);
    }

    public static void imprimirSolucion(int [][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


}
