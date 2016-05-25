package math_MaxPointsLine;

import java.util.HashMap;


public class MaxPoints {

	public static void main(String[] args) {
		Point [] points  = {
				new Point(1, 1),
				new Point(2, 2)
		};
		
		System.out.println("max points: " + new MaxPoints().maxPoints(points));
	}
	
	public int maxPoints(Point [] points) {
		if (points == null || points.length < 1) {
			return 0;
		}
		
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		int max = 0;
		
		for (int i=0; i<points.length; i++) {
			int duplicates = 1;
			int verticals = 0;
			for (int j=i+1; j<points.length; j++) {
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y) {
						duplicates++;
					} else {
						verticals++;
					}
					String slope = "";
					if (points[j].y == points[i].y) {
						slope = "0";
					} else {
						int y = points[j].y = points[i].y;
						int x = points[j].x - points[i].x;
						slope = String.valueOf(y) + "/" + String.valueOf(x);
						int value = 0;
						if (hmap.containsKey(slope)) {
							value = hmap.get(slope);
						}
						++value;
						hmap.put(slope, value);
					}
				}
			}
			
			for (Integer cnt: hmap.values()) {
				if (cnt+duplicates > max) {
					max = cnt + duplicates;
				}
			}
			max = Math.max(verticals + duplicates, max);
			//hmap.clear();
		}
		return max;
	}
}

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
