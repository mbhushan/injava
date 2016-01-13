package i_RevWords;

public class RevWords {

	public static String reverseWords(String a) {
		if (null == a) {
			return a;
		}
		a = a.trim();
		
		int n = a.length();
		StringBuffer sb = new StringBuffer();
		StringBuffer result = new StringBuffer();
		
		for (int i=n-1; i>=0; i--) {
			char ch = a.charAt(i);
			
			if (Character.isLetterOrDigit(ch)) {
				sb.append(ch);
			} 
			if (Character.isWhitespace(ch)) {
				if (sb.length() > 0) {
					String word = sb.reverse().toString();
					result.append(word);
					result.append(ch);
					
					sb.setLength(0);
				}
			}
		}
		if (sb.length() > 0) {
			result.append(sb.reverse().toString());
		}
		a = result.toString().trim();
		System.out.println("rev: " + a);
		return a;
	}
	
	public static void main(String[] args) {
		String a = "the sky is blue";
		reverseWords(a);
	}
}
