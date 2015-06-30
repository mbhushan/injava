package a_SelectionSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionClient {

	public static void main(String [] args) {
		String [] keys = readInput();
		SelectionSort.sort(keys);
		System.out.println("Sorted Keys: ");
		SelectionSort.show(keys);
	}
	
	public static String [] readInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] keys = null;
		try {
			keys = br.readLine().trim().split(" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return keys;
	}
}


/**
 T H I S N E E D S S O R T I N G
Sorted Keys: 
D E E G H I I N N O R S S S T T 
*/