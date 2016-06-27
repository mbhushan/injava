package rec_KeypadStringGeneration;

import java.lang.reflect.Array;
import java.util.Arrays;


/*
Generate all possible string combinations of a given phone number.
*/

public class KeypadStrings {
	
	public static void main(String[] args) {
		KeypadStrings ks = new KeypadStrings();
		
		int [] digits = {6, 2, 3};
		System.out.println("total strings: " + ks.stringGen(digits));
		
	}
	
	public  int stringGen(int [] digits) {
		if (digits == null || digits.length < 1) {
			return 0;
		}
		
		//return stringGen(digits, 0, new StringBuffer());
		char [] data = new char[digits.length];
		return StringGeneration(digits, 0, data);
	}
	
	private int StringGeneration(int [] digits, int index, char [] data ) {
		if (index == digits.length) {
			System.out.println(Arrays.toString(data));
			return 1;
		}
		
		int count = 0;
		char [] str = getCharSetForNumber(digits[index]);
		for (char ch: str) {
			data[index] = ch;
			count += StringGeneration(digits, index+1, data);
		}
		
		return count;
	}
	
	private int stringGen(int [] digits, int index, StringBuffer sb) {
		if (index == digits.length) {
			System.out.println(sb.toString());
			return 1;
		}
		
		int count = 0;
		
		for (int i=index; i<digits.length; i++) {
			char [] str = getCharSetForNumber(digits[i]);
			for (char ch: str) {
				sb.append(ch);
				count += stringGen(digits, i+1, sb);
				sb.deleteCharAt(sb.length()-1);
			}
		}
		return count;
	}
	
	 private char[] getCharSetForNumber(int num) {
	        switch(num){
	            case 2 : return "abc".toCharArray();
	            case 3 : return "def".toCharArray();
	            case 4: return "ghi".toCharArray();
	            case 5: return "jkl".toCharArray();
	            case 6: return "mno".toCharArray();
	            case 7: return "pqrs".toCharArray();
	            case 8: return "tuv".toCharArray();
	            case 9: return "wxyz".toCharArray();
	        }
	        throw new IllegalArgumentException();
	    }
}
