package i_Boggle;

import java.util.HashSet;

public class Boggle {

	private static String [] dictionary = {"GEEKS", "FOR", "QUIZ", "GO"};
	private static HashSet<String> hset = new HashSet<String>();
	 private static int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
     private static int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};

	
	public static void main(String[] args) {
		char [][] boggle = {{'G','I','Z'},
                {'U','E','K'},
                {'Q','S','E'}};
		
		findWords(boggle);
	}
	
	public static void findWords(char [][] boggle) {
		
		int row = boggle.length;
		int col = boggle[0].length;
		
		for (int i=0; i<dictionary.length; i++) {
			hset.add(dictionary[i]);
		}
		
		//mark all chars as non visited.
		boolean [][] visited = new boolean[row][col];
		
		StringBuffer sb = new StringBuffer();
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				findWordsUtil(boggle, visited, i, j, sb);
			}
		}
	}
	
	private static void findWordsUtil(char [][] boggle, boolean [][]visited, int i, int j, StringBuffer sb) {
		visited[i][j] = true;
		
		sb.append(boggle[i][j]);
		
		if (hset.contains(sb.toString())) {
			System.out.println(sb.toString());
		}
		
		for (int row = i-1; row <= i+1 && row < boggle.length; row++) {
			for (int col = j-1; col <= j+1 && col < boggle[0].length; col++) {
				if (row >= 0 && col >= 0 && !visited[row][col]) {
					findWordsUtil(boggle, visited, row, col, sb);
				}
			}
		}
		
		sb.deleteCharAt(sb.length()-1);
		visited[i][j] = false;
	}
}
