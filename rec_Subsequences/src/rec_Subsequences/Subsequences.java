package rec_Subsequences;

import java.util.ArrayList;

/*
print all subsequences of an array.
*/

public class Subsequences {

	public static void main(String[] args) {
		
		Subsequences ss = new Subsequences();
		int [] digits = {1,2,3};
			
		ss.subsequences(digits);
	}
	
	public void subsequences(int [] digits) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int index = 0;

		subsequences(digits, index, list);
	}
	
	private void subsequences(int [] digits, int index, ArrayList<Integer> list) {
		//if (index <= digits.length) {
			System.out.println(list.toString());
		//}
		
		for (int i=index; i<digits.length; i++) {
			list.add(digits[i]);
			System.out.println(i + "," + index);
			subsequences(digits, i+1, list);
			list.remove(list.size()-1);
			System.out.println(i + "," + index);
		}
	}
}
