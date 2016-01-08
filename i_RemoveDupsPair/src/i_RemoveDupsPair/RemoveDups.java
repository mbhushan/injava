package i_RemoveDupsPair;

import java.util.ArrayList;

public class RemoveDups {
	
	
	public static int removeDuplicates(ArrayList<Integer> a) {
		int n = a.size();
		
		if(n<3) return n;
		
        int anchor=1;
        for(int i=2; i<n; ++i) {
            if(!a.get(anchor).equals(a.get(i)) || !a.get(anchor).equals(a.get(anchor-1))) {
            	System.out.println("anchor: " + anchor + ", i: " + i);
            	++anchor;
                a.set(anchor, a.get(i));
            }
        }
        a.subList(anchor+1, n).clear();
        printList(a);
        return anchor+1;
	}

	public static int removeDuplicates1(ArrayList<Integer> a) {
		int count = 1;
		int n = a.size();
		
		
		int prev = a.get(0);
		int track = 1;
		for (int i=1; i<n; i++) {
			if (prev == a.get(i)) {
				++track;
				++count;
			} else {
				track = 1;
				a.set(count, a.get(i));
				prev = a.get(i);
                ++count;
			}
			if (track == 2) {
				while ((i < n) && (prev == a.get(i))) {
					i++;
				}
				--i;
				prev = a.get(i);
				System.out.println("i: " + i + " prev:" + prev);
			}
			
		}
		
		a.subList(count, n).clear();
		printList(a);
		
		return a.size();
	}
	
	private static void printList(ArrayList<Integer> A) {
		for (int i=0; i<A.size(); i++) {
			System.out.print(A.get(i) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//int [] A = {1, 1, 1, 2};
		//int [] A = {1,1,1,2,2,3};
		int [] A={1000, 1000, 1000, 1000, 1001, 1002, 1003, 1003, 1004, 1010};
		//int [] A = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		
		System.out.println("array size: " + removeDuplicates(X));
	}
}
