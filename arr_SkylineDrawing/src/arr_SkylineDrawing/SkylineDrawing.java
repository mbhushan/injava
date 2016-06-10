package arr_SkylineDrawing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SkylineDrawing {

	public static void main(String[] args) {
		SkylineDrawing sd = new SkylineDrawing();
		
		Building [] buildings = new Building[5];
		
		buildings[0] = new Building(1, 3, 3);
		buildings[1] = new Building(2, 4, 4);
		buildings[2] = new Building(5, 8, 2);
		buildings[3] = new Building(6, 7, 4);
		buildings[4] = new Building(8, 9, 4);
		
		int len = buildings.length;
		Stripe [] stripes = new Stripe[len*2];
		
		
		int index = 0;
		for (int i=0; i<buildings.length; i++) {
			Building B = buildings[i];
			stripes[index++] = new Stripe(B.x1, B.height, true);
			stripes[index++] = new Stripe(B.x2, B.height, false);
		}
		
		Arrays.sort(stripes, new StripeComparator());
		for (int i=0; i<stripes.length; i++) {
			System.out.println(stripes[i].toString());
		}
		sd.skyline(stripes);
	}
	
	public ArrayList<Stripe> skyline(Stripe [] stripes) {
		ArrayList<Stripe> result = new ArrayList<Stripe>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
		
		maxHeap.add(0);
		int maxVal = 0;
		for (int i=0; i<stripes.length; i++) {
			Stripe strip = stripes[i];
			if (strip.isStart) {
				maxHeap.add(strip.height);
				if (maxVal != maxHeap.peek()) {
					result.add(strip);
					maxVal = maxHeap.peek();
				}
			} else {
				maxHeap.remove(strip.height);
				if (maxVal != maxHeap.peek()) {
					strip.height = maxHeap.peek();
					result.add(strip);
					if (maxHeap.peek() < maxVal) {
						maxVal = maxHeap.peek();
					}
				}
			}
		}
		
		System.out.println("skyline points:");
		for (Stripe r: result) {
			System.out.println(r.toString());
		}
		
		return result;
	}
}

class StripeComparator implements Comparator<Stripe> {

	@Override
	public int compare(Stripe o1, Stripe o2) {
		if (o1.x < o2.x) {
			return -1;
		} else if (o1.x > o2.x) {
			return 1;
		} else {
			if (o1.isStart && o2.isStart) {
				return o2.height - o1.height;
			} else if (!o1.isStart && !o2.isStart) {
				return o1.height - o2.height;
			} else  {
				if (o1.isStart || o2.isStart) {
					return -1;
				} else {
					return 1;
				}
			}
		}
	}
	
}

class Stripe {
	int x;
	int height;
	boolean isStart;
	
	public Stripe(int x, int height, boolean isStart) {
		this.x = x;
		this.height = height;
		this.isStart = isStart;
	}
	
	public String toString() {
		String st = "[" + x + ", " + height + ", " + isStart + "]";
		return st;
	}
}

class Building {
	int x1;
	int x2;
	int height;
	
	public Building(int x1, int x2, int ht) {
		this.x1 = x1;
		this.x2 = x2;
		this.height = ht;
	}
}
