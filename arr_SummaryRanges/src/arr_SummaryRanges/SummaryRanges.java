package arr_SummaryRanges;

import java.util.ArrayList;

/**
Given a sorted integer array without duplicates, return the summary of its ranges for consecutive numbers.
For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * @author manib
 *
 */
public class SummaryRanges {
	
	public ArrayList<String> summaryRanges(int [] A) {
			ArrayList<String> result = new ArrayList<String>();

			if (A == null || A.length == 0) {
				return result;
			}
			
			if (A.length == 1) {
				result.add(String.valueOf(A[0]));
			}
			
			int pre = A[0];
			int first = A[0];
			
			for (int i=1; i<A.length; i++) {
				if (A[i] == pre+1) {
					pre = A[i];
				} else {
					String buff = first + " -> " + pre;
					result.add(buff);
					first = A[i];
					pre = A[i];
				}
			}
			
			if (first == pre) {
				result.add(String.valueOf(first));
			}
			
			return result;
	}

	public static void main(String[] args) {
		SummaryRanges SR =  new SummaryRanges();
		
		int [] A = {0,1,2,4,5,7};
		ArrayList<String> result = SR.summaryRanges(A);
		for (String st: result) {
			System.out.println(st);
		}
	}
}
