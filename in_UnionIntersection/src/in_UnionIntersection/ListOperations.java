package in_UnionIntersection;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
Give two sorted lists List<Integer> a and List<Integer> b. 

Find 
the Union of these two lists -> the union list should also be sorted 
the Intersection of these two lists -> Intersection list should also be sorted.
*/
public class ListOperations {
	
	@Test
	public void testIntersection() {
		ListOperations lo = new ListOperations();
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,4,5,8,9));
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 9));
		ArrayList<Integer> ans = lo.intersection(A, B);
		int [] actuals = new int[ans.size()];
		for (int i=0; i<actuals.length; i++) {
			actuals[i] = ans.get(i);
		}
		Assert.assertArrayEquals(new int[]{4, 5,9}, actuals);
		
	}

	public static void main(String[] args) {
		ListOperations lo = new ListOperations();
		
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(1,2,4,5,8,9));
		ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 9));
		ArrayList<Integer> result = lo.union(A, B);
		System.out.println("union of lists : ");
		for (int x: result) {
			System.out.print(x + " ");
		}
		System.out.println();
		System.out.println("intersection of lists: ");
		ArrayList<Integer> ans = lo.intersection(A, B);
		for (int x: ans) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	
	public ArrayList<Integer> intersection(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> result  = new ArrayList<Integer>();
		
		int i = 0, j = 0;
		int asize = A.size();
		int bsize = B.size();
		
		while (i < asize && j < bsize) {
			if (A.get(i) == B.get(j)) {
				result.add(A.get(i));
				++i;
			} else if (A.get(i) < B.get(j)) {
				++i;
			} else {
				++j;
			}
		}

		return result;
	}
	
	public ArrayList<Integer> union(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<Integer> result = new ArrayList<Integer>();
	
		int i = 0;
		int j = 0;
		int asize = A.size();
		int bsize = B.size();
		
		while (i < asize && j < bsize) {
			if (A.get(i) == B.get(j)) {
				result.add(A.get(i));
				++i;
				++j;
			} else if (A.get(i) < B.get(j)) {
				result.add(A.get(i));
				++i;
			} else {
				result.add(B.get(j));
				++j;
			}
		}
		while (i < asize) {
			result.add(A.get(i));
			++i;
		}
		
		while(j < bsize) {
			result.add(B.get(j));
				++j;
		}
		
		return result;
	}
}
