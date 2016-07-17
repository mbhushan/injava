package graph_TopologicalSorting;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
	
	public static void main(String[] args) {
		int numNodes = 8;
		Graph graph = new Graph(numNodes);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		
		graph.printGraph();
		graph.topologicalSort();
		
	}
}

class Graph {
	private GraphNode [] gnodes;
	private int numNodes;
	
	public Graph(int nodes) {
		this.numNodes = nodes;
		gnodes = new GraphNode[nodes];
		for (int i=0; i<nodes; i++) {
			gnodes[i] = new GraphNode(i);
		}
	}
	
	public void addEdge(int u, int v) {
		gnodes[u].neighbors.add(gnodes[v]);
	}
	
	public void topologicalSort() {
		boolean [] visited = new boolean[numNodes];
		Stack<GraphNode> stack = new Stack<GraphNode>();
		
		for (int index = 0; index < numNodes; index++) {
			if (!visited[gnodes[index].label]) {
				topologicalSortUtil(gnodes[index].label, visited, stack);
			}
		}
		
		System.out.println("topological sorted: ");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop().label + " ");
		}
		System.out.println();
		
	}
	
	private void topologicalSortUtil(int u, boolean [] visited, Stack<GraphNode> stack) {
		visited[u] = true;
		
		ArrayList<GraphNode> neighbors = gnodes[u].neighbors;
		for (GraphNode v : neighbors) {
			if (!visited[v.label]) {
				topologicalSortUtil(v.label, visited, stack);
			}
		}
		stack.push(gnodes[u]);
	}
	
	public void printGraph() {
		System.out.println("input graph: ");
		for (int index=0; index<gnodes.length; index++) {
			System.out.println(gnodes[index].toString());
		}
	}
	
//	private void addNodes(int label, ArrayList<Integer> neighbors) {
//		for (Integer neighbor: neighbors) {
//			gnodes[label].neighbors.add(gnodes[neighbor]);
//		}
//	}
}

class GraphNode {
	int label;
	ArrayList<GraphNode> neighbors;
	
	public GraphNode (int label) {
		this.label = label;
		this.neighbors = new ArrayList<GraphNode>();
	}
	
	public GraphNode(int label, ArrayList<GraphNode> neighbors) {
		this.label = label;
		this.neighbors = neighbors;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("label: " + this.label + "\n");
		if (this.neighbors != null) {
			sb.append("neighbors: ");
			for (GraphNode gn: this.neighbors) {
				if (gn != null) {
					sb.append(gn.label + " ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
