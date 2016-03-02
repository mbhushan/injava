package i_RepeatedNumber;

import java.util.List;

public class RepeatedNumber {

	public static void main(String[] args) {
		int [] A = {3, 4, 1, 4, 1};
		getRepeating(A);
		//printRepeating1(A);
		int arr[] = {4, 2, 4, 5, 2, 3, 1};
		getRepeating(arr);
		//printRepeating1(arr);
	}
	
	static void getRepeating(int arr[])
	{
		int size = arr.length;
	  int [] count = new int[size];
	  int i;
	   
	  System.out.println("repeating elements are: ");
	  for(i = 0; i < size; i++)
	  {  
	    if(count[arr[i]] == 1)
	      System.out.println("arr[i] : " + arr[i]);
	    else
	     count[arr[i]]++;
	  }    
	}   
	
	public int repeatedNumber(final List<Integer> a) {
		int len = a.size();
		int [] arr = new int[len];
		for (int i=0; i<len; i++) {
			arr[i] = a.get(i).intValue();
		}
		return printRepeating(arr);
	}
	
	static int fact(int n)
	{
	   return (n == 0)? 1 : n*fact(n-1);
	}  
	static int printRepeating1(int arr[])
	{
		int size = arr.length ;
	  int S = 0;  /* S is for sum of elements in arr[] */
	  int P = 1;  /* P is for product of elements in arr[] */ 
	  int x,  y;   /* x and y are two repeating elements */
	  int D;      /* D is for difference of x and y, i.e., x-y*/
	  int n = size - 2,  i;
	 
	  /* Calculate Sum and Product of all elements in arr[] */
	  for(i = 0; i < size; i++)
	  {
	    S = S + arr[i];
	    P = P*arr[i];
	  }        
	   
	  S = S - n*(n+1)/2;  /* S is x + y now */
	  P = P/fact(n);         /* P is x*y now */
	   
	  D = (int) Math.sqrt(S*S - 4*P); /* D is x - y now */
	   
	  x = (D + S)/2;
	  y = (S - D)/2;
	   
	  System.out.println("The two repeating elements are x: " + x + " y: " + y);
	  return y;
	}     
	static int printRepeating(int arr[])
	{
		int size = arr.length;
	  int xor = arr[0]; /* Will hold xor of all elements */
	  int set_bit_no;  /* Will have only single set bit of xor */
	  int i;
	  int n = size-2;
	  int x = 0, y = 0;
	   
	  /* Get the xor of all elements in arr[] and {1, 2 .. n} */
	  for(i = 1; i < size; i++)
	    xor ^= arr[i];  
	  for(i = 1; i <= n; i++)
	    xor ^= i;   
	 
	  /* Get the rightmost set bit in set_bit_no */
	  set_bit_no = xor & ~(xor-1);
	 
	  /* Now divide elements in two sets by comparing rightmost set
	   bit of xor with bit at same position in each element. */
	  for(i = 0; i < size; i++)
	  {
	    if((arr[i] & set_bit_no) > 0)
	      x = x ^ arr[i]; /*XOR of first set in arr[] */
	    else
	      y = y ^ arr[i]; /*XOR of second set in arr[] */
	  }
	  for(i = 1; i <= n; i++)
	  {
	    if((i & set_bit_no) > 0)
	      x = x ^ i; /*XOR of first set in arr[] and {1, 2, ...n }*/
	    else
	      y = y ^ i; /*XOR of second set in arr[] and {1, 2, ...n } */
	  }
	   
	  System.out.println("The two repeating elements are x: " + x + " y: " + y);
	  return x;
	}     
}
