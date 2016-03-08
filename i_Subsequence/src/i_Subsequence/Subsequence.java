package i_Subsequence;

import java.util.HashMap;

public class Subsequence {

	private static HashMap<String, Integer> hmap = new HashMap<String, Integer>();

    public static void subsequence(String prefix, String remaining, int k) {
        if (k == 0) {
            System.out.println(prefix);
            int count = 1;
            if (hmap.containsKey(prefix)) {
            	count  = hmap.get(prefix);
            	++count;
            } 
            hmap.put(prefix, count);
            return ;
        }
        if (remaining.length() == 0) return;
        subsequence(prefix + remaining.charAt(0), remaining.substring(1), k-1);
        subsequence(prefix, remaining.substring(1), k);
    }


    public static void main(String[] args) { 
        String s = "aabb";
       System.out.println("any two: "  + anytwo(s));
        //sequence(s);
    }
    
    public static void sequence(String s) {
    	int length = s.length();
    	 for( int c = 0 ; c < length ; c++ )
         {
            for( int i = 1 ; i <= length - c ; i++ )
            {
              String prefix = s.substring(c, c+i);
              if (prefix.length() < 2) continue;
              int count = 1;
              if (hmap.containsKey(prefix)) {
              	count  = hmap.get(prefix);
              	++count;
              } 
              hmap.put(prefix, count);
              // System.out.println(sub);
            }
         }
    }
    
	public static int anytwo(String a) {
		//subsequence("", a, 2);
		sequence(a);
		for (String key: hmap.keySet() ) {
			System.out.println("key: " + key + " val: " +hmap.get(key));
			if (hmap.get(key) > 1) {
				return 1;
			}
		}
		
		return 0;

	}

}
