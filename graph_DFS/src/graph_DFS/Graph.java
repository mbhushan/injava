package graph_DFS;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	private int vertices;
	private LinkedList<Integer> [] adjList;
	
	Graph(int v) {
		vertices = v;
		adjList = new LinkedList[v];
		for (int i=0; i<v; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int u, int v) {
		adjList[u].add(v);
	}
	
	public void DFS(int src) {
		boolean [] visited = new boolean[vertices];
		DFSUtil(src, visited);
		System.out.println("null");
		
	}
	
	private void DFSUtil(int src, boolean [] visited) {
		visited[src] = true;
		System.out.print(src + " -> ");
		
		Iterator<Integer> it = adjList[src].iterator();
		while (it.hasNext()) {
			int dest = it.next();
			if (!visited[dest]) {
				DFSUtil(dest, visited);
			}
		}
	}
	
}
