
public class SleepMessages {

	public static void main(String [] args) throws InterruptedException {
		String [] impinfo = {"Mani", "Bhushan", "Archana", "Shreyansh", "Kumari"};
		
		for (int i=0; i<impinfo.length; i++) {
			//pause for 4 seconds
			Thread.sleep(4000);
			System.out.println(impinfo[i]);
		}
	}
}
