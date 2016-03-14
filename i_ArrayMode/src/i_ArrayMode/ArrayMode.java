package i_ArrayMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ArrayMode {
	
	public static void main(String[] args) {
		Integer [] X = {2, 2, 2, 3, 3};
		ArrayList<Integer> A = new ArrayList<Integer>();
		Collections.addAll(A, X);
		
		Integer [] a = {1, 3};
		Integer [] b = {5, 4};
		Integer [] c = {2, 4};
		ArrayList<Integer> F = new ArrayList<Integer>();
		ArrayList<Integer> S = new ArrayList<Integer>();
		ArrayList<Integer> T = new ArrayList<Integer>();
		Collections.addAll(F, a);
		Collections.addAll(S, b);
		Collections.addAll(T, c);
		
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		B.add(F); B.add(S); B.add(T);
		
		ArrayList<Integer> result = getMode(A, B);
		for (Integer r: result) {
			System.out.print(r + " ");
		}
		System.out.println();
	}

	static HashMap<Integer, Integer> map;
	static HashMap<Integer, Integer> rmap;
    public static ArrayList<Integer> getMode(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        map = new HashMap<Integer, Integer>();
        rmap  = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int maxkey = Integer.MIN_VALUE;
        int maxval = Integer.MIN_VALUE;
         
        for(int i : A) {
        	int val = 1;
            if(map.containsKey(i)) {
            	val = map.get(i) + 1;
                map.put(i, val);
                
            } else {
                map.put(i, val);
            }

            if (val > maxval) {
            	maxkey = i;
            	maxval = val;
            } else if (val == maxval) {
            	maxkey = i;
            }
            
            if (rmap.containsKey(val)) {
            	int k = rmap.get(val);
            	if (i < k) {
            		rmap.put(val, i);
            	}
            } else {
            	rmap.put(val, i);
            }
        }
         
        for(ArrayList<Integer> update : B){
            int index = update.get(0);
            int num = update.get(1);
             
            int toUpdate = A.get(index - 1);
             int valupdate = map.get(toUpdate);
            if(map.get(toUpdate) != null) {
                valupdate = map.get(toUpdate) - 1;
                map.put(toUpdate, valupdate);
                if (maxkey == toUpdate) {
                	maxval = valupdate;
                }
            }
            
            if (rmap.containsKey(valupdate)) {
            	int k = rmap.get(valupdate);
            	if (num < k) {
            		rmap.put(valupdate, num);
            	}
            } 
            
            A.set(index - 1, num);
            int val = 1;
            if(map.containsKey(num)) {
            	val = map.get(num) + 1;
                map.put(num, val);
            }else {
                map.put(num, val);
            }
            
            
          
            if ((val > maxval)) {// && (num < maxkey)) {
            	maxkey = num;
            	maxval = val;
            } else if (val == maxval) {
            	if (num < maxkey) {
            		maxkey = num;
            	}
            }
            System.out.println("rmap: " + rmap.get(maxval));
             
            
            //System.out.println("A : " + A);
            //result.add(mode(A));
            result.add(maxkey);
        }
        return result;
    }
     
    public static int mode(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>(map);
        int modeindex = 0;
        int mode = -1;
        Iterator it = map2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(modeindex == (int)pair.getValue() && mode > (int)pair.getKey())
                mode = (int)pair.getKey();
            if(modeindex < (int)pair.getValue()){
                modeindex = (int)pair.getValue();
                mode = (int)pair.getKey();
            }
           // System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
        //System.out.println();
        return mode;
    }
}
