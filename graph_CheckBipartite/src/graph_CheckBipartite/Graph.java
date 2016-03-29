package graph_CheckBipartite;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	private int vertices;
	private LinkedList<Integer> [] adjList;
	
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		vertices = V;
		adjList = new LinkedList[V];
		for (int i=0; i<V; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int u, int v) {
		adjList[u].add(v);
	}
	
	public boolean isBipartite() {
		int src = 0;
		int [] colors = new int[vertices];
		Arrays.fill(colors, -1);
		
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(src);
		colors[src] = 1;
		
		while (!Q.isEmpty()) {
			int u = Q.poll();
			LinkedList<Integer> adj = adjList[u];
			for (int v: adj) {
				if (colors[v] == colors[u]) {
					return false;
				} else if (colors[v] == -1) {
					colors[v] = 1 - colors[u];
					Q.add(v);
				}
			}
		}
		
		return true;
	}
}
