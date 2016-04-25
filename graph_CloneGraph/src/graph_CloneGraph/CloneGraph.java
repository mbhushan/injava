package graph_CloneGraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class GraphNode {
	int label;
	ArrayList<GraphNode> neighbors;
	
	GraphNode(int x) {
		this.label = x;
		neighbors = new ArrayList<GraphNode>();
	}
}

public class CloneGraph {
	
	public static GraphNode cloneGraph(GraphNode node) {
		if (node == null) {
			return null;
		}
		Queue<GraphNode> Q = new LinkedList<GraphNode>();
		HashMap<GraphNode, GraphNode> hmap = new HashMap<GraphNode, GraphNode>();
		GraphNode newHead = new GraphNode(node.label);
		Q.add(node);
		hmap.put(node, newHead);
		
		while (!Q.isEmpty()) {
			GraphNode curr = Q.remove();
			for (GraphNode gnode: curr.neighbors) {
				if (!hmap.containsKey(gnode)) {
					GraphNode copy = new GraphNode(gnode.label);
					hmap.put(gnode, copy);
					hmap.get(curr).neighbors.add(copy);
					Q.add(gnode);
				} else {
					hmap.get(curr).neighbors.add(hmap.get(gnode));
				}
			}
		}
		return newHead;
	}
	
	public static void main(String [] args) {
		int numNode = 5;
		GraphNode n1 = new GraphNode(1); 
		GraphNode n2 = new GraphNode(2); 
		GraphNode n3 = new GraphNode(3); 
		GraphNode n4 = new GraphNode(4); 
		GraphNode n5 = new GraphNode(5); 
 
		Collections.addAll(n1.neighbors, new GraphNode[]{n2,n3,n5});
		Collections.addAll(n2.neighbors, new GraphNode[]{n1,n4});
		Collections.addAll(n3.neighbors, new GraphNode[]{n1,n4,n5});
		Collections.addAll(n4.neighbors, new GraphNode[]{n2,n3,n5});
		Collections.addAll(n5.neighbors, new GraphNode[]{n1,n3,n4});
		
		GraphNode node = cloneGraph(n1);
		bfs(node, numNode);
	}
	
	public static void bfs(GraphNode node, int numNodes) {
		Queue<GraphNode> Q = new LinkedList<GraphNode>();
		boolean [] visited = new boolean[numNodes+1];
		Q.add(node);
		visited[node.label] = true;
		System.out.print(node.label + " ");
		while (!Q.isEmpty()) {
			GraphNode curr = Q.poll();
			for (GraphNode n: curr.neighbors) {
				if (!visited[n.label]) {
					System.out.print(n.label + " ");
					visited[n.label] = true;
					Q.add(n);
				}
			}
		}
		System.out.println();
	}
}
