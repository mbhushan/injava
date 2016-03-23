package graph_UndirectedCycle;

import java.util.Iterator;
import java.util.LinkedList;

/*
 Detect cycle in an undirected graph
 Given an undirected graph, how to check if there is a cycle in the graph? 
 we can use DFS to detect cycle in an undirected graph in O(V+E) time. We do a DFS traversal of the given graph. For every visited vertex ‘v’, if there is an 
 adjacent ‘u’ such that u is already visited and u is not parent of v, then there is a cycle in graph. If we don’t find such an 
 adjacent for any vertex, we say that there is no cycle. The assumption of this approach is that there are no parallel edges between 
 any two vertices.
 */

public class UGraph {
	private int vertices;
	private LinkedList<Integer>[] adjList;

	public UGraph(int v) {
		vertices = v;
		adjList = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		adjList[u].add(v);
		adjList[v].add(u);
	}

	public boolean hasCycle() {
		boolean[] visited = new boolean[vertices];

		for (int u = 0; u < vertices; u++) {
			if (!visited[u]) {
				if (hasCycleUtil(u, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean hasCycleUtil(int v, boolean[] visited, int parent) {
		visited[v] = true;

		Iterator<Integer> it = adjList[v].iterator();

		while (it.hasNext()) {
			int u = it.next();
			if (!visited[u]) {
				if (hasCycleUtil(u, visited, v))
					return true;
			} else if (u != parent) {
				return true;
			}
		}
		return false;
	}

}
