package graph_CheckBipartite;

import java.util.LinkedList;

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
}
