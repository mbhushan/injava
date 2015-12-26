package i_PrettyPrintMatrix;

import java.util.ArrayList;

public class PrettyPrint {
	public static ArrayList<ArrayList<Integer>> prettyPrint(int a) {
	    int A = a;
ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A <= 0) {
            return result;
        }
        // initialize matrix
        int n = 2 * A - 1;
        int[][] matrix = new int[n][n];

        // update matrix
        int i = 0;
        int j = 0;
        int dir = 0;
        for (int num = A; num > 0; num--) {
            // watch the corner case when num = 1
            int size = num == 1 ? 1 
                    : (2 * num - 1) * (2 * num - 1) - (2 * num - 3) * (2 * num - 3);
            int count = 0;
            while (count < size) {
                // print number in a circle
                count++;
                matrix[i][j] = num;
                if (dir == 0) {
                    j++; // move to right
                    if (j == n || matrix[i][j] != 0) {
                        dir = 1;
                        j--;
                        i++;
                    }
                } else if (dir == 1) {
                    i++; // move downwards
                    if (i == n || matrix[i][j] != 0) {
                        dir = 2;
                        i--;
                        j--;
                    }
                } else if (dir == 2) {
                    j--; // move to left
                    if (j < 0 || matrix[i][j] != 0) {
                        dir = 3;
                        j++;
                        i--;
                    }
                } else {
                    i--; // move upwards
                    if (i < 0 || matrix[i][j] != 0) {
                        dir = 0;
                        i++;
                        j++;
                    }
                }
            }
        }

        // fill the result
        for (int p = 0; p < n; p++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int q = 0; q < n; q++) {
                list.add(matrix[p][q]);
            }
            result.add(list);
        }
        printMatrix(result);
        
        return result;
	}
	
	public static void printMatrix( ArrayList<ArrayList<Integer>> M) {
		int r = M.size();
		int c = M.get(0).size();
		
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				System.out.print(M.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	public static void main(String [] args) {
		int a = 4;
		prettyPrint(a);
	}

}
