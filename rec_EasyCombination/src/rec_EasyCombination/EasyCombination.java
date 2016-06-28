package rec_EasyCombination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EasyCombination {

	 public void combinationEasy(char[] input) {
	        List<Character> r = new ArrayList<>();
	        Arrays.sort(input);
	        combinationEasy(input, 0, r);
	    }

	    private void combinationEasy(char[] input, int pos, List<Character> r) {

	    	System.out.println(r.toString());
	        System.out.println();
	        for (int i = pos; i < input.length; i++) {
	            if (i != pos && input[i] == input[i-1]) {
	                continue;
	            }
	            r.add(input[i]);
	            combinationEasy(input, i + 1, r);
	            r.remove(r.size() - 1);
	        }
	    }

	    public static void main(String args[]){
	    	EasyCombination c = new EasyCombination();
	        c.combinationEasy("aabbc".toCharArray());

	    }
}
