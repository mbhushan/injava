package arr_PetrolBunks;

import java.util.Random;

public class PetrolBunks {

	public int findStartPoint(int [] petrol, int [] distance) {
		int len = petrol.length;
		
		Random rand = new Random();
		int r = rand.nextInt(len);
		int start = r;
		int end = r;
		
		if (r == len-1) {
			end = 0;
		} else {
			end = r+1;
		}
		int availablePetrol = petrol[r];
		int requiredPetrol = distance[r];
		while (start != end) {
			if (availablePetrol >= requiredPetrol) {
				if (end == len-1) {
					end = 0;
				} else {
					end = end + 1;
				}
				availablePetrol += petrol[end];
				requiredPetrol += distance[end];
			} else {
				if (start == 0) {
					start = len-1;
				} else {
					start = start - 1;
				}
				availablePetrol += petrol[start];
				requiredPetrol += distance[start];
			}
		}
		if (availablePetrol >= requiredPetrol) {
			return start;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		PetrolBunks PB = new PetrolBunks();
		
		int [] petrol = {3, 5, 1, 10};
		int [] distance = {5, 6, 2, 6};
		
		System.out.println("starting index: " + PB.findStartPoint(petrol, distance));
		
		int [] P = {4, 6, 7, 4};
		int [] D = {6, 5, 3, 5};
		System.out.println("starting index: " + PB.findStartPoint(P, D));
	}
}
