package u_T9Dictionary;

import java.util.ArrayList;

/*
  Implement T9 dictionary. how T9 works is : let say if I press 223 it should give all the possible valid 
  words in suggestion Eg bad,cad,aad etc. give data-structure to store valid words etc.
 */
public class T9Dictionary {

	private char [][] mapping = {
			{},
			{},
			{'a','b','c'},
			{'d', 'e', 'f'},
			{'g', 'h', 'i'},
			{'j', 'k', 'l'},
			{'m', 'n', 'o'},
			{'p', 'q', 'r', 's'},
			{'t', 'u', 'v'},
			{'w', 'x', 'y', 'z'}
	};
	
	public ArrayList<String> getWords(int [] number) {
		ArrayList<String> result = new ArrayList<String>();
		char  [] output = new char[number.length];
		getWordsUtil(number, 0, output, result);
		return result;
	}
	
	private void getWordsUtil(int [] number, int digit, char [] output, ArrayList<String> result) {
		if (digit == number.length) {
			result.add(new String(output));
			return;
		}
		
		for (int i=0; i<mapping[number[digit]].length; i++) {
			char ch = mapping[number[digit]][i];
			output[digit] = ch;
			getWordsUtil(number, digit+1, output, result);
			if (number[digit] == 0 || number[digit] == 1) {
				return;
			}
		}
		
		return;
	}
	
	public static void main(String [] args) {
		int [] number = {2,3,4};
		T9Dictionary T9 = new T9Dictionary();
		ArrayList<String> result = T9.getWords(number);
		for (String st: result) {
			System.out.println(st);
		}
	}
	
}
