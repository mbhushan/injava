package arr_SortByFrequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/*
Sort elements by frequency | Set 1
Print the elements of an array in the decreasing frequency 
if 2 numbers have same frequency then print the one which came first.
*/
public class SortByFrequency {

	public static void main(String[] args) {
		int [][] A = {
				{2, 5, 2, 8, 5, 6, 8, 8},
				{2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8}
		};
		
		SortByFrequency SF = new SortByFrequency();
		for (int i=0; i<A.length; i++) {
			ArrayList<Integer> result = SF.sortByFrequency(A[i]);
			for (Integer x: result) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<Integer> sortByFrequency(int [] A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (A == null || A.length <= 1) {
			return result;
		}
		HashMap<Integer, Node> hmap = new HashMap<Integer, Node>();
		for (int i=0; i<A.length; i++) {
			Node node = new Node();
			if (hmap.containsKey(A[i])) {
				node = hmap.get(A[i]);
				node.freq = node.freq + 1;
			} else {
				node.data = A[i];
				node.index = i;
				node.freq = 1;
			}
			hmap.put(A[i], node);
		}
		
		ArrayList<Node> values = new ArrayList<Node>(hmap.values());
		Collections.sort(values, new NodeComparator());
		
		for (Node n: values) {
			for (int i=0; i<n.freq; i++) {
				result.add(n.data);
			}
		}
		return result;
	}
}

class NodeComparator implements Comparator<Node>{
	public int compare(Node n1, Node n2) {
		if (n1.freq < n2.freq) {
			return 1;
		} else if (n1.freq > n2.freq) {
			return -1;
		} else if (n1.freq == n2.freq) {
			return n1.index - n2.index;
		}
		return 0;
	}
}

class Node {
	int data;
	int index;
	int freq;
}
