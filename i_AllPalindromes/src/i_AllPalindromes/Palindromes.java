package i_AllPalindromes;

import java.util.ArrayList;

public class Palindromes {
	
	public static void main(String[] args) {
		String s = "aab";
		partition(s);
	}

	public static ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> tmp = new ArrayList<String>();
		find(s, 0, tmp, result);
		
//		System.out.println("result size: " + result.size());
//		for (ArrayList<String> r: result) {
//			System.out.println(r);
		//}
		return result;
		
	}
	
	private static void find(String s, int st, ArrayList<String> tmp, ArrayList<ArrayList<String>> result) {
		if (st >= s.length()) {
			result.add(new ArrayList<String>(tmp));
			//System.out.println("tmp: " + tmp);
		} else {
			for (int i=st;i<s.length();i++){      
				if (valid(s,st,i)){
					//if ((i-st+1) >= 0 && (i-st+1) <= s.length()) {
	                tmp.add(s.substring(st, i+1));
					//}
	                find(s,i+1,tmp,result);        
	                tmp.remove(tmp.size()-1);
	            }
			}
		}
	}
	
	private static boolean valid(String str, int st, int ed){
        while (st<=ed){
            if (str.charAt(ed) != str.charAt(st)){
                return false;
            }else{
                st++;
                ed--;
            }
        }
        return true;
    }
}
