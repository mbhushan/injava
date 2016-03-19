package i_JumpingNumbers;

/**
Print all Jumping Numbers smaller than or equal to a given value
A number is called as a Jumping Number if all adjacent digits in it differ by 1. The difference between ‘9’ and ‘0’ is not considered as 1.
All single digit numbers are considered as Jumping Numbers. For example 7, 8987 and 4343456 are Jumping numbers but 796 and 89098 are not.

Given a positive number x, print all Jumping Numbers smaller than or equal to x. The numbers can be printed in any order.

Example:

Input: x = 20
Output:  0 1 2 3 4 5 6 7 8 9 10 12

Input: x = 105
Output:  0 1 2 3 4 5 6 7 8 9 10 12
         21 23 32 34 43 45 54 56 65
         67 76 78 87 89 98 101

Note: Order of output doesn't matter, 
i,e., numbers can be printed in any order
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class JumpingNumbers {

	public static void main(String[] args) {
		int n = 100;

		ArrayList<Integer> result = jumpingNumbers(n);
		for (int x : result) {
			System.out.print(x + " ");
		}
		System.out.println();
	}

	public static ArrayList<Integer> jumpingNumbers(int target) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		for (int i = 1; i <= 9; i++) {
			result.addAll(bfsNumbers(target, i));
		}
		return result;
	}

	private static ArrayList<Integer> bfsNumbers(int target, int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		ArrayList<Integer> alist = new ArrayList<Integer>();

		queue.add(n);

		while (!queue.isEmpty()) {

			n = queue.remove();

			if (n <= target) {
				alist.add(n);

				int mod = n % 10;
				if (mod == 0) {
					queue.add((n * 10) + (mod + 1));
				} else if (mod == 9) {
					queue.add((n * 10) + (mod - 1));
				} else {
					queue.add((n * 10) + (mod + 1));
					queue.add((n * 10) + (mod - 1));
				}
			}
		}
		return alist;
	}
}
