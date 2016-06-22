package in_CheckNumber;

/*
Write an function to judge whether the input String is a number? 
For example: "-3.3425","80.0", both of them are number
*/
public class CheckNumber {
	
	public static void main(String[] args) {
		CheckNumber cn = new CheckNumber();
		
		String [] ip = {"-3.3425", "-123", "23", "80.9"};
		for (int i=0; i<ip.length; i++) {
			boolean ans = cn.isNumber(ip[i]);
			System.out.println(ip[i] + " is number: " + ans);
		}
		
	}
	
	public boolean isNumber(String str) {
		if(str==null) return false;
		return str.split("(^-)?\\d+(\\.)*\\d*").length == 0;
	}
	
	public boolean isNum(String input) {
		if (input == null || input.length() < 1) {
			return false;
		}
		
		String [] strArr = input.split("\\.");
		if (strArr.length == 2) {
			System.out.println(strArr[0] +" . " + strArr[1]);
		} else if (strArr.length == 1) {
			System.out.println(strArr[0]);
		} else {
			return false;
		}
		
		return true;
	}
}
