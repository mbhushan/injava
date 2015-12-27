package i_PalindromeInts;

public class Palindrome {
	public static boolean isPalindrome(int a) {
		int n = a;
		int rev = 0;
		 while (n > 0)
		 {
		      int dig = n % 10;
		      rev = rev * 10 + dig;
		      n = n / 10;
		 }
		return rev == a;
	}
	
	public static void main(String [] args) {
		int [] A = {11211, 12121, 123};
		for (int i=0; i<A.length; i++) {
			System.out.println(A[i] + " is palindrome: " + isPalindrome(A[i]));
		}
	}
}
