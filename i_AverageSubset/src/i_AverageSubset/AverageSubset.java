package i_AverageSubset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AverageSubset {
	
	static HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<Integer, ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> resp = new ArrayList<ArrayList<Integer>> ();
	//static ArrayList<Integer> alist = new ArrayList<Integer>();

	public static void main(String[] args) {
		Integer[] X = { 1, 7, 15, 29, 11, 9 };
		ArrayList<Integer> a = new ArrayList<Integer>();

		Collections.addAll(a, X);
		//avgset(a);
		
		
		possibleSums(X, 0, 0, new ArrayList<Integer>());
		System.out.println("hmap length: " + hmap.size());
		partitionEqualAvg(X);
		for (ArrayList<Integer> r: resp) {
			System.out.println(r);
		}
	}
	
	public static void possibleSums(Integer[] numbers, int index, int sum, ArrayList<Integer> output)
	{
		if (index == numbers.length)
		{
			System.out.println(output + " => " + sum);
			ArrayList<Integer> val = (ArrayList<Integer>)output.clone();
			hmap.put(sum, val);
			return;
		}

		// include numbers[index]
		output.add(numbers[index]);
		possibleSums(numbers, index + 1, sum + numbers[index], output);

		// exclude numbers[index]
		//output.remove(numbers[index]);
		output.remove(output.size()-1);
		possibleSums(numbers, index + 1, sum, output);
	}

	public static void partitionEqualAvg(Integer[] A) {
		int n = A.length;
		int S = sumOfArray(A);
		// double avg = (double)S/(double)n;
		double avg = S / n;
		int subsetLen = n / 2;

		boolean[][][] T = new boolean[subsetLen + 1][n + 1][S + 1];

		for (int i = 0; i <= n; i++) {
			T[0][i][0] = true;
		}

		for (int k = 1; k <= subsetLen; k++) {
			for (int i = 1; i < n; i++) {
				for (int j = 1; j <= S; j++) {
					if (A[i] <= j) {
						T[k][i][j] = T[k - 1][i - 1][j - A[i]];
					}
					T[k][i][j] = T[k][i][j] || T[k][i - 1][j];
					if (T[k][i][j]) {
						double tempAvg = (double) j / (double) k;
						if (Math.abs((tempAvg - avg)) <= 0.0001) {
							System.out.println("Partition 1: " + j + " " + k);
							System.out.println("Partition 2: " + (S - j) + " "
									+ (n - k));
							
		System.out.println("hmap length: " + hmap.size());
		if (hmap.containsKey(j)) {
			System.out.println("j is there!");
			System.out.println("j val: "+hmap.get(j));
		}
							ArrayList<Integer> first = hmap.get(j);
							System.out.println("first: " + first);
							ArrayList<Integer> second = hmap.get(S-j);
							if (k <= (n-k)) {
								resp.add(first);
								resp.add(second);
							} else if (k > (n-k)) {
								resp.add(second);
								resp.add(first);
							} 
							return;
						}
					}
				}
			}
		}
		System.out.println("No partition with equal average possible!");
	}

	public static int sumOfArray(Integer[] A) {
		int len = A.length;
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += A[i];
		}
		return sum;
	}

	public static ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> a) {
		int size = a.size();
		int sum = getSum(a);
		ArrayList<Integer> SFactors = factors(sum);
		ArrayList<Integer> NFactors = factors(size);

		printList(SFactors);
		printList(NFactors);
		System.out.println("total sum: " + sum);

		for (Integer s : SFactors) {
			int val = sum - s;
			// if (SFactors.contains(val)) {
			for (Integer n : NFactors) {
				int left = size * s;
				int right = n * sum;
				if (left == right) {
					System.out.println("left: " + left);
					System.out.println("s: " + s);
					System.out.println("n: " + n);
				}
			}
			// }
		}

		return null;
	}

	private static void printList(ArrayList<Integer> A) {
		for (Integer n : A) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

	private static int getSum(ArrayList<Integer> A) {
		int sum = 0;
		int len = A.size();
		for (int i = 0; i < len; i++) {
			sum += A.get(i).intValue();
		}
		return sum;
	}

	private static ArrayList<Integer> factors(int num) {
		ArrayList<Integer> factors = new ArrayList<Integer>();

		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				factors.add(i);
			}
		}
		return factors;
	}
}
