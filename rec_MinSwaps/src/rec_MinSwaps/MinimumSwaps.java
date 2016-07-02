package rec_MinSwaps;

import java.util.HashMap;

/*
Minimum number of swaps required for arranging pairs adjacent to each other
There are n-pairs and therefore 2n people. everyone has one unique number ranging from 1 to 2n. All these 2n persons are arranged in random fashion in an Array of size 2n. We are also given who is partner of whom. Find the minimum number of swaps required to arrange these pairs such that all pairs become adjacent to each other.

Example:

Input:
n = 3  
pairs[] = {1->3, 2->6, 4->5}  // 1 is partner of 3 and so on
arr[] = {3, 5, 6, 4, 1, 2}

Output: 2
We can get {3, 1, 5, 4, 6, 2} by swapping 5 & 6, and 6 & 1
*/
public class MinimumSwaps {

	public static void main(String[] args) {
		MinimumSwaps ms = new MinimumSwaps();
		
		int [] A = {3, 5, 6, 4, 1, 2};
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		hmap.put(1, 3);
		hmap.put(3, 1);
		hmap.put(2, 6);
		hmap.put(6, 2);
		hmap.put(4, 5);
		hmap.put(5, 4);
		
		System.out.println("min swaps: " + ms.minSwap(A, hmap));
		
	}
	
	public int minSwap(int [] A, HashMap<Integer, Integer> pairs) {
		HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		for (int i=0; i<A.length; i++) {
			indexMap.put(A[i], i);
		}
		
		return minSwap(A, pairs, indexMap, 0);
	}
	
	private int minSwap(int [] A, HashMap<Integer, Integer> pairs, HashMap<Integer, Integer> indexMap, int index) {
		if (index == A.length) {
			return 0;
		}
		
		int v1 = A[index];
		int v2 = A[index+1];
		
		if (pairs.get(v1) == v2) {
			return minSwap(A, pairs, indexMap, index+2);
		} else {
			int idx1 = indexMap.get(v1);
			int idx2 = indexMap.get(v2);
			
			int idx3 = indexMap.get(pairs.get(v1));
			int idx4 = indexMap.get(pairs.get(v2));
			
			swap(A, indexMap, idx2, idx3, v2, pairs.get(v1));
			int val1 = minSwap(A, pairs, indexMap, index+2);
			swap(A, indexMap, idx2, idx3, v2, pairs.get(v1));
			
			swap(A, indexMap, idx1, idx4, v1, pairs.get(v2));
			int val2 = minSwap(A, pairs, indexMap, index+2);
			swap(A, indexMap, idx1, idx4, v1, pairs.get(v2));
			
			return 1 + Math.min(val1, val2);
		}
	}
	
	private void swap(int [] A, HashMap<Integer, Integer> indexMap, int i, int j, int v1, int v2) {
		indexMap.put(v1, j);
		indexMap.put(v2, i);
		
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
}
