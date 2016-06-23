package in_FlowerBed;

/*Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die. Given a flowerbed (represented as an array containing booleans), return if a given number of new flowers can be planted in it without violating the no-adjacent-flowers rule 
Sample inputs 

Input: 1,0,0,0,0,0,1,0,0 

3 => true 
4 => false 
Input: 1,0,0,1,0,0,1,0,0 

1 => true 
2 => false 
input: 0 

1 => true 
2 => false 
*/ 

public class FlowerBed {

	public static void main(String[] args) {
		FlowerBed fb = new FlowerBed();

		int [] flowers = {1, 2, 3, 4};
		for (int i=0; i<flowers.length; i++) {
			int [] A = {1,0,0,0,0,0,1,0,0};
			System.out.println("flowerbed placements for " + flowers[i] + ": " + fb.flowerBed(A, flowers[i]));
		}
	}
	
	public boolean flowerBed(int [] A, int flowers) {
		if (A == null || A.length < 1) {
			throw new IllegalArgumentException("bed is empty!");
		}
		
		if (A.length == 1) {
			return (A[0] == 0) && (flowers <= 1);
		}
		
		int counter = 0;
		
		for (int i=0; i<A.length; i++) {
			if (A[i] == 0) {
				if ((i == 0 && A[i+1] == 0) ||
					(i == A.length-1 && A[i-1] == 0) ||
					(A[i+1] == 0 && A[i-1] == 0)
						) {
					A[i] = 1;
					++counter;
					if (counter == flowers) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
}
