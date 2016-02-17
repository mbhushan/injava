package i_Combinations;

import java.util.ArrayList;
import java.util.Collections;

public class Combinations {
	
	private static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		Integer [] X = {2,3,6,7};
		int b = 7;
		ArrayList<Integer> a = new ArrayList<Integer>();
		Collections.addAll(a, X);
		
		combinationSum(a, b);
		for (ArrayList<Integer> y: result) {
			System.out.println(y);
		}
		
		
	}

	public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a,
			int b) {
	//	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (a.size() == 0) {
			return result;
		}
		Collections.sort(a);
		ArrayList<Integer> r = new ArrayList<Integer>();
		dfs(a, b, r, 0);
//		System.out.println("size: " + result.size());
//		for (ArrayList<Integer> x: result) {
//			System.out.println(x);
//		}
		return result;
	}

	private static void dfs(ArrayList<Integer> candidates, int target, ArrayList<Integer> r, int i) {
		if (target < 0) {
			return;
		} else {
			if (target == 0) {
				System.out.println("r: " + r);
				result.add(new ArrayList(r));
			} else {
				while ((i < candidates.size())
						&& (target - candidates.get(i).intValue() >= 0)) {
					r.add(candidates.get(i).intValue());
					dfs(candidates, target - candidates.get(i).intValue(),
							r, i);
					i++;
					r.remove(r.size() - 1);
				}
			}
		}

	}
}
