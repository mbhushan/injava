package fx_CycleUndirectedGraph;


import java.util.ArrayList;
import java.util.Collections;

public class CycleDetection {
	public static void main(String[] args) {
		CycleDetection CD = new CycleDetection();
		
		GraphNode [] gnodes = new GraphNode[6];
		
		for (int i=1; i<gnodes.length; i++) {
			gnodes[i] = new GraphNode(i);
		}
		
		GraphNode [][] neighbors = {
				new GraphNode[]{},
				new GraphNode[]{gnodes[2]},
				new GraphNode[]{gnodes[3]},
				new GraphNode[]{gnodes[4], gnodes[5]},
				new GraphNode[]{gnodes[5]},
				new GraphNode[]{},
		};
		
		for (int i=1; i<gnodes.length; i++) {
			ArrayList<GraphNode> list = new ArrayList<GraphNode>();
			Collections.addAll(list, neighbors[i]);
			gnodes[i].neighbors = list;
		}
		
		CD.detectCycle(gnodes);
	}
	
	public void detectCycle(GraphNode [] gnodes) {
		int len = gnodes.length;
		boolean [] visited = new boolean[len];
		int [] parent = new int[len];
		
		for (int i=1; i<len; i++) {
			if (!visited[gnodes[i].label]) {
				dfs(gnodes, gnodes[i].label, visited, parent);
			}
		}
	}
	
	private void dfs(GraphNode [] gnodes, int src, boolean [] visited, int [] parent) {
		visited[src] = true;
		for (GraphNode node: gnodes[src].neighbors) {
			if (visited[node.label]) {
				System.out.println("Cycle detected in this graph!!");
				int u = node.label;
				System.out.print(u + " <- ");
				while (parent[u] != src) {
					u = parent[u];
					System.out.print(u + " <- ");
				}
				System.out.print(src);
			} else if (!visited[node.label]){
				parent[node.label] = src;
				dfs(gnodes, node.label, visited, parent);
			}
		}
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
