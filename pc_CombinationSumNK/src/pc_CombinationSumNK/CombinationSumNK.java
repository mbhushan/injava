package pc_CombinationSumNK;

import java.util.ArrayList;

public class CombinationSumNK {

	public static void main(String[] args) {
		CombinationSumNK CS = new CombinationSumNK();
		
		int n = 4;
		int k = 2;
		
		ArrayList<ArrayList<Integer>> result = CS.combine(n, k);
		for (ArrayList<Integer> R: result) {
			for (Integer r: R) {
				System.out.print(r + " ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (n <= 0 || n < k) {
			return result;
		}
		
		ArrayList<Integer> item = new ArrayList<Integer>();
		dfs(n, k, 1, item, result);
		
		return result;
	}
	
	private void dfs(int n, int k, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result) {
		if (item.size() == k) {
			ArrayList<Integer> list = new ArrayList<Integer>(item);
			result.add(list);
			return;
		}
		
		for (int i=start; i<=n; i++) {
			item.add(i);
			dfs(n, k, i+1, item, result);
			item.remove(item.size()-1);
		}
	}
}
