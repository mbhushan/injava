package i_CombinationNChooseR;

import java.util.ArrayList;

public class Combination {

	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		

        // A temporary array to store all combination one by one
        int data[]=new int[k];
 
        // Print all combination using temprary array 'data[]'
        combinationUtil(n, k, 0, data, 0, result);
		return result;
	}
	
	private static ArrayList<Integer> convertArrayToList(int[] num) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}
	
	/*Driver function to check for above function*/
    public static void main (String[] args) {
        //int arr[] = {1, 2, 3, 4, 5};
        int k = 2;
        int n = 5;
        //printCombination(arr, n, r);
        ArrayList<ArrayList<Integer>> result = combine( n, k) ;
        for (ArrayList<Integer> R: result) {
        	System.out.println(R);
        }
    }
	
	    /* arr[]  ---> Input Array
	    data[] ---> Temporary array to store current combination
	    start & end ---> Staring and Ending indexes in arr[]
	    index  ---> Current index in data[]
	    r ---> Size of a combination to be printed */
	   public static void combinationUtil(int n, int r, int index,
	                                int data[], int i, ArrayList<ArrayList<Integer>> result)
	    {
	        // Current combination is ready to be printed, print it
	        if (index == r)
	        {
//for (int j=0; j<r; j++)
//	                System.out.print(data[j]+" ");
//	            System.out.println("");
	        	ArrayList<Integer> item = convertArrayToList(data);
				result.add(item);
	        return;
	        }
	 
	        // When no more elements are there to put in data[]
	        if (i >= n)
	        return;
	 
	        // current is included, put next at next location
	        data[index] = i+1;
	        combinationUtil(n, r, index+1, data, i+1, result);
	 
	        // current is excluded, replace it with next (Note that
	        // i+1 is passed, but index is not changed)
	        combinationUtil(n, r, index, data, i+1, result);
	    }
	 
	    // The main function that prints all combinations of size r
	    // in arr[] of size n. This function mainly uses combinationUtil()
//	    public static void printCombination(int arr[], int n, int r)
//	    {
//	        // A temporary array to store all combination one by one
//	        int data[]=new int[r];
//	 
//	        // Print all combination using temprary array 'data[]'
//	        combinationUtil(n, r, 0, data, 0);
//	    }
	 
	    
}
