import java.io.BufferedReader;
import java.io.InputStreamReader;


public class RandIntClient {
	public static int MIN = 0;
	public static int MAX = 0;
	public static int COUNT = 10;
	public static void main(String [] args) {
		
		readInput();
		System.out.println("Random numbers: ");
		for (int i=0; i < COUNT; i++) {
			int rVal = RandInt.randInt(MIN, MAX);
			System.out.print(rVal + " ");
		}
		System.out.println();
	}
	
	public static void readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String str = br.readLine();
			String [] strArr = str.split(" ");
			MIN = Integer.parseInt(strArr[0]);
			MAX = Integer.parseInt(strArr[1]);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
