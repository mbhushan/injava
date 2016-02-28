package i_LongestPalindrome;


public class LongestPalindrome {

	// private static ArrayList<String> palindromeList = new
	// ArrayList<String>();
	// private static String longestPalindrome = "";

	public static void main(String[] args) {
		String str = "aaaabaaa";
		str = "av";
		System.out.println("longest palindrome: " + longestPalindrome(str));
	}

	public static String longestPalindrome(String str) {
		int len = str.length();
		String longestPalindrome = "";
		String evenPalin = "";
		String oddPalin = "";
		if (len < 2) {
			return str;
		}
		if ((len == 2) && (str.charAt(0) != str.charAt(1))) {
			return String.valueOf(str.charAt(0));
		}
		for (int i = 0; i < len - 1; i++) {
			oddPalin = oddLengthPalindrome(str, i);

			if (str.charAt(i) == str.charAt(i + 1)) {
				evenPalin = evenLengthPalindrome(str, i, i + 1);
			}
			if (evenPalin.length() > longestPalindrome.length()) {
				longestPalindrome = evenPalin;
			}
			if (oddPalin.length() > longestPalindrome.length()) {
				longestPalindrome = oddPalin;
			}
		}

		return longestPalindrome;
	}

	public static String evenLengthPalindrome(String str, int firstCenter,
			int secondCenter) {
		if (str == null) {
			return str;
		}
		int evenCount = 0;
		int len = str.length();
		int i = firstCenter, j = secondCenter;
		String longestPalindrome = "";

		while (i >= 0 && j < len) {
			if (str.charAt(i) == str.charAt(j)) {
				String palindrome = str.substring(i, j + 1);
				if (palindrome.length() > 1) {
					// System.out.println(palindrome);
					// palindromeList.add(palindrome);
					++evenCount;
					if (palindrome.length() > longestPalindrome.length()) {
						longestPalindrome = palindrome;
					}
				}
				--i;
				++j;
			} else {
				break;
			}
		}

		return longestPalindrome;
	}

	public static String oddLengthPalindrome(String str, int center) {
		int i = center, j = center;
		int len = str.length();
		int oddCount = 0;
		String longestPalindrome = "";

		while (i >= 0 && j < len) {
			if (str.charAt(i) == str.charAt(j)) {
				String palindrome = str.substring(i, j + 1);
				if (palindrome.length() > 1) {
					// System.out.println(palindrome);
					// palindromeList.add(palindrome);
					++oddCount;
					if (palindrome.length() > longestPalindrome.length()) {
						longestPalindrome = palindrome;
					}
				}
				--i;
				++j;
			} else {
				break;
			}
		}
		return longestPalindrome;
	}
}
