package co.ngaviriaf.examples;

public class RatMaze {
	
	public static void main(String[] args) {
		solveMaze();
	}
	
	static int n = 4;
	
	static boolean solveMaze(){
		int [][] maze = {
				{1, 0, 0, 0},
				{1, 1, 1, 1},
				{0, 1, 0, 0},
				{1, 1, 1, 1}
				};
		
		int [] movesX = {1, 0};
		int [] movesY = {0, 1};
		
		maze[0][0] = 7;
		
		if(!solveMaze(maze, 0, 0, movesX, movesY)){
			System.out.println("No tiene solución");
			return false;
		} else {
			printMaze(maze);
		}
		return true;
	}
	
	static boolean solveMaze(int [][] maze, int x, int y, int [] movesX, int [] movesY){
		int nextX, nextY;
		
		if( x == (n-1) && y == (n-1)){
			return true;
		}
		
		for(int i = 0; i < 2; i ++){
			nextX = x + movesX[i];
			nextY = y + movesY[i];
			
			
			if(isSafe(maze, nextX, nextY)){
				maze[x][y] = 7;
				
				if(solveMaze (maze, nextX, nextY, movesX, movesY)){
					return true;
				} else {
					maze[x][y] = 1;
				}
			}
		}
		
		return false;
	}
	
	static boolean isSafe(int [][] maze, int x, int y){
		return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1);
	}
	
	static void printMaze(int [][] maze){
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }
	
}
