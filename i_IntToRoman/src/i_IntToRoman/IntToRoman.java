package i_IntToRoman;

public class IntToRoman {

	public static String intToRoman(int a) {
	    String [] dict = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int [] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};  
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<13; i++) {
            if(a >= val[i]) {
                int count = a/val[i];
                a %= val[i];
                for(int j=0; j<count; j++) {
                    sb.append(dict[i]);
                }
            }
        }
        return sb.toString();
	}
	
	public static void main(String [] args) {
		int n = 20;
		for (int i=1; i<=20; i++) {
			System.out.println(i + ", roman: " + intToRoman(i));
		}
	}
}
