package i_RegexMatch1;

public class RegexMatch {

	public static void main(String[] args) {
		System.out.println(isMatch("aa","a"));
		System.out.println(isMatch("aa","aa"));
		System.out.println(isMatch("aaa","aa"));
		System.out.println(isMatch("aa","a*"));
		System.out.println(isMatch("aa",".*"));
		System.out.println(isMatch("abc","a.*c"));
		System.out.println(isMatch("aab","c*a*b"));
	}
	
	public static int isMatch(final String s, final String p) {
		if (isRegexMatch(s, p)) {
			return 1;
		}
		return 0;
	}
	
	public static boolean isRegexMatch(final String s, final String p) {
		if(p.length() == 0)
            return s.length() == 0;
 
        //p's length 1 is special case    
        if(p.length() == 1 || p.charAt(1) != '*'){
            if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
                return false;
            return isRegexMatch(s.substring(1), p.substring(1));    
 
        }else{
            int len = s.length();
 
            int i = -1; 
            while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
                if(isRegexMatch(s.substring(i+1), p.substring(2)))
                    return true;
                i++;
            }
            return false;
        } 
		
	}
}
