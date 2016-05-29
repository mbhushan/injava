package graph_DFSCycle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class GraphCycle {

	public static void main(String[] args) {
		GraphCycle GC = new GraphCycle();
		
		GraphNode [] gnodes = new GraphNode[7];
		
		for (int i=1; i<gnodes.length; i++) {
			gnodes[i] = new GraphNode(i);
		}
		
		GraphNode [][] neighbors = {
				new GraphNode[]{},
				new GraphNode[]{gnodes[2], gnodes[3]},
				new GraphNode[]{gnodes[3]},
				new GraphNode[]{},
				new GraphNode[]{gnodes[1], gnodes[5]},
				new GraphNode[]{gnodes[6]},
				new GraphNode[]{gnodes[4]},
		};
		
		for (int i=1; i<gnodes.length; i++) {
			ArrayList<GraphNode> list = new ArrayList<GraphNode>();
			Collections.addAll(list, neighbors[i]);
			gnodes[i].neighbors = list;
		}
		GC.detectCycle(gnodes);
	}
	
	public void detectCycle(GraphNode [] gnodes) {
		int len = gnodes.length;
		boolean [] visited = new boolean[len];
		int parent []  = new int[len];
		HashSet<Integer> hset = new HashSet<Integer>();
		int size = gnodes.length;
		for (int i=1; i<size; i++) {
			if (!visited[gnodes[i].label]) {
				dfs(gnodes, gnodes[i].label, visited, hset, parent);
			}
		}
	}
	
	private void dfs(GraphNode [] gnodes, int src, boolean [] visited, HashSet<Integer> hset, int [] parent) {
		visited[src] = true;
		hset.add(src);
		for (GraphNode node: gnodes[src].neighbors) {
			if (hset.contains(node.label)) {
				System.out.println("Cycle detected in graph!");
				int u = src;
				System.out.print(u + " <- ");
				while (parent[u] != node.label) {
					u = parent[u];
					System.out.print(u + " <- ");
				}
				System.out.print(node.label);
			} else {
				if (!visited[node.label]) {
					parent[node.label] = src;
					dfs(gnodes, node.label, visited, hset, parent);
				}
			}
		}
		hset.remove(src);
	}
	
}

class GraphNode {
	int label;
	ArrayList<GraphNode> neighbors;
	
	public GraphNode(int x) {
		this.label = x;
		neighbors = new ArrayList<GraphNode>();
	}
	
	public GraphNode(int x, ArrayList<GraphNode> neighbors) {
		this.label = x;
		this.neighbors = neighbors;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("label: " + this.label + "\n");
		sb.append("neighbors: ");
		if (this.neighbors != null && this.neighbors.size() > 0) {
			for (GraphNode node: this.neighbors) {
				sb.append(node.label + " ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
		
	}
}
