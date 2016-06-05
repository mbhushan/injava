package arr_NextGreaterElement;

import java.util.Stack;

/*
Next Greater Element
Given an array, print the Next Greater Element (NGE) for every element. 
The Next greater Element for an element x is the first greater element on the right side of x in array. 
Elements for which no greater element exist, consider next greater element as -1.

Examples:
a) For any array, rightmost element always has next greater element as -1.
b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.

Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
   
d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.
  Element        NGE
   13      -->    -1
   7       -->     12
   6       -->     12
   12     -->     -1
*/
public class NextGreaterElement {

	public static void main(String[] args) {
		NextGreaterElement nge = new NextGreaterElement();
		System.out.println("A array NGE: ");
		int [] A = {4, 5, 2, 25};
		nge.nextGreaterElement(A);
		System.out.println();
		System.out.println("B array NGE:");
		int [] B = {13, 7, 6, 12};
		nge.nextGreaterElement(B);
	}
	
	private void nextGreaterElement(int [] A) {
		if (A == null || A.length < 1) {
			return ;
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(A[0]);
		for (int i=1; i<A.length; i++) {
			while (!stack.isEmpty() && A[i] > stack.peek()) {
				int nge = stack.pop();
				System.out.println(nge + " -> " + A[i]);
			}
			stack.push(A[i]);
		}
		int none = -1;
		while (!stack.isEmpty()) {
			int nge = stack.pop();
			System.out.println(nge + " -> " + none);
		}
	}
}
