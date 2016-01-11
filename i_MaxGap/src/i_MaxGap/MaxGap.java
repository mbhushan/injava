package i_MaxGap;

import java.util.List;

public class MaxGap {
	
	public int maximumGap(final List<Integer> a) {
		int maxgap = -1;
		int n = a.size();
		int start=0, end=n-1;
		while (start < end) {
			if (a.get(start) <= a.get(end)) {
				maxgap = end - start;
				break;
			}
		}
		return maxgap;
	}

}
