package i_PreviousSmaller;

import java.util.ArrayList;
import java.util.Stack;

public class PreviousSmaller {

	public static void main(String[] args) {
		// int [] A = {4, 5, 2, 10};
		// int [] A = {3, 2, 1};
		 int [] A = {34, 35, 27, 42, 5, 28, 39, 20, 28};
		//int[] A = { 5, 28, 39, 20, 28 };
		ArrayList<Integer> X = new ArrayList<Integer>();
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
			X.add(A[i]);
		}
		System.out.println();
		X = prevSmaller(X);
		for (int i = 0; i < X.size(); i++) {
			System.out.print(X.get(i) + " ");
		}
		System.out.println();
	}

	public static ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int size = arr.size();
		Stack<Integer> stack = new Stack<Integer>();
		int def = -1;
		for (int i = 0; i < size; i++) {
			int num = arr.get(i).intValue();
			while (!stack.isEmpty() && stack.peek() >= num) {
				stack.pop();
			}
			if (!stack.isEmpty()) {
				result.add(stack.peek());
			} else {
				result.add(def);
			}
			stack.push(num);
		}
		return result;
	}
}
