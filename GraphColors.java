package co.ngaviriaf.examples;

import java.util.Arrays;

public class GraphColors {
	static int V = 4; 
	 static int color [];
    
    public static void main(String args[]) 
    { 
        graphColoring(); 
    }
    
    static boolean graphColoring(){
    	 /* Create following graph and test whether it is 
        3 colorable 
       (3)---(2) 
        |   / | 
        |  /  | 
        | /   | 
       (0)---(1) 
     */
     int graph[][] = {{0, 1, 1, 1}, 
         {1, 0, 1, 0}, 
         {1, 1, 0, 1}, 
         {1, 0, 1, 0}, 
     }; 
     
     int m = 4; // Number of colors 
     
     color = new int [V]; 
     Arrays.fill(color, 0);
     
     if(!graphColoring(graph, m, 0, color)){
    	 System.out.println("No tiene solución");
    	 return false;
     } else {
    	 printColors(color);
     }
     
     return true;
    }
    
    static boolean graphColoring(int [][] graph, int m, int node, int [] color){
    	if(node == V){
    		return true;
    	}
    	
    	for (int i = 1; i <= m ; i++) {
			if(isSafe(graph, node, i, color)){
				color[node] = i;
				
				if(graphColoring(graph, m, node + 1, color)){
					return true;
				} else {
					color[node] = 0;
				}
			}
		}
    	return false;
    }
    
    static boolean isSafe(int [][] graph, int node, int i, int [] color){
    	for (int j = 0; j < V; j++) {
			if (graph[node][j] == 1 && i == color[j]){
				return false;
			}
		}
    	
    	return true;
    }
    
    static void printColors(int [] colors){
    	for (int i = 0; i < colors.length; i++) {
			System.out.print(colors[i] + " ");
		}
    }

}
