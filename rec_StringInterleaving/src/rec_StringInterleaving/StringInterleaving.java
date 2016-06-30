package rec_StringInterleaving;

import java.util.Arrays;

/*
Print all interleavings of given two strings
Given two strings str1 and str2, write a function that prints all interleavings of the given two strings. 
You may assume that all characters in both strings are different
Example:
Input: str1 = "AB",  str2 = "CD"
Output:
    ABCD
    ACBD
    ACDB
    CABD
    CADB
    CDAB
Input: str1 = "AB",  str2 = "C"
Output:
    ABC
    ACB
    CAB
An interleaved string of given two strings preserves the order of characters in individual strings. 
For example, in all the interleavings of above first example, ‘A’ comes before ‘B’ and ‘C’ comes before ‘D’.
*/
public class StringInterleaving {
	
	public static void main(String[] args) {
		StringInterleaving si = new StringInterleaving();
		
		String X = "AB";
		String Y = "CD";
		String Z = "C";

		System.out.println("interleaving of " + X + " and " + Y);
		si.interleaving(X.toCharArray(), Y.toCharArray());
		
		System.out.println("interleaving of " + Y + " and " + Z);
		si.interleaving(X.toCharArray(), Z.toCharArray());
	}
	
	public void interleaving(char [] A, char [] B) {
		
		int size = A.length + B.length;
		char [] data = new char[size];
		interleaving(A, B, 0, 0, data, 0);
	}
	
	private void interleaving(char [] A, char [] B, int i, int j, char [] data, int index) {
		if (index == data.length) {
			System.out.println(Arrays.toString(data));
		}
		
		if (i < A.length) {
			data[index] = A[i];
			interleaving(A, B, i+1, j, data, index+1);
		}
		
		if (j < B.length) {
			data[index] = B[j];
			interleaving(A, B, i, j+1, data, index+1);
		}
	}
	
	
}
