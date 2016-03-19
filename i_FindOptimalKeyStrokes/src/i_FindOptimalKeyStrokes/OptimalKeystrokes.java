/**
Imagine you have a special keyboard with the following keys: 
Key 1:  Prints 'A' on screen
Key 2: (Ctrl-A): Select screen
Key 3: (Ctrl-C): Copy selection to buffer
Key 4: (Ctrl-V): Print buffer on screen appending it
                 after what has already been printed. 

If you can only press the keyboard for N times (with the above four keys), write a program to produce maximum numbers of A's. That is to say, the input parameter is N (No. of keys that you can press), the output is M (No. of As that you can produce).

Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the number of key.

Output:

Print maximum number of A's.
Constraints:

1 ≤ T ≤ 50
1 ≤ N ≤ 75

Example:
Input:
2
3
7

Output:
3
9

Explanation:

Input:  N = 3
Output: 3
We can at most get 3 A's on screen by pressing 
following key sequence.
A, A, A

Input:  N = 7
Output: 9
We can at most get 9 A's on screen by pressing 
following key sequence.
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V
 */
package i_FindOptimalKeyStrokes;

public class OptimalKeystrokes {

	public static void main(String[] args) {
		int n = 20;

		findoptimalDP(8);
		for (int i = 1; i <= n; i++) {
			//System.out.println("Max A's with " + i + " keystrokes: "
			//		+ findoptimal(i));
			System.out.println("DP Max A's with " + i + " keystrokes: "
					+ findoptimalDP(i));
		}
		
	}

	public static int findoptimal(int N) {
		// The optimal string length is N when N is smaller than 7
		if (N <= 6)
			return N;

		// Initialize result
		int max = 0;

		// TRY ALL POSSIBLE BREAK-POINTS
		// For any keystroke N, we need to loop from N-3 keystrokes
		// back to 1 keystroke to find a breakpoint 'b' after which we
		// will have Ctrl-A, Ctrl-C and then only Ctrl-V all the way.
		for (int b = N - 3; b >= 1; b--) {
			int curr = (N - b - 1) * findoptimal(b);
			if (curr > max)
				max = curr;
		}
		return max;
	}

	public static int findoptimalDP(int N) {
		// The optimal string length is N when N is smaller than 7
		if (N <= 6)
			return N;

		// An array to store result of subproblems
		int[] screen = new int[N];

		// Initializing the optimal lengths array for uptil 6 input
		// strokes.
		for (int n = 1; n <= 6; n++)
			screen[n - 1] = n;

		// Solve all subproblems in bottom manner
		for (int n = 7; n <= N; n++) {
			// Initialize length of optimal string for n keystrokes
			screen[n - 1] = 0;

			// For any keystroke n, we need to loop from n-3 keystrokes
			// back to 1 keystroke to find a breakpoint 'b' after which we
			// will have ctrl-a, ctrl-c and then only ctrl-v all the way.
			for (int b = n - 3; b >= 1; b--) {
				// if the breakpoint is at b'th keystroke then
				// the optimal string would have length
				// (n-b-1)*screen[b-1];
				int curr = (n - b - 1) * screen[b - 1];
				if (curr > screen[n - 1])
					screen[n - 1] = curr;
			}
		}

		return screen[N - 1];
	}
}
