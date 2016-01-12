package i_IsNumber;

public class IsNumber {

	public static int isNumber1(final String s) {
		int len = s.length();
        int i = 0, e = len - 1;
        while (i <= e && Character.isWhitespace(s.charAt(i))) i++;
        if (i > len - 1) return 0;
        while (e >= i && Character.isWhitespace(s.charAt(e))) e--;
        // skip leading +/-
        if (s.charAt(i) == '+' || s.charAt(i) == '-') i++;
        boolean num = false; // is a digit
        boolean dot = false; // is a '.'
        boolean exp = false; // is a 'e'
        while (i <= e) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = true;
            }
            else if (c == '.') {
                if(exp || dot) return 0;
                dot = true;
            }
            else if (c == 'e') {
                if(exp || num == false) return 0;
                exp = true;
                num = false;
            }
            else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e') return 0;
            }
            else {
                return 0;
            }
            i++;
        }
        if (num) return 1;
        return 0;
	}
	
	public static int isNumber(final String a) {
	    if (a == null) return 0;
         
        // remove white spaces
        String sCut = a.trim();
         
        int len = sCut.length();
         
        boolean num = false; // is it numeric up to this point?
        boolean exp = false; // is there any 'e' before?
        boolean dot = false; // is there any '.' before?
        boolean nextdot = false;
         
        for (int i = 0; i < len; i ++){
            char c = sCut.charAt(i);
            
            if (dot && nextdot) {
            	nextdot = false;
            	if (!Character.isDigit(c)) return 0;
            }
             
            if (c == 'e'){
                // no e before, there should be digit before, and also there should be digit after it.
                if (exp || !num) return 0;
                num = false;
                exp = true;
            }else if ( Character.isDigit(c)){
                num = true;
            }else if (c == '.'){
            	if (i == len-1) return 0;
                // there should be no '.' before. there should be no e before. 
                if ( dot || exp) return 0;
                dot = true;
                nextdot = true;
            }else if (c == '+' || c == '-') {
                if ( i == 0 || sCut.charAt(i-1) == 'e') continue;
                else return 0;
            }else{
                return 0;
            }
        }
        if (num) {
            return 1;
        }
         
        return 0;
	}
	
	public static void main(String [] args) {
		String a = "-01.1e-10";
		System.out.println("ans: " + isNumber(a));
		System.out.println("ans1: " + isNumber1(a));
	}
}
