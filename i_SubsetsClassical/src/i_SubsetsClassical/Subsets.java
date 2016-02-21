package i_SubsetsClassical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Subsets {

	public static void main(String[] args) {
		//Integer[] X = { 3, 2, 1 };
		Integer [] X = {15, 20, 12, 19, 4 };
		//Integer [] X = {16, 17, 7, 3, 6, 18, 5, 13, 14 };
		ArrayList<Integer> S = new ArrayList<Integer>();
		Collections.addAll(S, X);
		ArrayList<ArrayList<Integer>> result = subsets(S);
		// Collections.sort(result);
//		Collections.sort(result, new Comparator<ArrayList<Integer>>() {
//			@Override
//			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
//				StringBuffer sb1 = new StringBuffer();
//				StringBuffer sb2 = new StringBuffer();
//				for (Integer i : o1) {
//					sb1.append(i);
//				}
//				for (Integer i : o2) {
//					sb2.append(i);
//				}
//				return sb1.toString().compareTo(sb2.toString()) > 0 ? 1 : -1;
//			}
//		});
		for (ArrayList<Integer> r : result) {
			System.out.println(r);
			// System.out.println("st_r: " + r.toString());
		}

	}

	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
		// sort the given set
		Collections.sort(S);
		// generate subsets
		ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
		results.add(new ArrayList<Integer>());
		int N = S.size();
		for (int i = 0; i < N; ++i) {
			int curSize = results.size();
			while (curSize-- > 0) {
				ArrayList<Integer> res = new ArrayList<Integer>(
						results.get(curSize));
				res.add(S.get(i).intValue());
				results.add(res);
			}
		}

		Collections.sort(results, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
//				StringBuffer sb1 = new StringBuffer();
//				StringBuffer sb2 = new StringBuffer();
//				for (Integer i : o1) {
//					sb1.append(i);
//				}
//				for (Integer i : o2) {
//					sb2.append(i);
//				}
//				return sb1.toString().compareTo(sb2.toString()) > 0 ? 1 : -1;
				int o1len = o1.size();
				int o2len = o2.size();
				int i=0, j=0;
				
				while ((i < o1len) && (j < o2len)) {
					if (o1.get(i).intValue() < o2.get(j).intValue()) {
						return -1;
					} 
					if (o1.get(i).intValue() > o2.get(j).intValue()) {
						return 1;
					} 
					++i;
					++j;
				}
				return 0;
			}
		});

		return results;
	}
}
