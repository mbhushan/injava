package rec_StarCombinations;

import java.util.ArrayList;

/*
Generate all combination which prints star in place of absent characters 
*/

public class StarCombinations {
	
	public static void main(String[] args) {
		StarCombinations sc = new StarCombinations();
		
		int [] digits = {1,2,3};
		sc.genCombinations(digits);
	}
	
	public void genCombinations(int [] digits) {
		if (digits == null || digits.length < 1) {
			return;
		}
		genCombinations(digits, 0, new boolean[digits.length]);
		System.out.println("trying another method:");
		combine(digits, 0, new boolean[digits.length]);
	}
	
	public void combine(int input[], int pos, boolean used[]){
        printArray(input, used);
        for(int i= pos; i < input.length; i++){
            used[i] = true;
            combine(input, i+1, used);
            used[i] = false;
        }
    }
    
    private void printArray(int result[], boolean used[]){
        for(int i=0; i < used.length; i++){
            if(used[i]){
                System.out.print(result[i] + " ");
            }else{
                System.out.print("* ");
            }
        }
        System.out.println();
    }
	
	private void genCombinations(int [] digits, int index, boolean [] visited) {
		
		printCombination(visited, digits);
		
		for (int i=index; i<digits.length; i++) {
			visited[i] = true;
			genCombinations(digits, i+1, visited);
			visited[i] = false;
		}
	}
	
	private void printCombination(boolean [] visited, int [] digits) {
		for (int i=0; i<visited.length; i++) {
			if (visited[i]) {
				System.out.print(digits[i]);
			} else {
				System.out.print("*");
			}
		}
		System.out.println();
	}
}
