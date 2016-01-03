package i_SingleNumberV2;

import java.util.ArrayList;

public class CntBits {

	 public static int cntBits(ArrayList<Integer> A) {
		 
		 int n = A.size();
		 int [] buff = new int[32];
		 
		 for (int i=0; i<n; i++) {
			 int num = A.get(i);
			 
			 int count = 0;
			 while (num > 0) {
				 int x = num & 1;
				 num = num >> 1;
				 buff[count] = buff[count] + x;
				 ++count;
			 }
		 }
		 
		 //[bit count] * [array size - bit count] * 2
		 int ans = 0;
		 for (int i=0; i<buff.length; i++) {
			 //System.out.print(buff[i] + " ");
			 ans = ans + buff[i] * (n - buff[i]) * 2;
		 }
		 System.out.println("ans: " + ans);
		 return ans;
		 
	 }
	 
	 public static void main(String [] args) {
		 int [] X = {1,3,5};
		 ArrayList<Integer> A = new ArrayList<Integer>();
		 for (int i=0; i<X.length; i++) {
			 A.add(X[i]);
		 }
		 cntBits(A);
	 }
	 

}
