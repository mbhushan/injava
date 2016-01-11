package i_ThreeSumClosest;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumClosest {
	
	public static int threeSumClosest(ArrayList<Integer>a, int b) {
		int min = Integer.MAX_VALUE;
		int result = 0;
	 
		Collections.sort(a);
		int n = a.size();
	 
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				int sum = a.get(i).intValue() + a.get(j).intValue() + a.get(k).intValue();
				int diff = Math.abs(sum - b);
	 
				if(diff == 0) return sum;
	 
				if (diff < min) {
					min = diff;
					result = sum;
				}
				if (sum <= b) {
					j++;
				} else {
					k--;
				}
			}
		}
	 
		return result;
	}

	public static int threeSumClosest1(ArrayList<Integer> a, int b) {
		Collections.sort(a);
		int len = a.size();
		int fa = 0, fb = 0, fc = 0;
		int xa = 0, xb = 0, xc = 0;
		int j = 0, k = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < len - 2; i++) {
			xa = a.get(i).intValue();
			j = i + 1;
			k = len - 1;
			while (j < k) {
				xb = a.get(j);
				xc = a.get(k);
//				if ((xa + xb + xc) == b) {
//					fa = xa;
//					fb = xb;
//					fc = xc;
//					//found min difference, returning 
//					return 0;
//					
//				} else 
					if (Math.abs(xa + xb + xc) < b) {
					++j;
				} else {
					--k;
				}
				if (Math.abs(xa + xb + xc) < min) {
					fa = xa;
					fb = xb;
					fc = xc;
					min = Math.abs(xa + xb + xc);
				}
			}
		}
		System.out.println("f_abc:" + fa + " " + fb + " " + fc);
		System.out.println("min: " + min);
		return min;
	}
	
	
	
	public static void main(String[] args) {
		//int [] A = {-1, 2, 1, -4};
		int [] A = {-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3};
		ArrayList<Integer> X = new ArrayList<Integer>();
		
		for (int i=0; i<A.length; i++) {
			X.add(A[i]);
		}
		int b = -1;
		System.out.println("three sum: " + threeSumClosest(X, b));
	}
	
	
}