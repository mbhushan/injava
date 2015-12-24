package i_Excel;


public class ExcelNum {
	public static int titleToNumber(String a) {
	    int num = 0;
	    int n = a.length();
        for (int i = 0; i < n; i ++) {
            num = num * 26 + a.charAt(i) - 64;
        }
        return num;
	}
	
	public static void main(String [] args) {
		String [] A = {"A", "B", "C", "AA", "AB", "AC"};
		for (int i=0; i<A.length; i++) {
			System.out.println(A[i] + ": " + titleToNumber(A[i]));
		}
	}
}
