package arr_LongestCommonPrefix;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String [] words) {
		if (words == null || words.length < 2) {
			return "";
		}
		int minLen = Integer.MAX_VALUE;
		String minStr = "";
		for (String str: words) {
			if (str.length() < minLen) {
				minLen = str.length();
				minStr = str;
			}
		}
		
		if (minLen == 0) { 
			return "";
		}
		
		for (int i=0; i<words.length; i++) {
			String prefix = getPrefix(words[i], minStr);
			if (prefix.length() < minLen) {
				minLen = prefix.length();
				minStr = prefix;
			}
		}
		
		return minStr;
	}
	
	private String getPrefix(String A, String B) {
		int minLen = Math.min(A.length(), B.length());
		for (int i=0; i<minLen; i++) {
			if (A.charAt(i) != B.charAt(i)) {
				return A.substring(0, i);
			}
		}
		return A.substring(0, minLen);
	}
	
	public static void main(String [] args) {
		String [] words = {
				"manib",
				"manning",
				"mantosh",
				//"male",
				//"mapple",
				"mango",
				"mani",
				"manush",
				"manipulate",
				"mania",
				"mantish"
		};
		LongestCommonPrefix LCP = new LongestCommonPrefix();
		
		System.out.println("longest common prefix: " + LCP.longestCommonPrefix(words));
	}
}
