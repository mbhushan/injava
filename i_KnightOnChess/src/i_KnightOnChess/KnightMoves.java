package i_KnightOnChess;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Point {
    private int x;
    private int y;
    public boolean visited;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
        this.visited = false;
    }
    public  ArrayList<Point> adj(int i, int j) {
        ArrayList<Point> result = new ArrayList<Point>();
        result.add(new Point(i - 2, j - 1));
        result.add(new Point(i - 1, j - 2));
        result.add(new Point(i + 1, j - 2));
        result.add(new Point(i + 2, j - 1));
        result.add(new Point(i - 2, j + 1));
        result.add(new Point(i - 1, j + 2));
        result.add(new Point(i + 1, j + 2));
        result.add(new Point(i + 2, j + 1));
        
        return result;
    }
}

public class KnightMoves {

	private int moves;
	
	public static ArrayList<Point> adj(int i, int j) {
        ArrayList<Point> result = new ArrayList<Point>();
        result.add(new Point(i - 2, j - 1));
        result.add(new Point(i - 1, j - 2));
        result.add(new Point(i + 1, j - 2));
        result.add(new Point(i + 2, j - 1));
        result.add(new Point(i - 2, j + 1));
        result.add(new Point(i - 1, j + 2));
        result.add(new Point(i + 1, j + 2));
        result.add(new Point(i + 2, j + 1));
        
        return result;
    }

	public static void main(String[] args) {
		int ans = knight(8, 8, 1, 1, 8, 8);
		System.out.println("ans: " + ans);
	}
   
    public static int knight(int N, int M, int x1, int y1, int x2, int y2) {
        int i = x1;
        int j = y1;
        int steps = -1;
        if(i == x2 && j == y2)
            return 0;
        int[][] dp = new int[N+1][M+1];
        dp[0][0] = 0;
        
        Point start = new Point(x1, y1);
        Point end = new Point(x2, y2);
        
        Queue<Point> queue = new LinkedList<Point>();
        
        for(Point p : adj(i, j)){
            p.visited = true;
            
        }
        for(i = x1 - 1; i <= x2 - 1; i++) {
            for(j = y1 - 1; j <= y2-1; j++) {
                dp[i][j] = -1;
                
            }
            
        }
        while(i != x2 && j != y2){
            
        }
        return dp[x2][y2];
        
    }
}
