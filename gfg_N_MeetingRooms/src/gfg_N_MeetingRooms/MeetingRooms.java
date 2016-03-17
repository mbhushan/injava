package gfg_N_MeetingRooms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 There is one meeting room in Software Company XSoft. There are n meetings in the form of (S [ i ], F [ i ]) 
 where S [ i ] is start time of meeting i and F [ i ] is finish time of meeting i, What is the maximum number 
 of meetings that can be accommodated in the meeting room ?

Input:

The first line of input consists number of the test cases. The description of T test cases is as follows:
The first line consists of the size of the array, second line has the array containing the starting time 
of all the meetings each separated by a space, i.e., S [ i ]. 
And the third line has the array containing the finishing time of all the meetings each separated by a space, i.e., F [ i ].

Output:

In each separate line print the order in which the meetings take place separated by a space.

Constraints:

1 ≤ T ≤ 70
1 ≤ N ≤ 100
1 ≤ S[ i ], F[ i ] ≤ 100000

Example:

Input:

1
6
1 3 0 5 8 5
2 4 6 7 9 9 

Output:

1 2 4 5
*/


class Meet {
	int start;
	int finish;
	
	public Meet(int s, int f) {
		start = s;
		finish = f;
	}
}

public class MeetingRooms {

	public static void main(String[] args) {
		 //int [] S =  {1, 3, 0, 5, 8, 5};
		 int [] S =  {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924  };
		 //int [] F =  {2, 4, 6, 7, 9, 9};
		 int [] F =  {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 };
		 
		 
		 meetingRooms(S, F);
		 //readInput();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		try {
			tc = Integer.parseInt(br.readLine().trim());
			while (tc > 0) {
				int n = Integer.parseInt(br.readLine().trim());
				String [] start = br.readLine().split(" ");
				String [] finish = br.readLine().split(" ");
				int [] S = new int[n];
				int [] F = new int[n];
				for (int i=0; i<n; i++) {
					S[i] = Integer.parseInt(start[i]);
					F[i] = Integer.parseInt(finish[i]);
				}
				meetingRooms(S, F);
				--tc;
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public static void meetingRooms(int []S, int []F) {
		int n = S.length;
		Meet [] meets = new Meet[n];
		for (int i=0; i<n; i++) {
			meets[i] = new Meet(S[i], F[i]);
		}
		
		Arrays.sort(meets,new Comparator<Meet>() {

			public int compare(Meet o1, Meet o2) {
			    return Integer.compare(o1.finish, o2.finish);
			    //return Integer.compare(o1.start, o2.start);
			}
			});
		
		for (int i=0; i<n; i++) {
			System.out.println(meets[i].start + ": " + meets[i].finish);
		}
		
		ArrayList<Integer> ilist = new ArrayList<Integer>();
		int i = 0;
		ilist.add(i+1);
		
		for (int j=1; j<n; j++) {
			if (meets[j].start >= meets[i].finish) {
				i = j;
				ilist.add(i+1);
			}
		}
		for (Integer x: ilist) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	
}
