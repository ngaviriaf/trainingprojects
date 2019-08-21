package co.ngaviriaf.examples;

public class TanquesTuberias {
	public static void main(String[] args) {
		int[] capacidad = { 10, 25, 30, 53 };
		int[] tanques = { 0, 0, 0, 0 };
		int[][] adj = new int[capacidad.length][capacidad.length];

		adj[0][1] = 1;
		adj[0][2] = 4;
		adj[2][3] = 8;

		int f = 4;
		int t = 20;

		getFinalState(adj, capacidad, tanques, f, t);
	}

	static void getFinalState(int[][] adj, int[] capacidad, int[] tanques, int f, int t) {
		if (t == 0) {
			printState(tanques);
			return;
		}

		if (t == 20) {
			capacidad[0] -= f;
			tanques[0] += f;
			getFinalState(adj, capacidad, tanques, f, t - 1);
		}

		for (int i = tanques.length-1 ; i >= 0; i--) {
			if (tanques[i] != 0) {
				for (int j = 0; j < adj[i].length; j++) {
					if (adj[i][j] != 0) {
						int transfer = canTransfer(adj[i][j], i, j, capacidad, tanques);
						if (transfer > 0) {
							capacidad[j] -= transfer;
							tanques[j] += transfer;
							
							capacidad[i] += transfer;
							tanques[i] -= transfer;
						}
					}
				}
			}
		}
		
		if(capacidad[0] <= f ){
			tanques[0] += capacidad[0];
			capacidad[0] = 0;	 
		} else {
			capacidad[0] -= f;
			tanques[0] += f;
		}
		
		getFinalState(adj, capacidad, tanques, f, t - 1);
		
	}

	static int canTransfer(int pipe, int i, int j, int [] capacidad, int [] tanques) {
		int cantTransferir = tanques[i];
		int cantRecibir = capacidad[j];
		
		if(cantTransferir > pipe){
			cantTransferir = pipe;
		}
		
		if(cantRecibir == 0){
			return 0;
		}
		
		if(cantRecibir < cantTransferir){
			return cantRecibir;
		}
		
		return cantTransferir;
	}
	
	private static void printState(int [] tanques) {
		for (int i = 0; i < tanques.length; i++) {
			System.out.print(tanques[i] + " ");
		}
		System.out.println();
	}
}
