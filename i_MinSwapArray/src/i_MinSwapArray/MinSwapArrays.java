package i_MinSwapArray;

/*
Minimum number of swaps required for arranging pairs adjacent to each other
There are n-pairs and therefore 2n people. everyone has one unique number ranging from 1 to 2n. 
All these 2n persons are arranged in random fashion in an Array of size 2n. We are also given who is partner of whom. 
Find the minimum number of swaps required to arrange these pairs such that all pairs become adjacent to each other.

Example:

Input:
n = 3  
pairs[] = {1->3, 2->6, 4->5}  // 1 is partner of 3 and so on
arr[] = {3, 5, 6, 4, 1, 2}

Output: 2
We can get {3, 1, 5, 4, 6, 2} by swapping 5 & 6, and 6 & 1
*/

public class MinSwapArrays {

	public static void main(String[] args) {
		int [] arr = {0, 1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
		 
	    // if (a, b) is pair than we have assigned elements
	    // in array such that pairs[a] = b and pairs[b] = a
		// 1->2, 3->4, 5->6, 7->8, 9->10
	    int [] pairs = {0, 2, 1, 4, 3, 6, 5, 8, 7, 10, 9};
	    
	    System.out.println("min swaps: " + minSwaps(pairs, arr));

	}
	
	public static int minSwaps(int pairs[],int arr[])
	{
		int n = arr.length;
	    //position array to store the index of arr[i]
	    int [] position = new int[n];
	    int pos = 0,count=0;
	    for(int i=0;i<n;i++)
	        position[arr[i]] = i;
	        
	    for(int i=1;i<n;i++)
	    {
	        if((i+1 < n) && (arr[i+1]!=pairs[arr[i]]) && (arr[i-1]!=pairs[arr[i]]))
	        {
	            System.out.println(arr[i] + " ");
	            pos = position[pairs[arr[i]]];
	            //updating the new positions in the array
	            position[arr[i+1]]=pos;
	            position[arr[pos]]=i+1;
	            //swap(arr[i+1],arr[pos]);
	            int temp = arr[i+1];
	            arr[i+1] = arr[pos];
	            arr[pos] = temp;
	            count++;
	        }
	    }
	    return count;
	}
}
