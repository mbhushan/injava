package i_Pascal2;

import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> getRow(int a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(1);
		int n = 0;
		for (int i=0; i<a; i++) {
			n = (result.get(i) * (a-i)) / (i+1);
			result.add(n);
		}
		
		for (Integer i: result) {
			System.out.print(i + " ");
		}
		System.out.println();
		return result;
	}
	
	public static void main(String [] args) {
		int n = 5;
		
		for (int i=1; i<=n ;i++) {
			getRow(i);
		}
	}
	
}
