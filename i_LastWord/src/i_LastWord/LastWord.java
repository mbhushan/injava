package i_LastWord;

public class LastWord {

	public static int lengthOfLastWord(final String a) {
		StringBuffer sb = new StringBuffer();
		if (null == a || a.length() == 0) {
			return 0;
		}
		String s = a.trim();
		int n = s.length();
		for (int i=n-1; i>=0; i--) {
			if (Character.isLetterOrDigit(s.charAt(i))) {
				sb.append(s.charAt(i));
			} else {
				break;
			}
		}
		System.out.println("last word: " + sb.toString());
		
		return sb.length();
	}
	
	public static void main(String [] args) {
		String [] S = {
				"Hello World",
				"Hello",
				"Wordl   "
		};
		
		for (int i=0; i<S.length; i++) {
			int n = lengthOfLastWord(S[i]);
			System.out.println("length of last word: " + n);
		}
	}
}
