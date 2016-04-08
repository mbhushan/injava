package u_MaxRectangleHistogram;

public class HistogramClient {

	public static void main(String [] args) {
		int [] histogram = {6, 2, 5, 4, 5, 1, 6};
		Histogram hist = new Histogram();
		System.out.println("max area: " + hist.getLargestRectangleInHistogram(histogram));
	}
}
