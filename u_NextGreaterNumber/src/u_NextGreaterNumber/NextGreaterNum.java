package u_NextGreaterNumber;
/*
 Given a number n, find the smallest number that has same set of digits as n and is greater than n. If x is the greatest possible number with its set of digits, then print “not possible”.

Examples:
For simplicity of implementation, we have considered input number as a string.

Input:  n = "218765"
Output: "251678"

Input:  n = "1234"
Output: "1243"

Input: n = "4321"
Output: "Not Possible"

Input: n = "534976"
Output: "536479"
 */
public class NextGreaterNum {
	
	public static void main(String [] args) {
		int [] A = {
				218765, 1234, 4321, 534976
		};
		
		for (int i=0; i<A.length; i++) {
			System.out.println("next int: " + nextInt(A[i]));
		}
	}
	
	public static int nextInt(int num) {
		String str = String.valueOf(num);
		char [] A = str.toCharArray();
		int len = str.length();
		int index = -1;
		for (int i=len-1; i>0; i--) {
			if (A[i-1] < A[i]) {
				index = i-1;
				break;
			}
		}
		if (index == -1 || index == 0) {
			return -1;
		}
		int smallest = index+1;
		int x = A[index];
		for (int i=index+1; i<len; i++) {
			if (A[i] > x && A[i] < A[smallest]) {
				smallest = i;
			}
		}
		char tmp = A[index];
		A[index] = A[smallest];
		A[smallest] = tmp;
		int i = index+1;
		int j = len-1;
		while (i < j) {
			tmp = A[i];
			A[i] = A[j];
			A[j] = tmp;
			++i;
			--j;
		}
		str = new String(A);
		
		return Integer.valueOf(str);
	}

}
