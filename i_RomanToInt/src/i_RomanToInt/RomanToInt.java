package i_RomanToInt;

public class RomanToInt {
	
	public static int romanToInt(String a) {
	    // Start typing your C/C++ solution below
        // DO NOT write int main() function
         
        // 4:IV, 9:IX, 40:XL, 90:XC, 400:CD, 900:CM,
        // 1:I, 10:X, 100:C, 1000:M
        int res=0;
        int n = a.length();
        char pre = ' ';
        for(int i=0;i<n;i++) {
            if (a.charAt(i)=='M' && pre!='C') {res+=1000;}
            if (a.charAt(i)=='C' && pre!='X') {res+=100;}
            if (a.charAt(i)=='X' && pre!='I') {res+=10;}
             
            if (a.charAt(i)=='M' && pre=='C') {res+=800;}
            if (a.charAt(i)=='C' && pre=='X') {res+=80;}
            if (a.charAt(i)=='X' && pre=='I') {res+=8;}
             
            if (a.charAt(i)=='I' ) {res+=1;}
             
            if (a.charAt(i)=='V' && pre!='I'){res+=5;}
            if (a.charAt(i)=='L' && pre!='X'){res+=50;}
            if (a.charAt(i)=='D' && pre!='C'){res+=500;}
             
            if (a.charAt(i)=='V' && pre=='I'){res+=3;}
            if (a.charAt(i)=='L' && pre=='X'){res+=30;}
            if (a.charAt(i)=='D' && pre=='C'){res+=300;}
             
            pre = a.charAt(i);
             
        }
         
        return res;
	}
	
	public static void main(String [] args) {
		String [] S = {"XIV", "XX"};
		for (int i=0; i<S.length; i++) {
			System.out.println("roman to int: " + romanToInt(S[i]));
		}
	}

}
