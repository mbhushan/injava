package rec_RestoreIPAddress;

import java.util.ArrayList;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *For example:
 *Given "25525511135",
 *return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */

public class RestoreIPAddress {

	public static void main(String[] args) {
		RestoreIPAddress rip = new RestoreIPAddress();
		
		String input = "25525511135";
		rip.restoreIPAddress(input);
	}
	
	public void restoreIPAddress(String address) {
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		int index = 0;
		char [] input = address.toCharArray();
		System.out.println("IP restored as: ");
		restoreIPAddress(input, index, result);
	}
	
	private void restoreIPAddress(char [] address, int index, ArrayList<Integer> result) {
		if (index == address.length && result.size() == 4) {
			System.out.println(result.toString());
			return;
		}
		
		if (index >= address.length) {
			return;
		}
		
		int num = 0;
		for (int i=0; i<3; i++) {
			if (index+i < address.length) {
				num = num*10 + Character.getNumericValue(address[index+i]);
				if (num > 255) {
					continue;
				}
				result.add(num);
				restoreIPAddress(address, index+i+1, result);
				result.remove(result.size()-1);
			}
		}
	}
}
