package i_Pascal1;

import java.util.ArrayList;

public class Solution {

	public ArrayList<ArrayList<Integer>> generate(int a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		for (int i=1; i<=a; i++) {
			result.add(getRow(i));
		}
		
		return result;
	}
	
	public ArrayList<Integer> getRow(int a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(1);
		int n = 0;
		for (int i=0; i<a; i++) {
			n = (result.get(i) * (a-i)) / (i+1);
			result.add(n);
		}
		return result;
	}
}
