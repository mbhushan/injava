package graph_TopologicalSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;



public class TopologicalSort {
	
	public ArrayList<Integer> topoSort(GraphNode [] gnodes) {
		Stack<Integer> stack = new Stack<Integer>();
		boolean [] visited = new boolean [gnodes.length];
		
		for (int i=1; i<gnodes.length; i++) {
			if (!visited[gnodes[i].label]) {
				topoUtil(gnodes[i], visited, stack);
			}
		}
		ArrayList<Integer> result = new ArrayList<Integer>(stack);
		return result;
	}
	
	private void topoUtil(GraphNode gnode, boolean [] visited, Stack<Integer> stack) {
		visited[gnode.label] = true;
		for (GraphNode gn: gnode.neighbors) {
			if (!visited[gn.label]) {
				topoUtil(gn, visited, stack);
			}
		}
		stack.push(gnode.label);
	}
	
	public static void main(String[] args) {
		TopologicalSort TS = new TopologicalSort();
		
		GraphNode [] gnodes = new GraphNode[9];

		for (int i=1; i<gnodes.length; i++) {
			gnodes[i] = new GraphNode(i);
		}
		
		GraphNode [][] neighbors = {
				new GraphNode[]{},
				new GraphNode[]{gnodes[3]},
				new GraphNode[]{gnodes[3], gnodes[4]},
				new GraphNode[]{gnodes[5]},
				new GraphNode[]{gnodes[6]},
				new GraphNode[]{gnodes[6], gnodes[8]},
				new GraphNode[]{gnodes[7]},
				new GraphNode[]{},
				new GraphNode[]{},
		};
		
		for (int i=1; i<neighbors.length; i++) {
			for (GraphNode g: neighbors[i]) {
				if (g != null)
					System.out.print(g.label + ", ");
			}
			System.out.println();
		}
		for (int i=1; i<gnodes.length; i++) {
			ArrayList<GraphNode> list = new ArrayList<GraphNode>();
			Collections.addAll(list, neighbors[i]);
			gnodes[i].neighbors = list;
		}
		
//		for (int i=1; i<gnodes.length; i++) {
//			System.out.println(gnodes[i].toString());
//		}
		
		System.out.println("topo sort: ");
		ArrayList<Integer> topoResult = TS.topoSort(gnodes);
		Collections.reverse(topoResult);
		for (Integer x: topoResult) {
			System.out.print(x + " ");
		}
		System.out.println();
		
	}
}

class GraphNode {
	int label;
	GraphNode next;
	ArrayList<GraphNode> neighbors;
	
	GraphNode(int x) {
		this.label = x;
	}
	
	GraphNode(int x, ArrayList<GraphNode> neighbors) {
		this.label = x;
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