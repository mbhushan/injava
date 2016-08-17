package vm_EventProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

public class EventProcessing {

	public static void main(String[] args) {
		readInput();
	}
	
	public static void readInput() {
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String tc = br.readLine().trim();
			int N = Integer.parseInt(tc);
			int testCaseCount = 0;
			String input = null;
			while (true) {
				input = br.readLine();
				if (input == null) {
					break;
				}
				if (input.length() < 1) {
					break;
				}
				++testCaseCount;
				if (testCaseCount > N) {
					//handle the wrong input
					String fail = "FAILURE => WRONG INPUT (LINE " + (testCaseCount+1) + ")";
					sb.append(fail + " \n");
					continue;
					//System.out.println("wrong input");
					
				}
				String [] strs = input.split(" ");
				String result = processInput(strs, testCaseCount+1);
				sb.append(result + "\n");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(sb.toString());
	}
	
	private  static String processInput(String [] input, int lineNum) {
		int [] numArr = new int[input.length];
		BitSet bits = new BitSet(Integer.MAX_VALUE);
		int max = 0;
		
		boolean badinput = false;
		for (int i=0; i<input.length; i++) {
			try {
				numArr[i] = Integer.parseInt(input[i]);
			} catch(NumberFormatException e) {
				badinput = true;
				//e.printStackTrace();
			}
			bits.set(numArr[i]);
			if (numArr[i] > max) {
				max = numArr[i];
			}
			
		}
		if (badinput) {
			return "FAILURE => WRONG INPUT (LINE " + lineNum + ")";
		}
		boolean failure = false;
		int count = 0, i = 0;
		String result = "";
		for (i=1; i<= max; i++) {
			if (!bits.get(i)) {
				failure = true;
				break;
			}
			++count;
		}
		//System.out.println("count: " + count);
		if(!failure) {
			result = "SUCCESS => RECEIVED: " + max;
		} else {
			result = "FAILURE => RECEIVED: " + input.length + ",  EXPECTED: " + max;
		}
		//System.out.println(result);
		return result;
		
	}
}
