import java.io.BufferedReader;
import java.io.InputStreamReader;


public class LoanPayment {
	public static int YEAR = 0;
	public static double PRINCIPAL = 0;
	public static double RATE = 0;
	
	public static void main(String [] args) {
		readInput();
		
		double monthlyPay = PRINCIPAL * Math.pow(Math.E, ((RATE/100.0) * YEAR));
		System.out.printf("Monthly payment: %6.3f", monthlyPay);
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String st = br.readLine();
			String [] strArr = st.split(" ");
			YEAR = Integer.parseInt(strArr[0].trim());
			PRINCIPAL = Double.parseDouble(strArr[1].trim());
			RATE = Double.parseDouble(strArr[2].trim());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
