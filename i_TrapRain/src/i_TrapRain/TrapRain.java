package i_TrapRain;

import java.util.ArrayList;
import java.util.List;

public class TrapRain {
	
	public static void main(String[] args) {
		int [] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		ArrayList<Integer> X = new ArrayList<Integer>();
		int n = A.length;
		
		for (int i=0; i<n; i++) {
			X.add(A[i]);
		}
		int result = trap(X);
		System.out.println("trap: " + result);
	}

	public static int trap(final List<Integer> height) {
		int result = 0;
		int size = height.size(); 
	    if(height==null || height.size() <= 2)
	        return result;
	 
	    int left[] = new int[size];
	    int right[]= new int[size];
	 
	    //scan from left to right
	    int max = height.get(0);
	    left[0] = height.get(0);
	    for(int i=1; i< size; i++){
	        if(height.get(i).intValue() < max){
	            left[i] = max;
	        }else{
	            left[i] = height.get(i).intValue();
	            max = height.get(i).intValue();
	        }
	    }
	 
	    //scan from right to left
	    max = height.get(size-1);
	    right[size-1]=height.get(size-1);
	    for(int i=size-2; i>=0; i--){
	        if(height.get(i).intValue() < max){
	            right[i]=max;
	        }else{
	            right[i]=height.get(i).intValue();
	            max = height.get(i).intValue();
	        }
	    }
	 
	    //calculate totoal
	    for(int i=0; i<size; i++){
	        result += Math.min(left[i],right[i])-height.get(i).intValue();
	    }
	 
	    return result;
	}
}
