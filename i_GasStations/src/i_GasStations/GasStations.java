package i_GasStations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GasStations {
	
	public static void main(String[] args) {
		Integer gas[] = {1, 2};
	    Integer cost[] = {2, 1};
	    
	    ArrayList<Integer> gasList = new ArrayList<Integer>();
	    ArrayList<Integer> costList = new ArrayList<Integer>();
	    
	    Collections.addAll(gasList, gas);
	    Collections.addAll(costList, cost);
	    
	    System.out.println("complete route: " + canCompleteCircuit(gasList, costList));
	}

	public static int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
		int sumRemaining = 0; 
		int total = 0; 
		int start = 0; 
		int gaslen = gas.size();
		for (int i = 0; i < gaslen; i++) {
			int remaining = gas.get(i).intValue() - cost.get(i).intValue();
	 
			//if sum remaining of (i-1) >= 0, continue 
			if (sumRemaining >= 0) { 
				sumRemaining += remaining;
			//otherwise, reset start index to be current
			} else {
				sumRemaining = remaining;
				start = i;
			}
			total += remaining;
		}
	 
		if (total >= 0){
			return start;
		}else{
			return -1;
		}
	}
}
