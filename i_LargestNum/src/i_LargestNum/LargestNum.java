package i_LargestNum;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LargestNum {
	
	private static String [] data;
	
	public static String largestNumber(final List<Integer> a) {
		int n = a.size();
		data = new String[n];
		// data = (String []) a.toArray();
		for (int i=0; i<n; i++) {
			data[i] = String.valueOf(a.get(i));
		}
		
		quickSort(0, n-1);
		showData();
		StringBuffer sb = new StringBuffer();
		int j=n-1;
		while ((j>0) && (data[j].equals("0"))) {
			--j;
		}
		for (int i=j; i>=0; i--) {
			sb.append(data[i]);
		}
		String result = sb.toString();
		if (result.equals("")) {
			result = "0";
		}
		System.out.println("result: " + result);
		return null;
	}
	
	public static void main (String [] args) {
	    //String	 [] A = {"3", "30", "34","5", "9"};
	    String	 [] A = {"12345678","123456"};
	    
		ArrayList<Integer> X = new ArrayList<Integer>();
		
		for (int index = 0; index < A.length; index++) {
			X.add(Integer.valueOf(A[index]));
		 }
		largestNumber(X);
	}
	
	private static void showData() {
		if (null == data) {
			return;
		}

		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
	
	private static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot-1);
			quickSort(pivot+1, right);
		}
	}
	
	private static int partition(int left, int right) {
		String key = data[right];
		int i = left - 1;
		
		for (int j=left; j<right; j++ ) {
			if (checkGreaterThan(key, data[j])) {
				i = i + 1;
				String temp = data[i];
				data[i] = data[j];
				data[j] = temp;
			}
		}
		String temp = data[i+1];
		data[i+1] = data[right];
		data[right] = temp;
		
		return i+1;
	}
	
	private static boolean checkGreaterThan(String a, String b) {
		if (Long.parseLong(a+b) >= Long.parseLong(b+a)) {
			return true;
		}
		return false;
	}

}
