package graph_DetectCycle;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

	int vertices;
	LinkedList<Integer> [] adjList;
	
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
	
	public boolean hasCycle() {
		boolean [] visited = new boolean[vertices];
		boolean [] recStack = new boolean[vertices];
		
		for (int i=0; i<vertices; i++) {
			if (hasCycleUtil(i, visited, recStack)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean hasCycleUtil(int v, boolean [] visited, boolean [] recStack) {
		if (!visited[v]) {
			visited[v] = true;
			recStack[v] = true;
			Iterator<Integer> it = adjList[v].iterator();
			while (it.hasNext()) {
				int u = it.next();
				if (!visited[u] && hasCycleUtil(u, visited, recStack)) {
					return true;
				} else if (recStack[u]) {
					return true;
				}
			}
		}
		
		// remove the vertex from recursion stack
		recStack[v] = false;
		return false;
	}
}
