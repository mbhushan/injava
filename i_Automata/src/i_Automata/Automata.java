package i_Automata;

import java.util.ArrayList;
import java.util.HashMap;

public class Automata {

	 public static int automata(ArrayList<Integer> a, ArrayList<Integer> b,
	            ArrayList<Integer> c, int D, int n) {
	        HashMap<Integer, Integer> map = new HashMap<>();
	        int[][] table = new int[a.size()][n + 1];
	        for (int i = 0; i < c.size(); i++) {
	            map.put(c.get(i), 1);
	        }
	        for (int i = 0; i < a.size(); i++) {
	            if (map.containsKey(i))
	                table[i][0] = 1;
	        }
	        for (int i = 1; i <= n; i++) {
	            for (int j = 0; j < a.size(); j++) {
	                table[j][i] = table[a.get(j)][i - 1] + table[b.get(j)][i - 1];
	            }
	        }

	        return table[D][n];
	    }
}
