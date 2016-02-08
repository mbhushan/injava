package i_SeatHops;

import java.util.ArrayDeque;
import java.util.Deque;

class Node {
	int low;
	int high;
	
	Node (int l, int h) {
		low = l;
		high = h;
	}
}

public class SeatHops {
	
	public static void main(String[] args) {
		String a = "....X..XX...X..";
		a = "xxx.";
		char [] ch = a.toCharArray();
		for (char c : ch) {
			System.out.print(c + " ");
		}
		System.out.println();
		//System.out.println("seats hops: " + seats(a));
		System.out.println("seats hops: " + seats1(a));
		
	}
	
	public static int seats1(String a) {
		
		char [] seats = a.toCharArray();
		int n = seats.length;

		  // step 1. count people
		  int k = 0;
		  for (int i = 0; i < n; i++) {
		    if (seats[i] == 'X' || seats[i] == 'x') {
		      k++;
		    }
		  }

		  // step 2. move the window of size k and count the hops
		  int min = Integer.MAX_VALUE;

		  for (int j = 0; j <= n - k; j++) {
		    int hops = 0, p = j;

		    for (int i = 0; i < n; i++) {
		      if (seats[i] == 'X' || seats[i] == 'x') {
		        hops += Math.abs(i - p);
		        p += 1;
		        System.out.println("hops: " + hops);
		      }
		    }

		    min = Math.min(min, hops);
		  }
		  
		System.out.println("min: " + min); 
		if (min == Integer.MAX_VALUE) {
			return 0;
		}

		  return min % 10000003;
	}
	
public static int seats(String a) {
		char [] seats = a.toCharArray();
		
		// step 1. add all groups to deque
		  Deque<Node> dq = new ArrayDeque<Node>();

		  int i = 0, j = 0, n = seats.length;

		  while (j < n) {
		    // skip '.'
		    while (j < n && seats[j] == '.') j++;
		    if (j == n) break;
		    // go through 'X'
		    for (i = j; j < n && seats[j] == 'X'; j++) {}
		    // add group to deque
		    //Node node = new Node(i, j-1);
		    dq.addLast(new Node(i, j-1));
		  }

		  // step 2. merge groups from both ends
		  int count = 0;

		  while (dq.size() > 1) {
		    Node left = dq.peekFirst();
		    Node right = dq.peekLast();

		    int lenLeft = left.high - left.low + 1;
		    int lenRight = right.high - right.low + 1;

		    if (lenLeft <= lenRight) {
		      // merge left two groups
		      left = dq.pollFirst();
		      count += lenLeft * (dq.peekFirst().low - left.high - 1);
		      dq.peekFirst().low -= lenLeft;
		    } else {
		      // merge right two groups
		      right = dq.pollLast();
		      count += lenRight * (right.low - dq.peekLast().high - 1);
		      dq.peekLast().high += lenRight;
		    }
		  }

		  return count % 10000003;
	}
}
