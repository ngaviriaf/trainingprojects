package co.ngaviriaf.examples;

import java.util.ArrayList;
import java.util.List;

public class HamiltonianCycle {

	public static void main(String args[]) 
    { 
        /* Let us create the following graph 
           (0)--(1)--(2) 
            |   / \   | 
            |  /   \  | 
            | /     \ | 
           (3)-------(4)    */
        int graph1[][] = {{0, 1, 1, 0, 0}, 
            {1, 0, 1, 0, 1}, 
            {1, 1, 0, 1, 0}, 
            {0, 0, 1, 0, 1}, 
            {0, 1, 0, 1, 0}, 
        }; 
  
        // Print the solution 
        hamCycle(graph1); 
  
        /* Let us create the following graph 
           (0)--(1)--(2) 
            |   / \   | 
            |  /   \  | 
            | /     \ | 
           (3)       (4)    */
        int graph2[][] = {{0, 1, 0, 1, 0}, 
            {1, 0, 1, 1, 1}, 
            {0, 1, 0, 0, 1}, 
            {1, 1, 0, 0, 0}, 
            {0, 1, 1, 0, 0}, 
        }; 
  
        // Print the solution 
        hamCycle(graph2); 
    } 

	static boolean hamCycle(int [][] graph){
		List <Integer> visited = new ArrayList<>();
		
		visited.add(0);
		
		if(!hamCycle(graph, visited, 0)){
			System.out.println("El grafo no tiene ciclo hamiltoniano.");
			return false;
		} else {
			printCycle(visited);
		}
		
		return true;
	}
	
	
	static boolean hamCycle(int [][] graph, List <Integer> visited, int node){
		if(visited.size() == graph.length && graph[node][0] == 1){
			return true;
		}
		
		for (int i = 0; i < graph[node].length; i++) {
			if(graph[node][i] == 1 && !visited.contains(i)){
				visited.add(i);
				if(hamCycle(graph, visited, i)){
					return true;
				} else {
					int pos = visited.indexOf(i);
					visited.remove(pos);
				}
			}
		}
		return false;
	}
	
	static void printCycle(List <Integer> visited){
		for (Integer integer : visited) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}
	
}
