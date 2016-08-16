package arr_MinWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindow {
	
	public static void main(String[] args) {
		int [] array = {2, 3, 4, 4, 5, 6, 3, 4, 4, 2, 3, 4, 5};
		Set<Integer> S = new HashSet<Integer>();
		S.add(2);
		S.add(3);
		S.add(5);
		
		System.out.println("min window: " + minWindow(array, S));
		//min window: 4
	}

	 private static int minWindow(int[] array, Set<Integer> S) {
		    if (array == null) {
		      return -1;
		    }
		    
		    Map<Integer, ArrayList<Integer>> indexMap = new HashMap<Integer, ArrayList<Integer>>();
		    int setSize = S.size();
		    for (Integer val: S) {
		    	indexMap.put(val, new ArrayList<Integer>());
		    }
		    
		    for (int i=0; i<array.length; i++) {
		      ArrayList<Integer> list = new ArrayList<Integer>();
		      if (indexMap.containsKey(array[i])) {
		        list = indexMap.get(array[i]);
		      }
		      list.add(i);
		      indexMap.put(array[i], list);
		    }
		    
		    for (Integer val: S) {
		    	if (indexMap.get(val).size() == 0) {
		    		return -1;
		    	}
		    }
		    
		    boolean done = false;
		 int minWindow = Integer.MAX_VALUE;
		while (true) {
			ArrayList<Node> nodeList = new ArrayList<Node>();
			for (Integer val : S) {
				ArrayList<Integer> currList = indexMap.get(val);
				if (currList.size() == 0) {
					done = true;
					break;
				}
				nodeList.add(new Node(currList.get(0), val));
			}
			if (done) {
				break;
			}
			Collections.sort(nodeList, new NodeComparator());
			int diff = Math.abs(nodeList.get(0).data - nodeList.get(setSize-1).data) + 1;
			if (diff < minWindow) {
				minWindow = diff;
			}
			//delete the min index
			ArrayList<Integer> updatedList = indexMap.get(nodeList.get(0).index);
			updatedList.remove(0);
			indexMap.put(nodeList.get(0).index, updatedList);
		}
		
		return minWindow;
	}
}

class Node {
	int index;
	int data;
	
	Node (int data, int index) {
		this.data = data;
		this.index = index;
	}
}

class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		return o1.data - o2.data;
	}
	
}