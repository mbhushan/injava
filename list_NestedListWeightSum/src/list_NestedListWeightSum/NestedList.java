package list_NestedListWeightSum;

import java.util.List;

/*
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
*/
public class NestedList {
	public static void main(String[] args) {
		NestedList nl = new NestedList();
		nl.nestedSum(null);
	}
	
	public int nestedSum(List<NestedInteger>  nlist) {
		return nestedSum(nlist, 0);
	}
	
	private int nestedSum(List<NestedInteger> nlist, int depth) {
		if (nlist == null || nlist.size() == 0) {
			return 0;
		}
		int sum = 0;
		for (NestedInteger ni: nlist) {
			if(ni.isInteger()) {
				sum += ni.getInteger() * depth;
			} else {
				sum += nestedSum(ni.getList(), depth+1);
			}
		}
		return sum;
	}
}

class NestedInteger {
	
	public boolean isInteger() {
		return false;
	}
	
	public List getList() {
		return null;
	}
	
	public int getInteger() {
		return 0;
	}
}
