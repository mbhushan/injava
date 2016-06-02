package arr_LeadersInArray;

import java.util.ArrayList;

/*
Leaders in an array
Write a program to print all the LEADERS in the array. 
An element is leader if it is greater than all the elements to its right side. 
And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.

Let the input array be arr[] and size of the array be size.
*/
public class ArrayLeaders {

	public static void main(String[] args) {
		ArrayLeaders AL = new ArrayLeaders();
		int [] A = {16, 17, 4, 3, 5, 2};
		ArrayList<Integer> result = AL.printLeaders(A);
		
		System.out.println("leaders in array are: ");
		for (Integer i: result) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public ArrayList<Integer> printLeaders(int [] A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		if (A == null || A.length < 1) {
			return result;
		}
		
		int len = A.length;
		
		int max = A[len-1];
		result.add(max);
		
		if (len == 1) {
			return result;
		}
		
		for (int i=len-2; i>=0 ;i--) {
			if (A[i] > max) {
				result.add(A[i]);
				max = A[i];
			}
		}
		return result;
	}
}
