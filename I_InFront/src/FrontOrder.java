import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



public class FrontOrder {

	
	public static ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
	    int n = heights.size();
		ArrayList<MyPair> pairs = new ArrayList<>(n);
		Integer result[] = new Integer[n];
        
        for (int i = 0; i < n; i++) 
            pairs.add(new MyPair(heights.get(i), infronts.get(i)));
        
        Collections.sort(pairs, (o1, o2) -> o1.h.compareTo(o2.h));
        for (int i = 0; i < n; i++) {
            MyPair current = pairs.get(i);
            int count = current.i;
            int j = 0;
            for (; j < n && count > 0; j++) {
                if (result[j] == null) {
                    count--;
                }
            }
            while(result[j] != null) j++;
            result[j] = current.h;
        }
        return new ArrayList<>(Arrays.asList(result));
    }

    private static class MyPair{
        Integer h;
        Integer i;

        public MyPair(int h, int i) {
            this.h = h;
            this.i = i;
        }

        @Override
        public String toString() {
            return "("+h+","+i+")";
        }
    }

}
