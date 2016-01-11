package i_ThreeSumZero;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSum {

	public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
		Collections.sort(a);
		int len = a.size();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int count = 0;
		for (int i = 0; i < len - 2; i++) {
			int aa = a.get(i);
			int k = i + 1;
			int l = len - 1;
			int b, c = 0;
			while (k < l) {
				b = a.get(k);
				c = a.get(l);
				if ((aa + b + c) == 0) {
					ArrayList<Integer> numList = new ArrayList<Integer>();
					System.out.println("abc: " + aa + " " + b + " " + c);
					numList.add(aa);
					numList.add(b);
					numList.add(c);
					result.add(numList);
					++k;
				} else if ((aa + b + c) > 0) {
					l = l - 1;
				} else {
					k = k + 1;
				}
			}
		}
		printList(result);
		return result;
	}

	public static ArrayList<ArrayList<Integer>> threeSum1(ArrayList<Integer> a) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int n = a.size();

		if (n < 3)
			return result;

		// sort array
		Collections.sort(a);

		for (int i = 0; i < n - 2; i++) {
			// //avoid duplicate solutions
			if (i == 0 || a.get(i).intValue() > a.get(i - 1).intValue()) {

				int negate = -1 * a.get(i).intValue();

				int start = i + 1;
				int end = n - 1;

				while (start < end) {
					// case 1
					if (a.get(start).intValue() + a.get(end).intValue() == negate) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(a.get(i));
						temp.add(a.get(start));
						temp.add(a.get(end));

						result.add(temp);
						start++;
						end--;
						// avoid duplicate solutions
						while (start < end
								&& a.get(end).intValue() == a.get(end + 1)
										.intValue())
							end--;

						while (start < end
								&& a.get(start).intValue() == a.get(start - 1)
										.intValue())
							start++;
						// case 2
					} else if (a.get(start).intValue() + a.get(end).intValue() < negate) {
						start++;
						// case 3
					} else {
						end--;
					}
				}

			}
		}

		printList(result);
		return result;
	}

	private static void printList(ArrayList<ArrayList<Integer>> A) {
		int n = A.size();

		for (int i = 0; i < n; i++) {
			ArrayList<Integer> B = A.get(i);
			int m = B.size();
			for (int j = 0; j < m; j++) {
				System.out.print(B.get(j) + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] A = { -1, 0, 1, 2, -1, -4 };
		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			X.add(A[i]);
		}
		threeSum1(X);
	}
}
