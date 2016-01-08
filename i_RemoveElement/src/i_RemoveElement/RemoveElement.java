package i_RemoveElement;

import java.util.ArrayList;

public class RemoveElement {
	
	public static int removeElement1(ArrayList<Integer> a, int b) {
	    int count = 0;  
		int n = a.size();
		 
        for (int i = 0; i < n; i++) {
            if (a.get(i) != b) {
                a.set(count, a.get(i));
                ++count;
            } 
        }
 
        //a = new ArrayList<Integer>( a.subList(0, count));
        a.subList(count, n).clear();
        int ans = n - count;
        printList(a);
        return ans;
	}

	public static int removeElement(ArrayList<Integer> a, int b) {
		int count = 0;  
		int n = a.size();
		 
        for (int i = 0; i < n; i++) {
            if (a.get(i) != b) {
                a.set(count, a.get(i));
                ++count;
            } 
        }
 
        //a = new ArrayList<Integer>( a.subList(0, count));
        a.subList(count, n).clear();
        int ans = n - count;
        
        printList(a);
        return ans;
	}
	
	private static void printList(ArrayList<Integer> A) {
		for (int i=0; i<A.size(); i++) {
			System.out.print(A.get(i) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//int [] A = {4,1,1,2,1,3};
		int [] A = {2, 0, 1, 2, 0, 3, 2, 2, 2, 1, 0, 0, 0, 1, 0, 0, 2, 2, 2, 3, 2, 3, 1, 2, 1, 2, 2, 3, 2, 3, 0, 3, 0, 2, 1, 2, 0, 0, 3, 2, 3, 0, 3, 0, 2, 3, 2, 2, 3, 1, 3, 3, 0, 3, 3, 0, 3, 3, 2, 0, 0, 0, 0, 1, 3, 0, 3, 1, 3, 1, 0, 2, 3, 3, 3, 2, 3, 3, 2, 2, 3, 3, 3, 1, 3, 2, 1, 0, 0, 0, 1, 0, 3, 2, 1, 0, 2, 3, 0, 2, 1, 1, 3, 2, 0, 1, 1, 3, 3, 0, 1, 2, 1, 2, 2, 3, 1, 1, 3, 0, 2, 2, 2, 2, 1, 0, 2, 2, 2, 1, 3, 1, 3, 1, 1, 0, 2, 2, 0, 2, 3, 0, 1, 2, 1, 1, 3, 0, 2, 3, 2, 3, 2, 0, 2, 2, 3, 2, 2, 0, 2, 1, 3, 0, 2, 0, 2, 1, 3, 1, 1, 0, 0, 3, 0, 1, 2, 2, 1, 2, 0, 1, 0, 0, 0, 1, 1, 0, 3, 2, 3, 0, 1, 3, 0, 0, 1, 0, 1, 0, 0, 0, 0, 3, 2, 2, 0, 0, 1, 2, 0, 3, 0, 3, 3, 3, 0, 3, 3, 1, 0, 1, 2, 1, 0, 0, 2, 3, 1, 1, 3, 2 };
		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		int b = 2;
		//System.out.println("ans: " + removeElement(X, b));
		System.out.println("ans: " + removeElement1(X, b));
	}
}
