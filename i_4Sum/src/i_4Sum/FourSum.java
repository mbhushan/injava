package i_4Sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class FourSum {

	public static void main(String[] args) {
		Integer [] X = {1, 0, -1, 0, -2, 2};
		ArrayList<Integer> num = new ArrayList<Integer>();
		Collections.addAll(num, X);
		int target = 0;
		ArrayList<ArrayList<Integer>> res = fourSum(num, target);
		for (ArrayList<Integer> r : res) {
			System.out.println(r);
		}
	}
	public static  ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> num, int target) {
		Collections.sort(num);
		 
		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int N = num.size();
		
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int k = j + 1;
				int l = N - 1;
	 
				while (k < l) {
					int sum = num.get(i).intValue() + num.get(j).intValue() + num.get(k).intValue() + num.get(l).intValue();
	 
					if (sum > target) {
						l--;
					} else if (sum < target) {
						k++;
					} else if (sum == target) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num.get(i).intValue());
						temp.add(num.get(j).intValue());
						temp.add(num.get(k).intValue());
						temp.add(num.get(l).intValue());
	 
						if (!hashSet.contains(temp)) {
							hashSet.add(temp);
							result.add(temp);
						}
	 
						k++;
						l--;
					}
				}
			}
		}
	 
		return result;
	}
}
