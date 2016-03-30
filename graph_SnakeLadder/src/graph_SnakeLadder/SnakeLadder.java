package graph_SnakeLadder;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	int vertex;
	int distance; //distance of this vertex from source.
	
	Node(int v, int d) {
		vertex = v;
		distance = d;
	}
}

public class SnakeLadder {
	
	public static void main(String[] args) {
		int N = 30;
	    int [] moves = new int[N];
	    for (int i = 0; i<N; i++)
	        moves[i] = -1;
	 
	    // Ladders
	    moves[2] = 21;
	    moves[4] = 7;
	    moves[10] = 25;
	    moves[19] = 28;
	 
	    // Snakes
	    moves[26] = 0;
	    moves[20] = 8;
	    moves[16] = 3;
	    moves[18] = 6;
	    
	    System.out.println("min dice throws: " + minDiceThrows(moves));
	}
	
	public static int minDiceThrows(int [] moves) {
		int N = moves.length;
		boolean [] visited = new boolean[N];
		
		Queue<Node> Q = new LinkedList<Node>();
		
		// Mark the node 0 as visited and enqueue it.
	    visited[0] = true;
	    Node start = new Node(0, 0);  // distance of 0't vertex is also 0
	    Q.add(start);  // Enqueue 0'th vertex
	    Node qnode = null;
	    
	    while (!Q.isEmpty()) {
	    	qnode = Q.remove();
	    	
	    	int v = qnode.vertex;
	    	if (v == N-1) {
	    		break;
	    	}
	    	
	    	for (int i=v+1; i<=(v+6) && i < N; i++) {
	    		if (!visited[i]) {
	    			visited[i] = true;
	    			int dist = qnode.distance + 1;
	    			int vert = -1;
	    			// Check if there a snake or ladder at 'j'
	                // then tail of snake or top of ladder
	                // become the adjacent of 'i'
	    			if (moves[i] != -1) {
	    				vert = moves[i];
	    			} else {
	    				vert = i;
	    			}
	    			Node node = new Node(vert, dist);
	    			Q.add(node);
	    		}
	    	}
	    }
	    
	    if (qnode != null) {
	    	return qnode.distance;
	    }
	    return -1;
	}
	
	

}
