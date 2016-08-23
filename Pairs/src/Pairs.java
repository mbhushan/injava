import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Pairs {

	public static void main(String[] args) {
		int [] a = {3,3,5,6,6,9,1};
		int k = 12;
		
		System.out.println(numberOfPairs(a, k));
	}
	static int numberOfPairs(int[] a, long k) {
        if (a == null || a.length < 1) {
            return 0;
        }
        
        ArrayList<Long> nums = new ArrayList<Long>();
        Map<Long, Integer> hmap = new HashMap<Long, Integer>();
        for (int i=0; i<a.length; i++) {
        	long val = (long)a[i];
        	int count = 0;
        	if (hmap.containsKey(val)) {
        		count = hmap.get(val);
        	} else {
        		nums.add(val);
        	}
        	++count;
        	hmap.put((long) a[i], count);
        }
       int pairs = 0;
        for (long n: nums) {
        	long m = k - n;
        	if (hmap.containsKey(m)) {
        		if ((n == m) && (hmap.get(n) > 1)) {
        			++pairs;
        			
        		} else {
        			++pairs;
        		}
        		hmap.remove(n);
        		if (m != n) {
        			hmap.remove(m);
        		}
        	}
        	
        }
        
        return pairs;

    }
}
