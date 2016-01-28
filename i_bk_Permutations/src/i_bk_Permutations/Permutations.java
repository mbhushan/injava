package i_bk_Permutations;

import java.util.ArrayList;

public class Permutations {

	
	public static void main(String[] args) {
		int [] X = {1,2,3};
		ArrayList<Integer> num = new ArrayList<Integer>();
		for (int i=0; i<X.length; i++) {
			num.add(X[i]);
		}
		ArrayList<ArrayList<Integer>> result  = permute(num);
		for (int i=0; i<result.size(); i++) {
			System.out.print(result.get(i));
		}
		System.out.println();
	}
	
	//private static ArrayList<ArrayList<Integer>> result;
	public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		int [] num = convertIntegers(a);
		permute(num, 0, result);
		return result;
	}
	
	public static int[] convertIntegers(ArrayList<Integer> integers)
	{
	    int[] ret = new int[integers.size()];
	    for (int i=0; i < ret.length; i++)
	    {
	        ret[i] = integers.get(i).intValue();
	    }
	    return ret;
	}
	
	private static void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
		 
		if (start >= num.length) {
			ArrayList<Integer> item = convertArrayToList(num);
			result.add(item);
		}
	 
		for (int j = start; j <= num.length - 1; j++) {
			swap(num, start, j);
			permute(num, start + 1, result);
			swap(num, start, j);
			
		}
	}
	
	private static ArrayList<Integer> convertArrayToList(int[] num) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}
	 
	
	 
	private static void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
