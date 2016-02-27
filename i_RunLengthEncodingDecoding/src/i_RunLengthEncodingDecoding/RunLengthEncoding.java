package i_RunLengthEncodingDecoding;

import java.util.HashMap;


public class RunLengthEncoding {

	private static HashMap<Character, Character> hmap = new HashMap<Character, Character>();
	private static HashMap<Character, Character> hmapRev = new HashMap<Character, Character>();
	
	public static void main(String[] args) {
		char [] chArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
		char [] nArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}; 
				
		for (int i=0; i<=9; i++) {
			hmap.put(nArr[i], chArr[i]);
			hmapRev.put(chArr[i], nArr[i]);
		}
		String str ="aaabbcccddef111223334456";
		System.out.println("original string: " + str);
		System.out.println("length of str: " + str.length());
		String encode = encode(str);
		System.out.println("encoded string: " + encode);
		System.out.println("length of encoded string: " + encode.length());
		String decode = decode(encode);
		System.out.println("decoded string: " + decode);
		System.out.println("decoded string lenght: " + decode.length());
	}
	
	public static String encode(String str) {
		int len = str.length();
		
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<len; i++) {
			int count = 1;
			char ch = str.charAt(i);
			while ((i+1 < len) && (str.charAt(i) == str.charAt(i+1))) {
				++count;
				++i;
			}
			if (hmap.containsKey(ch)) {
				ch = hmap.get(ch);
			}
			
			sb.append(ch);
			if (count > 1) {
				sb.append(count);
			}
		}
		return sb.toString();
	}
	
	public static String decode(String str) {
		int len  = str.length();
		
		StringBuffer sb = new StringBuffer();
		
		for (int i=0; i<len; i++) {
			char ch = str.charAt(i);
			StringBuffer freq = new StringBuffer();
			while ((i+1 < len) && Character.isDigit(str.charAt(i+1))) {
				freq.append(str.charAt(i+1));
				++i;
			}
			int num = 1;
			if (freq.length() > 0) {
				String st = freq.toString();
				num = Integer.valueOf(st);
			}
			if (hmapRev.containsKey(ch)) {
				ch = hmapRev.get(ch);
			}
			for (int j=1; j<= num; j++) {
                sb.append(ch);
			}
		}
		return sb.toString();
	}
}
