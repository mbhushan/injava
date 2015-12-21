package i_BitFlip;

import java.util.ArrayList;

public class Solution {
	
	public static ArrayList<Integer> flip(String A) {
		int n = A.length();
		int [] bits = new int[n+1];
		int maxbits = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i=1; i<=n ;i++) {
			bits[i] = Integer.valueOf("" + A.charAt(i-1));
			System.out.print(bits[i] + " ");
			if (bits[i] == 1) {
				++maxbits;
			}
		}
		System.out.println();
		
		int setbits = 0;
		int L = 0;
		int R = 0;
		int i=0, j=0;
		for ( i=1; i<=n; i++) {
			for (int m=1; m<i; m++) {
				if (bits[m] == 1) {
					++setbits;
				}
			}
			for ( j=i; j<=n; j++) {
				//System.out.println("bits_j: " + bits[j]);
				if (bits[j] == 0) {
					++setbits;
				}
			}
			for (int k=i+1; k<=n; k++) {
				if (bits[k] == 1) {
					++setbits;
				}
			}
			if (setbits > maxbits) {
				R = j-1; L = i;
				maxbits = setbits;
			}
			setbits = 0;
		System.out.println(L + ":" + R);
		System.out.println("maxbits: " + maxbits);
 		}
		System.out.println(L + ":" + R);
		System.out.println("maxbits: " + maxbits);
		if (L != 0) {
			result.add(L);
			result.add(R);
		}
		return result;
    }
	
	public static void main(String [] args) {
		String A = "010";
		//String A = "111";
		//String A = "1101";
		flip(A);
	}

}
