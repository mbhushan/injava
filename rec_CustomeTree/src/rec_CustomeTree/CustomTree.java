package rec_CustomeTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CustomTree {

	public static void main(String[] args) {
		CustomTree ct = new CustomTree();
		
		String [][] nodes = {
				{"a", "b"},
				{"b", "c"},
				{"b", "d"},
				{"a", "e"}
		};
		
		String [][] nodes1 = {
				{"a", "b"},
				{"a", "g"},
				{"b", "c"},
				{"c", "d"},
				{"d", "e"},
				{"c", "f"},
				{"z", "y"},
				{"y", "x"},
				{"x", "w"},
		};
		
		ct.printCustomTree(nodes1);
	}
	
	public void printCustomTree(String [][] nodes) {
		HashSet<String> starts = new HashSet<String>();
		HashSet<String> ends = new HashSet<String>();
		HashMap<String, ArrayList<String>> hmap = new HashMap<String, ArrayList<String>>();
		
 		for (int i=0; i<nodes.length; i++) {
 			String src = nodes[i][0];
 			String dest = nodes[i][1];
 			
 			starts.add(src);
 			ends.add(dest);
 			
 			ArrayList<String> list = new ArrayList<String>();
 			if (hmap.containsKey(src)) {
 				list = hmap.get(src);
 			}
 			list.add(dest);
 			hmap.put(src, list);
		}
 		ArrayList<String> roots = new ArrayList<String>();
 		for (String st: starts) {
 			if (!ends.contains(st)) {
 				roots.add(st);
 			}
 		}
 		
 		HashSet<String> visited = new HashSet<String>();
 		System.out.println("--------------------------");
 		for (String rt: roots) {
 			dfs(rt, hmap, visited, 0);
 			System.out.println("--------------------------");
 		}
	}
	
	private void dfs(String src, HashMap<String, ArrayList<String>> hmap, HashSet<String> visited, int step) {
		
		visited.add(src);
		
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<step; i++) {
			sb.append(" ");
		}
		System.out.println(sb.toString() + src);
		
		if (!hmap.containsKey(src)) {
			return;
		}
		ArrayList<String> list = hmap.get(src);
		int size = list.size();
		for (int i=0; i<size; i++) {
			String dest = list.get(i);
			if (!visited.contains(dest)) {
				dfs(dest, hmap, visited, step+5);
			}
		}
	}
}
/**
Custom Tree Problem
You are given a set of links, e.g.

a ---> b
b ---> c
b ---> d
a ---> e 

Print the tree that would form when each pair of these links that has the same character as start and end point is joined together. You have to maintain fidelity w.r.t. the height of nodes, i.e. nodes at height n from root should be printed at same row or column. For set of links given above, tree printed should be –

-->a
   |-->b
   |   |-->c
   |   |-->d
   |-->e
Note that these links need not form a single tree; they could form, ahem, a forest. Consider the following links

a ---> b
a ---> g
b ---> c
c ---> d
d ---> e
c ---> f
z ---> y
y ---> x
x ---> w
The output would be following forest.

-->a
   |-->b
   |   |-->c
   |   |   |-->d
   |   |   |   |-->e
   |   |   |-->f
   |-->g

-->z
   |-->y
   |   |-->x
   |   |   |-->w
You can assume that given links can form a tree or forest of trees only, and there are no duplicates among links.
*/
