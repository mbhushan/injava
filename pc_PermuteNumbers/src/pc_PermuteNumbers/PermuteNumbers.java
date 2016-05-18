package pc_PermuteNumbers;

import java.util.ArrayList;

public class PermuteNumbers {
	
	public ArrayList<ArrayList<Integer>> permuteNumbers(int [] A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		//start with empty list
		result.add(new ArrayList<Integer>());
		
		for (int i=0; i<A.length; i++) {
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
			
			for (ArrayList<Integer> l : result) {
				// # of locations to insert is largest index + 1
				for (int j = 0; j < l.size()+1; j++) {
					// + add A[i] to different locations
					l.add(j, A[i]);
	 
					ArrayList<Integer> temp = new ArrayList<Integer>(l);
					current.add(temp);
	 
					//System.out.println(temp);
	 
					// - remove A[i] add
					l.remove(j);
				}
			}
			result = new ArrayList<ArrayList<Integer>>(current);
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		PermuteNumbers PN = new PermuteNumbers();
		
		int [] A = {1, 2, 3};
		ArrayList<ArrayList<Integer>> result = PN.permuteNumbers(A);
		for (ArrayList<Integer> R: result) {
			for (Integer x: R) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
		
	}
}
