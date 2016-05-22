package math_IsPalindrome;

public class IsPalindrome {

	public static void main(String[] args) {
		IsPalindrome IP = new IsPalindrome();
		
		int [] A = {121, 1331, 1341, 15551};
		
		for (int i=0; i<A.length; i++) {
			System.out.println("is palindrome: " + IP.isPalindrome(A[i]));
		}
	}
	
	public boolean isPalindrome(int x) {
        //negative numbers are not palindrome
		if (x < 0)
			return false;
 
		// initialize how many zeros
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}
 
		while (x != 0) {
			int left = x / div;
			int right = x % 10;
 
			if (left != right)
				return false;
 
			x = (x % div) / 10;
			div /= 100;
		}
 
		return true;
    }
}
