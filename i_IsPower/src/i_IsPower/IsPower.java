package i_IsPower;

public class IsPower {
	public static boolean isPower(int a) {
	if (a == 1) {
        return true;
    }
    
    final int LIMIT = (int) (Math.sqrt(a));
    for (int n = 2; n <= LIMIT; n++) {
    	int p = 2;
    	int powerResult = (int) (Math.pow(n, p));

    	while (powerResult < a) {
    		powerResult = (int) (Math.pow(n, ++p));
    	}
    	
    	if (powerResult == a) {
    		return true;
    	}
    }
    
    return false;
	}
	
	public static void main(String [] args) {
		int [] A = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		for (int i=0; i<A.length; i++) {
			System.out.println(A[i]+ ": " + isPower(A[i]));
		}
	}

}
