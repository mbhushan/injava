package i_DNum;

import java.util.ArrayList;
import java.util.HashMap;

public class DNum {
	
	public static void main(String[] args) {
		int [] X = {1, 2, 1, 3, 4, 3};
		ArrayList<Integer> A = new ArrayList<Integer>();
		for (int i=0; i<X.length; i++) {
			A.add(X[i]);
		}
		int B = 3;
		A = dNums(A, B);
	}

	 public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		 ArrayList<Integer> ret = new ArrayList<Integer>();
		 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		 int n = A.size();
		 
		 for(int i = 0; i < n; i++){
		        //increase key
			 	int count = 1;
			 	if (map.containsKey(A.get(i).intValue())) {
			 		count = map.get(A.get(i).intValue());
			 		++count;
			 	}
		        map.put(A.get(i).intValue(), count) ;
		        
		        if((i - B + 1) >= 0){
		 
		            //decrease key
		            ret.add(map.size());
		            count = map.get(A.get(i-B+1).intValue());
		            --count;
		            map.put(A.get(i-B+1).intValue(), count);
		 
		            //remove if count becomes 0
		            if(count == 0) {
		            	map.remove(A.get(i-B+1).intValue());
		            }
		        }
		    }
		 
		 for (Integer i: ret) {
			 System.out.print(i + " ");
		 }
		 System.out.println();
		     
		    return ret;
	 }
}
