package i_SlidingMax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SlidingMax {
	
	public static void main(String[] args) {
		int [] A = {1, 3, -1, -3, 5, 3, 6, 7};
		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		int window = 3;
		
		X = slidingMaximum(X, window);
	}

	public static ArrayList<Integer> slidingMaximum(final List<Integer> nums, int window) {
		
		int size = nums.size();
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (window >= size) {
			int mx = Collections.max(nums);
			result.add(mx);
			return result;
		}
		int w = window;  
		   // A deque allows insertion/deletion on both ends.  
		   // Maintain the first as the index of maximal of the window  
		   // and elements after it are all smaller and came later than the first.  
		   Deque<Integer> que = new LinkedList<Integer>();
		   
		   // initialize window  
		   int i=0;  
		   while (i<w) {  
		     while (!que.isEmpty() && nums.get(que.getLast()).intValue() <= nums.get(i).intValue()) {  
		       que.removeLast();  
		     }  
		     que.addLast(i++);  
		   }  
		   
		   // sliding window  
		   //int[] max = new int[size - w + 1];  
		   int max = nums.get(que.getFirst());  
		   result.add(max);
		     System.out.print(max + " ");
		  // i = w;
		   while (i<size) {  
		     // add new element  
		     while (!que.isEmpty() && nums.get(que.getLast()).intValue() <= nums.get(i).intValue()) {  
		       que.removeLast();  
		     }  
		     que.addLast(i);  
		     // remove old element if still in que  
		     if (!que.isEmpty() && i-w >= que.getFirst()) {  
		       que.removeFirst();  
		     }  
		     // get maximal  
		     ++i;  
		     max = nums.get(que.getFirst()).intValue();
		     result.add(max);
		     System.out.print(max + " ");
		   }  
		   System.out.println();
		   System.out.println("result.size: " + result.size());
		   
		   return result;  
	}
}
