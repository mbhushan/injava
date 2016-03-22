package graph_BFS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	private int vertices;
	private LinkedList<Integer> [] adjList;
	
	Graph(int v) {
		this.vertices = v;
		adjList = new LinkedList[vertices];
		for (int i=0; i<vertices; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int u, int v) {
		adjList[u].add(v);
	}
	
	public void BFS(int source) {
		boolean [] visited = new boolean[vertices];
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		visited[source] = true;
		
		while (!queue.isEmpty()) {
			source = queue.remove();
			System.out.print(source + " -> ");
			Iterator<Integer> dest = adjList[source].listIterator();
			
			while (dest.hasNext()) {
				int v = dest.next();
				if (!visited[v]) {
					visited[v] = true;
					queue.add(v);
				}
			}
		}
		System.out.println("null");
	}
}
