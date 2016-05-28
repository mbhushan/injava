package fx_PrintNonComments;

/*
 Implement a method called printNonComments() which prints out a extract of text with comments removed.
For example, the input:
hello /* this is a
multi line comment */ /*all
Should produce:
hello
all
 */
public class CommentRemoval {

	public static void main(String[] args) {
		
		CommentRemoval CR = new CommentRemoval();
		
		String str = "hello /* this is a\nmultiline commnet */ all";
		System.out.println(str);
		
		System.out.println("after removing comments: ");
		String result = CR.removeComments(str); 
		System.out.println(result);
	}
	
	public String removeComments(String str) {
		if (str == null || str.length() <= 1) {
			return str;
		}
		
		char [] chArr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		int len = str.length();
		boolean commentStart = false;
		boolean commentEnd = false;
		for (int i=0; i<len; i++) {
			if (chArr[i] == '/' && (i+1 < len && chArr[i+1] == '*')) {
				commentStart = true;
			}
			if (chArr[i] == '*' && (i+1 < len && chArr[i+1] == '/' && commentStart)) {
				commentEnd = true;
				++i;
				continue;
			}
			if (chArr[i] == '\n') {
				sb.append(chArr[i]);
			}
			if (!commentStart || commentEnd) {
				sb.append(chArr[i]);
			}
		}
		
		return sb.toString();
	}
}
