package i_JumpingNumbers;

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
