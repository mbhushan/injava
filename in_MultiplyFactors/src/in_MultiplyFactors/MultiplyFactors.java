package in_MultiplyFactors;

public class MultiplyFactors {

	public static void main(String[] args) {
		MultiplyFactors mf = new MultiplyFactors();
		mf.findFactors(100);
	}

	public void findFactors(int value) {
		for (int a = 1; a < value; a++) {
			if (value % a == 0) {
				int c = value / a;

				if (c >= a) {
					System.out.println(c + " * " + a);
				} else {
					for (int k = 2; k < a; k++) {
						if (a%k == 0) {
							// printf ("%d * %d * %d\t", c, k, k);
							System.out.println(c + " * " + k + " * " + (a/k));
						}
						//System.out.println();
					}
				}
			}
		}
	}
}
