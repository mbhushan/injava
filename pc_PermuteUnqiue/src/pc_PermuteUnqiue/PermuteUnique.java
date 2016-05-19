package pc_PermuteUnqiue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermuteUnique {

	public static void main(String[] args) {
		PermuteUnique PU = new PermuteUnique();
		
		int A [] = {1,1,2};
		
		ArrayList<ArrayList<Integer>> result = PU.permuteUnique(A);
		for (ArrayList<Integer> R: result) {
			for (Integer x: R) {
				System.out.print(x + " ");
			}
			System.out.println();
		}
	}
	
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
		returnList.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < num.length; i++) {
			Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
			for (List<Integer> l : returnList) {
				for (int j = 0; j < l.size() + 1; j++) {
					l.add(j, num[i]);
					ArrayList<Integer> T = new ArrayList<Integer>(l);
					l.remove(j);
					currentSet.add(T);
				}
			}
			returnList = new ArrayList<ArrayList<Integer>>(currentSet);
		}
	 
		return returnList;
	}
}
