package i_Palindrome;

public class Palindrome {
	public static int isPalindrome(String a) {
		if (null == a || a.length() <= 1) {
			return 1;
		}
		int start = 0;
		int end = a.length()-1;
		while (start < end) {
			if(!Character.isLetterOrDigit(a.charAt(start))){
				++start;
                continue;
            }
			if(!Character.isLetterOrDigit(a.charAt(end))){
				--end;
                continue;
            }
			if (Character.toLowerCase(a.charAt(start)) != Character.toLowerCase(a.charAt(end))) {
				System.out.println("start: " + a.charAt(start));
				System.out.println("end: " + a.charAt(end));
				return 0;
			}
			++start;
			--end;
		}
		
		return 1;
	}
	
	public static void main(String [] args) {
		String [] S = {"A man, a plan, a canal: Panama", 
				"race a car",
				"aabaa"
		};
		for (int i=0; i<S.length; i++) {
			System.out.println("String: " + S[i]);
			System.out.println("Is Palindrome: " + isPalindrome(S[i]));
		}
		
	}
}
