package i_Excel2;

public class NumToString {
	public static String convertToTitle(int a) {
        String r = "";
        while (a > 0) {
            r = (char)(65 + (a - 1) % 26) + r;
            a = (a - 1) / 26;
        }
        return r;
    }
	
	public static void main(String [] args) {
		int [] A = {1,2,3,27,28,29};
		for (int i=0; i<A.length; i++) {
			System.out.println(A[i] + ": " + convertToTitle(A[i]));
		}
	}

}
