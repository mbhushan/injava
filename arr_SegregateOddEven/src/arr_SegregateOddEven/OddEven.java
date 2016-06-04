package arr_SegregateOddEven;

/*
Segregate Even and Odd numbers
Given an array A[], write a function that segregates even and odd numbers. 
The functions should put all even numbers first, and then odd numbers.

Example
Input  = {12, 34, 45, 9, 8, 90, 3}
Output = {12, 34, 8, 90, 45, 9, 3} 
In the output, order of numbers can be changed, i.e., in the above example 34 can come before 12 and 3 can come before 9.
*/
public class OddEven {

	public static void main(String[] args) {
		OddEven OE = new OddEven();
		
		int [] A = {12, 34, 45, 9, 8, 90, 3};
		
		OE.separateOddEven(A);
		for (int i: A) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public void separateOddEven(int [] A) {
		int len = A.length;
		
		int low = 0;
		int high = len-1;
		
		while (low < high) {
			while (A[low] % 2 == 0) {
				++low;
			}
			while (A[high] %2 == 1) {
				--high;
			}
			int temp = A[low];
			A[low] = A[high];
			A[high] = temp;
			
			++low;
			--high;
		}
		
		return ;
	}
}
