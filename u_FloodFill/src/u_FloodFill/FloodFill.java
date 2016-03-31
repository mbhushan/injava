package u_FloodFill;

public class FloodFill {

	public static void main(String [] args) {
		int [][] screen = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
               };
		int x = 4, y = 4, newC = 3;
		floodfill(screen, x, y, newC);
		for (int i=0; i<screen.length; i++) {
			for (int j=0; j<screen[0].length; j++) {
				System.out.print(screen[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void floodfill(int [][] screen, int x, int y, int newColor) {
		int prevColor = screen[x][y];
		floodfill(screen, x, y, newColor, prevColor);
	}
	
	private static void floodfill(int [][] screen, int x, int y, int newC, int prevC) {
		//base cases.
		if (x < 0 || x >= screen.length || y < 0 || y >= screen[0].length) {
			return;
		}
		if (screen[x][y] != prevC) {
			return;
		}
		screen[x][y] = newC;
		
		//Recur for the 4 directions.
		floodfill(screen, x-1, y, newC, prevC);
		floodfill(screen, x+1, y, newC, prevC);
		floodfill(screen, x, y-1, newC, prevC);
		floodfill(screen, x, y+1, newC, prevC);
	}
}
