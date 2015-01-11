import java.util.Random;


public class RandInt {
	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randNum = rand.nextInt((max - min) + 1) + min;
		return randNum;
	}
}
