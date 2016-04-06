package indeed_Quantiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

	private HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
	private int[] uniqVals;
	private int Q = 0;
	private int N = 0;

	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Solution sol = new Solution();
		sol.readInput();
		//sol.printValues();
		//System.out.println("k: " + (int)Math.ceil((float)3/2));
		sol.computeQuantiles();
	}
	
	public void computeQuantiles() {
		Arrays.sort(uniqVals);
		int [] result = new int[Q-1];
		
		for (int k=1; k<Q; k++) {
			int i = (int) Math.ceil( ((float)N * k) / Q);
			result[k-1] = getQValue(i);
		}
		Arrays.sort(result);
		for (int r: result) {
			System.out.println(r);
		}
	}
	
	private int getQValue(int index) {
		int value = 0;
		for (int key: uniqVals) {
			value += hmap.get(key);
			if (index <= value) {
				return key;
			} 
		}
		return -1;
	}
	
	public void printValues() {
		System.out.println("Q: " + Q);
		for (int i: uniqVals) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int k: hmap.keySet()) {
			System.out.println(k + ": " + hmap.get(k));
		}
	}

	public void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String in = br.readLine().trim();
			Q = Integer.parseInt(in);
			int n = Integer.parseInt(br.readLine().trim());
			uniqVals = new int[n];
			int index = 0;
			while (n > 0) {
				String[] vcPair = br.readLine().split(" ");
				int key = Integer.parseInt(vcPair[0].trim());
				int value = Integer.parseInt(vcPair[1].trim());
				N += value;
				hmap.put(key, value);
				uniqVals[index] = key;
				++index;
				--n;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
