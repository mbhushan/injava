package graph_CycleDetectionDFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class CycleDetection {
	public static void main(String[] args) {
		CycleDetection CS = new CycleDetection();
		
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
				new GraphNode[]{gnodes[1]},
		};
		
		for (int i=1; i<gnodes.length; i++) {
			ArrayList<GraphNode> list = new ArrayList<GraphNode>();
			Collections.addAll(list, neighbors[i]);
			gnodes[i].neighbors = list;
		}
		
		CS.dfsRec(gnodes);
	}
	
	public void dfsRec(GraphNode [] gnodes) {
		
		int len = gnodes.length;
		Stack<Integer> path = new Stack<Integer>();
		boolean [] visited = new boolean[len];
		int [] parent = new int[len];
		for (int i=1; i<gnodes.length; i++) {
			if (!visited[gnodes[i].label])
				dfsRecUtil(gnodes, gnodes[i].label, visited, path, parent);
		}
		
		System.out.println("dfs path is: ");
		//Collections.reverse(path);
		while (!path.isEmpty()) {
			System.out.print(path.pop() + " ");
		}
		System.out.println();
		System.out.println("parents structure is:");
		for (int i=1; i<len; i++) {
			System.out.println(i + "<-" + parent[i]);
		}
		
	}
	
	public void dfsRecUtil(GraphNode[] gnodes, int src, boolean [] visited, Stack<Integer> stack, int [] parent) {
		visited[src] = true;
		for (GraphNode node: gnodes[src].neighbors) {
			if (!visited[node.label]) {
				parent[node.label] = src;
				dfsRecUtil(gnodes, node.label, visited, stack, parent);
			}
		}
		stack.push(src);
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
